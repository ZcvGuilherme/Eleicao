package Terminal;
import Terminal.cadastro.CadastroCandidato;
import Terminal.utili.utilitaveis;
import java.util.Scanner;
public class exemplo {
    Scanner scanner = new Scanner(System.in);
    public void menuCadastro(String nomePartido){
    utilitaveis.limpaTela();
    utilitaveis.SlowPrint("Digite o nome do Presidente: ", 30);
    String nomePres = scanner.nextLine();
    utilitaveis.limpaTela();
    utilitaveis.SlowPrint("Digite o número do Presidente", 30);
    int numpres = scanner.nextInt();
    scanner.nextLine(); // Limpa o buffer
    CadastroCandidato.cadastrarCandidato(nomePres, numpres, "Presidente", nomePartido);
    }
    
}
