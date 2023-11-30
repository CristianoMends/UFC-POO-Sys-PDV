package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pdv.model.entidades.Produto;

public class EstatisticasDao {
	
	 public Object[] getTotaisVendasDiaMes() {
	        Object[] rowData = new Object[2];

	        Connection connection = null;

	        try {
	            connection = PostgreSQLJDBC.getConnection();

	            String sqlDia = "SELECT CAST(SUM(total) AS NUMERIC(10, 2)) AS total_dia_atual " +
	                            "FROM venda " +
	                            "WHERE DATE(data) = CURRENT_DATE";

	            String sqlMes = "SELECT CAST(SUM(total) AS NUMERIC(10, 2)) AS total_mes_atual " +
	                            "FROM venda " +
	                            "WHERE EXTRACT(MONTH FROM data) = EXTRACT(MONTH FROM CURRENT_DATE)";

	            double totDia = 0.0;
	            try (PreparedStatement statementDia = connection.prepareStatement(sqlDia);
	                 ResultSet resultSetDia = statementDia.executeQuery()) {
	                if (resultSetDia.next()) {
	                    totDia = resultSetDia.getDouble("total_dia_atual");
	                }
	            }

	            double totMes = 0.0;
	            try (PreparedStatement statementMes = connection.prepareStatement(sqlMes);
	                 ResultSet resultSetMes = statementMes.executeQuery()) {
	                if (resultSetMes.next()) {
	                    totMes = resultSetMes.getDouble("total_mes_atual");
	                }
	            }

	            rowData[0] = String.format("R$ %.2f", totDia);
	            rowData[1] = String.format("R$ %.2f", totMes);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {

	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        return rowData;
	    }
	 public List<Object[]> getTotVendidos() {
	        List<Object[]> resultados = new ArrayList<>();

	        Connection connection = null;

	        try {
	            connection = PostgreSQLJDBC.getConnection();

	            String sql = "SELECT f.id AS id_funcionario, p.nome AS nome_funcionario, " +
	                    "CAST(SUM(v.total) AS NUMERIC(10,2)) AS total_vendido, " +
	                    "ROUND((SUM(v.total) * 0.03)::numeric, 2) AS comissao " +
	                    "FROM venda v " +
	                    "JOIN funcionario f ON v.idVendedor = f.id " +
	                    "JOIN pessoa p ON f.idPessoa = p.id " +
	                    "WHERE f.cargo = 'Vendedor' " +
	                    "AND EXTRACT(MONTH FROM v.data) = EXTRACT(MONTH FROM CURRENT_DATE) " +
	                    "GROUP BY f.id, p.nome";

	            try (PreparedStatement statement = connection.prepareStatement(sql);
	                 ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    int idFuncionario = resultSet.getInt("id_funcionario");
	                    String nomeFuncionario = resultSet.getString("nome_funcionario");
	                    double totalVendido = resultSet.getDouble("total_vendido");
	                    double comissao = resultSet.getDouble("comissao");
	                    
	                    Object[] resultado = {idFuncionario, nomeFuncionario, String.format("R$ %.2f", totalVendido),String.format("R$ %.2f", comissao)};
	                    resultados.add(resultado);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            PostgreSQLJDBC.closeConnection(connection);
	        }

	        return resultados;
	    }
	 public List<Produto> getProdutosEmFalta() {
		    List<Produto> produtosEmFalta = new ArrayList<>();
		    Connection connection = null;

		    try {
		        connection = PostgreSQLJDBC.getConnection();

		        String sql = "SELECT id, nome, preco, qtdEstoque, categoria, imagem " +
		                     "FROM produto " +
		                     "WHERE qtdEstoque = 0";

		        try (PreparedStatement statement = connection.prepareStatement(sql);
		             ResultSet resultSet = statement.executeQuery()) {

		            while (resultSet.next()) {
		                int id = resultSet.getInt("id");
		                String nome = resultSet.getString("nome");
		                float preco = resultSet.getFloat("preco");
		                int qtdEstoque = resultSet.getInt("qtdEstoque");
		                String categoria = resultSet.getString("categoria");
		                String imagem = resultSet.getString("imagem");

		                Produto produto = new Produto(id, nome, preco, qtdEstoque, categoria, imagem);
		                produtosEmFalta.add(produto);
		            }
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        PostgreSQLJDBC.closeConnection(connection);
		    }

		    return produtosEmFalta;
		}


}
