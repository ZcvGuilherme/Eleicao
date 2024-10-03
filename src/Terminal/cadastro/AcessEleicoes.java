package Terminal.cadastro;
import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
import DATABASE.entidade.Eleicao;
import Terminal.utili.utilitaveis;
import java.io.PrintWriter;
import java.util.List;

public class AcessEleicoes {
    UserDAO dao = new UserDAO();
    public void cadastrarEleicao(int duracaoMinutos) {
        // Criando uma nova eleição
        String text2 = String.format("Duração: %d minutos.", duracaoMinutos);
        dao.EleicaoBD(duracaoMinutos);
        utilitaveis.SlowPrint("Eleição cadastrada com sucesso!", 50);
        utilitaveis.SlowPrint(text2, 50);
    }
    public void exibirEleicoes(){

        List<int[]> eleicoes = dao.listarEleicoes();
        System.out.println("ID Eleição | Tempo Eleição (min)");
        System.out.println("-------------------------------");
        for (int[] eleicao : eleicoes) {
            System.out.printf("%-10d | %-20d\n", eleicao[0], eleicao[1]);
        }
    }
    public int retornarTempo(int id){
        List<int[]> eleicoes = dao.listarEleicoes();

        for (int[] eleicao : eleicoes) {
            if (id == eleicao[0]){
                return eleicao[1];
            }
        }
        return 0;
    }
    public void iniciarEleicao(int id){
        List<Candidato> candidatos = dao.retornoTodosCandidatos();
        int tempo = retornarTempo(id);
        Eleicao objEleicao = new Eleicao(candidatos, id, tempo, 0, 0, 0, 0, 0, 0);
<<<<<<< HEAD
<<<<<<< Updated upstream
        MainServidor.iniciarServidor(objEleicao);
=======

        
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Eleição ID " + id + " iniciada com sucesso! Duração: " + tempo + " minutos.");
       // System.out.println("Eleição iniciada com ID: " + id + " e duração de " + tempo + " minutos."); 
       
>>>>>>> Stashed changes
=======

>>>>>>> parent of ecbfade (commit conexao)
    }
}
