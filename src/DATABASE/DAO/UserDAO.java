package DATABASE.DAO;

import DATABASE.conexao.Conexao;
import DATABASE.entidade.Candidato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void cadastrarCandidato(Candidato candidato){

        String sql = "INSERT INTO candidatos (numero, nome, cargo, partido, votos) VALUES (?, ?, ?, ?, ?) ";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, candidato.getNum());
            ps.setString(2, candidato.getNome());
            ps.setString(3, candidato.getCargo());
            ps.setString(4, candidato.getPartido());
            ps.setInt(5, 0);
            //ps.setString(1, usuario.getUser());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ver_candidatos(Candidato candidato){
        String view = "select * from candidatos where partido = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = Conexao.getConexao().prepareStatement(view);

            stmt.setString(1, candidato.getPartido());
           
            rs = stmt.executeQuery();
            System.out.println("Candidatos do partido " + candidato.getPartido());
            while (rs.next()) {
                // Exemplo de como acessar os dados retornados
                int numero = rs.getInt("numero");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                String partido = rs.getString("partido"); // Substitua "id" pelo nome da coluna real
                /*
                 * numero | nome | Presidente | Partido
                 */
                 // Substitua "nome" pelo nome da coluna real
                String texto = String.format("%d | %s | %s \n",partido,  numero, nome, cargo);
                System.out.println(texto);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}
