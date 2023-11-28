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
	    ArrayList<Funcionario> funcionarios = new ArrayList<>();

	    if (connection != null) {
	        try {
	            String query = "SELECT * FROM pessoa INNER JOIN funcionario ON pessoa.id = funcionario.idPessoa";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String endereco = resultSet.getString("endereco");
	                String email = resultSet.getString("email");
	                String cpf = resultSet.getString("cpf");
	                String cargo = resultSet.getString("cargo");
	                String usuario = resultSet.getString("usuario");
	                String senha = resultSet.getString("senha");

	                Funcionario funcionario = new Funcionario(id, nome, endereco, email, cpf, cargo, usuario, senha);
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

	public boolean inserirFuncionario(Funcionario funcionario) {
	    Connection connection = PostgreSQLJDBC.getConnection();

	    if (connection != null) {
	        try {
	            String queryInserirPessoa = "INSERT INTO pessoa (nome, endereco, email, cpf) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement preparedStatementPessoa = connection.prepareStatement(queryInserirPessoa, Statement.RETURN_GENERATED_KEYS)) {
	                preparedStatementPessoa.setString(1, funcionario.getNome());
	                preparedStatementPessoa.setString(2, funcionario.getEndereco());
	                preparedStatementPessoa.setString(3, funcionario.getEmail());
	                preparedStatementPessoa.setString(4, funcionario.getCpf());

	                preparedStatementPessoa.executeUpdate();

	                ResultSet generatedKeys = preparedStatementPessoa.getGeneratedKeys();
	                int idPessoa = -1;
	                if (generatedKeys.next()) {
	                    idPessoa = generatedKeys.getInt(1);
	                }

	                String queryInserirFuncionario = "INSERT INTO funcionario (cargo, usuario, senha, idPessoa) VALUES (?, ?, ?, ?)";
	                try (PreparedStatement preparedStatementFuncionario = connection.prepareStatement(queryInserirFuncionario)) {
	                    preparedStatementFuncionario.setString(1, funcionario.getCargo());
	                    preparedStatementFuncionario.setString(2, funcionario.getUsuario());
	                    preparedStatementFuncionario.setString(3, funcionario.getSenha());
	                    preparedStatementFuncionario.setInt(4, idPessoa);

	                    preparedStatementFuncionario.executeUpdate();
	                }
	            }
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();  // ou utilize um logger para registrar a exceção
	            return false;
	        } finally {
	            PostgreSQLJDBC.closeConnection(connection);
	        }
	    }
	    return false;
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
	                String cpf = resultSet.getString("cpf");

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
