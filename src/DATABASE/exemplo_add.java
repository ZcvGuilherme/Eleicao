package DATABASE;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
import java.util.List;
public class exemplo_add {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        List<Candidato> candidatos = dao.ver_candidatos("PZ");
        for (Candidato c :candidatos) {
            System.out.println(c);
        }

    }
}
