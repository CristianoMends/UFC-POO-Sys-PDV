package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pdv.model.entidades.Cliente;
import pdv.model.entidades.Funcionario;

public class PessoaDao {
	
	public PessoaDao() {
		
	}
	public ArrayList<Funcionario> getFuncionarios() {
		Connection connection = PostgreSQLJDBC.getConnection();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		if (connection != null) {
			try {
				String query = "SELECT * FROM funcionario";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int 	id 			= resultSet.getInt("id");
					String 	nome 		= resultSet.getString("nome");
					String 	endereco 	= resultSet.getString("endereco");
					String 	email 		= resultSet.getString("email");
					int 	cpf 		= resultSet.getInt("cpf");
					String 	cargo 		= resultSet.getString("cargo");
					String usuario		= resultSet.getString("usuario");
					String senha		= resultSet.getString("senha");
					
					Funcionario funcionario = new Funcionario(id, nome, endereco, email, cpf, cargo,usuario,senha);
					funcionarios.add(funcionario);
				}

				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				PostgreSQLJDBC.closeConnection(connection);
			}
		}
		return funcionarios;
	}
	public void inserirFuncionario(Funcionario funcionario, String usuario, String senha) {
	    Connection connection = PostgreSQLJDBC.getConnection();

	    if (connection != null) {
	        try {
	            String queryInserirPessoa = "INSERT INTO pessoa (nome, endereco, email, cpf) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement preparedStatementPessoa = connection.prepareStatement(queryInserirPessoa, Statement.RETURN_GENERATED_KEYS)) {
	                preparedStatementPessoa.setString(1, funcionario.getNome());
	                preparedStatementPessoa.setString(2, funcionario.getEndereco());
	                preparedStatementPessoa.setString(3, funcionario.getEmail());
	                preparedStatementPessoa.setInt(4, funcionario.getCpf());

	                preparedStatementPessoa.executeUpdate();

	                ResultSet generatedKeys = preparedStatementPessoa.getGeneratedKeys();
	                int idPessoa = -1;
	                if (generatedKeys.next()) {
	                    idPessoa = generatedKeys.getInt(1);
	                }

	                String queryInserirFuncionario = "INSERT INTO funcionario (cargo, usuario, senha, idPessoa) VALUES (?, ?, ?, ?)";
	                try (PreparedStatement preparedStatementFuncionario = connection.prepareStatement(queryInserirFuncionario)) {
	                    preparedStatementFuncionario.setString(1, funcionario.getCargo());
	                    preparedStatementFuncionario.setString(2, usuario);
	                    preparedStatementFuncionario.setString(3, senha);
	                    preparedStatementFuncionario.setInt(4, idPessoa);

	                    preparedStatementFuncionario.executeUpdate();
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            PostgreSQLJDBC.closeConnection(connection);
	        }
	    }
	}
	public ArrayList<Cliente> getClientes() {
	    Connection connection = PostgreSQLJDBC.getConnection();
	    ArrayList<Cliente> clientes = new ArrayList<>();

	    if (connection != null) {
	        try {
	            String query = "SELECT * FROM pessoa";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String endereco = resultSet.getString("endereco");
	                String email = resultSet.getString("email");
	                int cpf = resultSet.getInt("cpf");

	                Cliente cliente = new Cliente(id, nome, endereco, email, cpf);
	                clientes.add(cliente);
	            }

	            resultSet.close();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            PostgreSQLJDBC.closeConnection(connection);
	        }
	    }

	    return clientes;
	}


}
