package Terminal.cadastro;
import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
public class CadastroCandidato {

    public static void cadastrarCandidato(String nome, int numero, String cargo, String partido){
        Candidato candidato = new Candidato(nome, numero, cargo, partido);
        new UserDAO().cadastrarCandidato(candidato);
    }

}