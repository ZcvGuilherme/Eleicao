package DATABASE.DAO;

import DATABASE.conexao.Conexao;
import DATABASE.entidade.Candidato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public List<Candidato> ver_candidatos(String partido){
        String view = "select * from candidatos where partido = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Candidato> listaCandidatos = new ArrayList<>();
        try {
            stmt = Conexao.getConexao().prepareStatement(view);

            stmt.setString(1, partido);
           
            rs = stmt.executeQuery();
    
            while (rs.next()) {
                // Exemplo de como acessar os dados retornados
                int numero = rs.getInt("numero");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");

                Candidato candidato = new Candidato(nome, numero, cargo, partido);
                listaCandidatos.add(candidato);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listaCandidatos;
    }
    public void EleicaoBD(int idEleicao, int duracaoMinutos){
        String ec = "INSERT INTO eleicoes (idEleicao, timeEleicao) VALUES (?, ?)";
        PreparedStatement ez = null;
        try {
            ez = Conexao.getConexao().prepareStatement(ec);
            ez.setInt(1, idEleicao);
            ez.setInt(2, duracaoMinutos);
  
            //ps.setString(1, usuario.getUser());
            ez.execute();
            ez.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}


//String texto = String.format(" %d | %s | %s \n", numero, nome, cargo);