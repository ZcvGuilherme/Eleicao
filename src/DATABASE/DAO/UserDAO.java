package DATABASE.DAO;

import DATABASE.conexao.Conexao;
import DATABASE.entidade.Candidato;
import Terminal.utili.utilitaveis;
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
    public void ver_candidatos(String partido){
        String view = "select * from candidatos where partido = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = Conexao.getConexao().prepareStatement(view);

            stmt.setString(1, partido);
           
            rs = stmt.executeQuery();
            String txt = String.format("Candidatos do partido %s: \nnumero | nome | cargo", partido);
            utilitaveis.SlowPrint(txt, 60);
            while (rs.next()) {
                // Exemplo de como acessar os dados retornados
                int numero = rs.getInt("numero");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                /*
                 * numero | nome | Presidente | Partido
                 */
                 // Substitua "nome" pelo nome da coluna real
                String texto = String.format(" %d | %s | %s \n", numero, nome, cargo);
                utilitaveis.SlowPrint(texto, 40);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}
