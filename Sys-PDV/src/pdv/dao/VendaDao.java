package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import pdv.model.entidades.Cliente;
import pdv.model.entidades.Pessoa;
import pdv.model.entidades.Venda;

public class VendaDao {
	
	public VendaDao() {
		
	}
	
	 public ArrayList<Venda> getVendas() {
	        ArrayList<Venda> vendas = new ArrayList<>();
	        Connection connection = null;

	        try {
	            connection = PostgreSQLJDBC.getConnection();
	            if (connection != null) {
	                String query = "SELECT id, data, idCliente FROM venda";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                        while (resultSet.next()) {
	                            int id = resultSet.getInt("id");
	                            LocalDate data = resultSet.getObject("data", LocalDate.class);
	                            int clienteId = resultSet.getInt("idCliente");

	                            // Supondo que você tenha um método para buscar um Cliente pelo ID
	                            Cliente cliente = getClienteById(clienteId);

	                            Venda venda = new Venda();
	                            venda.setId(id);
	                            venda.setData(data);
	                            venda.setCliente(cliente);

	                            // Adicione a venda à lista de vendas
	                            vendas.add(venda);
	                        }
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Lide com as exceções de maneira apropriada para sua aplicação
	        } finally {
	            PostgreSQLJDBC.closeConnection(connection);
	        }

	        return vendas;
	    }
	 
	 public Cliente getClienteById(int clienteId) {
		    Connection connection = null;
		    Cliente cliente = null;

		    try {
		        connection = PostgreSQLJDBC.getConnection();
		        if (connection != null) {
		            String query = "SELECT id, nome, endereco, email, cpf FROM cliente WHERE id = ?";
		            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                preparedStatement.setInt(1, clienteId);
		                try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                    if (resultSet.next()) {
		                        int id = resultSet.getInt("id");
		                        String nome = resultSet.getString("nome");
		                        String end = resultSet.getString("endereco");
		                        String email = resultSet.getString("email");
		                        String cpf = resultSet.getString("cpf");
		                        
		                        cliente = new Cliente(id, nome, end, email, cpf);

		                    }
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); // Lide com as exceções de maneira apropriada para sua aplicação
		    } finally {
		        PostgreSQLJDBC.closeConnection(connection);
		    }

		    return cliente;
		}
	 
	 public void adicionarVenda(Venda venda) {
	        Connection connection = null;

	        try {
	            connection = PostgreSQLJDBC.getConnection();
	            if (connection != null) {
	                // Insira a venda na tabela "venda"
	                String inserirVendaQuery = "INSERT INTO venda (data, idCliente, idVendedor) VALUES (?, ?, ?) RETURNING id";
	                try (PreparedStatement inserirVendaStatement = connection.prepareStatement(inserirVendaQuery)) {
	                    inserirVendaStatement.setObject(1, venda.getData());

	                    if (venda.getCliente() != null) {
	                        inserirVendaStatement.setInt(2, venda.getCliente().getId());
	                    } else {
	                        inserirVendaStatement.setNull(2, Types.INTEGER);
	                    }

	                    if (venda.getFuncionario() != null) {
	                        inserirVendaStatement.setInt(3, venda.getFuncionario().getId());
	                    } else {
	                        inserirVendaStatement.setNull(3, Types.INTEGER);
	                    }

	                    try (ResultSet resultado = inserirVendaStatement.executeQuery()) {
	                        if (resultado.next()) {
	                            int idVenda = resultado.getInt("id");
	                            venda.setId(idVenda);

	                            // Insira os itens da venda (produtos vendidos) em outra tabela, se necessário
	                            adicionarItensVenda(connection, venda);
	                        }
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Lide com as exceções de maneira apropriada para sua aplicação
	        } finally {
	            PostgreSQLJDBC.closeConnection(connection);
	        }
	    }

	    private void adicionarItensVenda(Connection connection, Venda venda) throws SQLException {
	        
	    }


}
