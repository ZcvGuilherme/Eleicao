
import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;

public class exemplo_add {
    public static void main(String[] args) {
        Candidato presidente = new Candidato("José", 12, "Presidente", "Px");
        
        new UserDAO().cadastrarCandidato(presidente);
    }
}
