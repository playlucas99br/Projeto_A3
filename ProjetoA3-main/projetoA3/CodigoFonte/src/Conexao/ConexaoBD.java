package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static ConexaoBD instance = null;
    private static final String url = "jdbc:mysql://localhost:3306/escola";
    private static final String user = "root";
    private static final String password = "1234";
    private static Connection conn;
    
    public static Connection getConexao(){

        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
            
        }   catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }

    public static ConexaoBD getInstance() {
        if (instance == null) {
            instance = new ConexaoBD();
        }
        return instance;
    } 

    public Connection getConnection() {
        return conn;
    }
}
