package Terminal.cadastro;
import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
import Terminal.utili.utilitaveis;
import java.util.List;
public class AcessCanditatos {

    public static void cadastrarCandidato(String nome, int numero, String cargo, String partido){
        Candidato candidato = new Candidato(nome, numero, cargo, partido);
        new UserDAO().cadastrarCandidato(candidato);
    }
    
    public static void manageDB(String partido){
        utilitaveis.limpaTela();
        UserDAO dao = new UserDAO();
        List<Candidato> candidatos = dao.ver_candidatos(partido);
        System.out.println(String.format("%-10s %-20s %-20s %-15s", "Número", "Nome", "Cargo", "Partido"));
        System.out.println("---------------------------------------------------------------------");

        for (Candidato c :candidatos) {
            System.out.println(String.format("%-10d %-20s %-20s %-15s", 
                c.getNum(), c.getNome(), c.getCargo(), c.getPartido()));
        }
    }
}