package Terminal.cadastro;
import DATABASE.DAO.UserDAO;
import Terminal.utili.utilitaveis;
public class AcessEleicoes {
    UserDAO dao = new UserDAO();
    public void cadastrarEleicao(int idEleicao, int duracaoMinutos) {
        // Criando uma nova eleição
        String text1 = String.format("ID da Eleição: %d", idEleicao);
        String text2 = String.format("Duração: %d minutos.", duracaoMinutos);
        dao.EleicaoBD(idEleicao, duracaoMinutos);
        utilitaveis.SlowPrint("Eleição cadastrada com sucesso!", 50);
        utilitaveis.SlowPrint(text1, 50);
        utilitaveis.SlowPrint(text2, 50);
    }
}
