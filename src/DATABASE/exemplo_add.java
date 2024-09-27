package DATABASE;
import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;


public class exemplo_add {
    public static void main(String[] args) {
        Candidato presidente = new Candidato("José", 12, "Presidente", "PZ");
        
        new UserDAO().ver_candidatos(presidente);
        

    }
}
