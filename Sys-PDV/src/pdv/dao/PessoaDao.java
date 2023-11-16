package pdv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import pdv.model.Funcionario;

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
					String 	cpf 		= resultSet.getString("cpf");
					String 	cargo 		= resultSet.getString("cargo");				
					
					Funcionario funcionario = new Funcionario(id, nome, endereco, email, cpf, cargo);
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
                // Inserir funcionário
                String queryInserirFuncionario = "INSERT INTO funcionario (nome, endereco, email, cpf, cargo) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryInserirFuncionario, Statement.RETURN_GENERATED_KEYS)) {
                    preparedStatement.setString(1, funcionario.getNome());
                    preparedStatement.setString(2, funcionario.getEndereco());
                    preparedStatement.setString(3, funcionario.getEmail());
                    preparedStatement.setString(4, funcionario.getCpf());
                    preparedStatement.setString(5, funcionario.getCargo());
                    preparedStatement.executeUpdate();

                    // Obter o ID do funcionário recém-inserido
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int idFuncionario = generatedKeys.getInt(1);

                        // Verificar se o cargo é administrador
                        if ("administrador".equalsIgnoreCase(funcionario.getCargo())) {
                            // Inserir detalhes do administrador
                            String queryInserirAdministrador = "INSERT INTO administrador (id_funcionario, usuario, senha) VALUES (?, ?, ?)";
                            try (PreparedStatement adminStatement = connection.prepareStatement(queryInserirAdministrador)) {
                                adminStatement.setInt(1, idFuncionario);
                                adminStatement.setString(2, usuario);
                                adminStatement.setString(3, senha);
                                adminStatement.executeUpdate();
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
    }

}
