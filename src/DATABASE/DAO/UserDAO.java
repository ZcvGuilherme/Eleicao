package DATABASE.DAO;

import DATABASE.conexao.Conexao;
import DATABASE.entidade.Candidato;
import java.sql.PreparedStatement;
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
}
