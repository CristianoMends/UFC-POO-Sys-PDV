package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pdv.model.Estoque;
import pdv.model.Produto;

public class EstoqueDao {

	public EstoqueDao() {}
	
	//metodo para retornar os dados dos produtos do banco e retornar em um estoque
	public Estoque getEstoqueDB() {
		Connection connection = PostgreSQLJDBC.getConnection();
		Estoque estoque = new Estoque();
		if (connection != null) {
			try {
				String query = "SELECT * FROM produto";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int 	id 			= resultSet.getInt("id");
					String 	nome 		= resultSet.getString("nome");
					double 	preco 		= resultSet.getDouble("preco");
					int 	qtdEstoque 	= resultSet.getInt("qtdEstoque");
					String 	categoria 	= resultSet.getString("categoria");
					String 	imagem 		= resultSet.getString("imagem");

					Produto produto = new Produto(id, nome, preco, qtdEstoque, categoria, imagem);

					estoque.addProduto(produto);
				}

				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				PostgreSQLJDBC.closeConnection(connection);
			}
		}
		return estoque;
	}

}
