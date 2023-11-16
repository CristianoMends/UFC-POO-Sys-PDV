package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import pdv.model.Produto;

public class ProdutoDao {

	public ProdutoDao() {
	}

	// metodo para inserir produtos ao banco de dados
	public void inserirProdutoDB(Produto produto) {
		Connection connection = PostgreSQLJDBC.getConnection();

		if (connection != null) {
			try {
				String query = "INSERT INTO produto (nome, preco, qtdEstoque, categoria, imagem) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, produto.getNome());
				preparedStatement.setDouble(2, produto.getPreco());
				preparedStatement.setInt(3, produto.getQtdEstoque());
				preparedStatement.setString(4, produto.getCategoria());
				preparedStatement.setString(5, produto.getImagem());

				preparedStatement.executeUpdate();

				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				PostgreSQLJDBC.closeConnection(connection);
			}
		}
	}

	// metodo para remover produto do banco de dados
	public void removerProdutoDB(int id) {
		Connection connection = PostgreSQLJDBC.getConnection();

		if (connection != null) {
			try {
				String query = "DELETE FROM produto WHERE id = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				JOptionPane.showMessageDialog(null, "Produto removido!");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				PostgreSQLJDBC.closeConnection(connection);
			}
		}
	}

}
