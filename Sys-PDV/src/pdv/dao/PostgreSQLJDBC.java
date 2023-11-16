package pdv.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PostgreSQLJDBC {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "cristiano1234";
    private static final String DB_NAME = "sys_pdv_db";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/"+DB_NAME;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel se conectar ao Banco de dados!");

            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
