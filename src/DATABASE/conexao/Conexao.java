package DATABASE.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/sessao_urna";
    private static final String user = "root";
    private static final String senha = "Cv271#$x";

    private static Connection conn;
    public static Connection getConexao(){
        try{
            if (conn == null){
                conn = DriverManager.getConnection(url, user, senha);
                System.out.println("Conexão feita com sucesso!");
                return conn;
            } else {
                System.out.println("Conexão feita com sucesso!");
                return conn;
            }
        } catch (SQLException e) {
            System.out.println("Conexão falhou!");
            e.printStackTrace();
            return null;
        }
    }
}
