package DATABASE.DAO;

import DATABASE.conexao.Conexao;
import DATABASE.entidade.Candidato;
import java.sql.Connection;
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
    public List<Candidato> retornoTodosCandidatos(){
        String view = "select * from candidatos";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Candidato> listaCandidatos = new ArrayList<>();
        try {
            stmt = Conexao.getConexao().prepareStatement(view);      
            rs = stmt.executeQuery();
    
            while (rs.next()) {
                // Exemplo de como acessar os dados retornados
                int numero = rs.getInt("numero");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                String partido = rs.getString("partido");
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


    public void EleicaoBD(int duracaoMinutos){
        String ec = "INSERT INTO eleicoes (Tempo, presidenteVotoNull, governadorVotoNull, senadorVotoNull, deputadoFVotoNull, deputadoEVotoNull, votoBranco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ez = null;
        try {
            ez = Conexao.getConexao().prepareStatement(ec);
            
            ez.setInt(1, duracaoMinutos);
            ez.setInt(2, 0);
            ez.setInt(3, 0);
            ez.setInt(4, 0);
            ez.setInt(5, 0);
            ez.setInt(6, 0);
            ez.setInt(7, 0);

  
            //ps.setString(1, usuario.getUser());
            ez.execute();
            ez.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<int[]> listarEleicoes(){
        String comm = "select * from eleicoes";
        PreparedStatement statment = null;
        ResultSet results = null;
        List<int[]> eleicoes = new ArrayList<>();

        try {
            statment = Conexao.getConexao().prepareStatement(comm);
            results = statment.executeQuery();
            while (results.next()) { 
                int idEleicao = results.getInt("ID");
                int timeEleicao = results.getInt("Tempo");

                eleicoes.add(new int[]{idEleicao, timeEleicao});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (results != null) results.close();
                if (statment != null) statment.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eleicoes;
    }
    public void add_eleitores(int quantidade){
        String sql = "insert into Eleitores (Contagem) values (?)";
        PreparedStatement ps = null;
        try {
            for (int i = 1; i <= quantidade; i++){
                ps = Conexao.getConexao().prepareStatement(sql);
                ps.setInt(1, i);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int quant_eleitores(){
        String sql = "SELECT COUNT(id) AS total FROM Eleitores";
        int totalEleitores = 0;
        try (Connection connection = Conexao.getConexao();
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            totalEleitores = rs.getInt("total"); // Obtém o total da consulta
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return totalEleitores;
    }
    public void deletar_eleitor(int contagem){
        String sql = "delete from Eleitores where Contagem = ?";
        try (Connection connection = Conexao.getConexao();
         PreparedStatement ps = connection.prepareStatement(sql)) {

        ps.setInt(1, contagem); // Define o parâmetro da consulta
        int rowsAffected = ps.executeUpdate(); // Executa a atualização

        if (rowsAffected > 0) {
            System.out.println("Eleitor com contagem " + contagem + " deletado com sucesso!");
        } else {
            System.out.println("Nenhum eleitor encontrado com a contagem " + contagem + ".");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Trata exceções SQL
    }
    }
}
