package Terminal.cadastro;

import Terminal.utili.utilitaveis;
import java.util.Scanner;
public class MainCadastro {
    Scanner scanner = new Scanner(System.in);
    AcessEleicoes CEOF = new AcessEleicoes();
    public void menuCadastro(String nomePartido, String cargo){
        String texto1 = String.format("Digite o nome do %s: " , cargo);
        utilitaveis.limpaTela();
        String texto2 = String.format("Digite o numero do %s: " , cargo);
        utilitaveis.SlowPrint(texto1, 30);
        String nome = scanner.nextLine();
        utilitaveis.limpaTela();

        utilitaveis.SlowPrint(texto2, 30);
        int num = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        AcessCanditatos.cadastrarCandidato(nome, num, cargo, nomePartido);
        }

    public void SenxDep(String nomePartido, String cargoP, String cargoS, int numMax){
        utilitaveis.limpaTela();
        String promptQuant = String.format("Quantos %s são? (1 - %d)", cargoP, numMax);
        String promptNome = String.format("Digite o nome do %s: ", cargoS);
        String promptNumero = String.format("Digite o numero do %s: ", cargoS);

        
        utilitaveis.SlowPrint(promptQuant, 30);
        int quant = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        if (quant > numMax){
            quant = numMax;
        } else if (quant < 1){
            quant = 1;
        }

        for (int i = 1; i <= quant; i++){
            utilitaveis.limpaTela();
            utilitaveis.SlowPrint(promptNome, 30);
            String nomeSen = scanner.nextLine();
            utilitaveis.limpaTela();
            utilitaveis.SlowPrint(promptNumero, 30);
            int numSen = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            AcessCanditatos.cadastrarCandidato(nomeSen, numSen, cargoS, nomePartido);    
        }
    }
    public void MenuEleicao(){
        utilitaveis.limpaTela();
        utilitaveis.SlowPrint("Digite o tempo da eleição (min): ", 50);
        int tempoEleicao = scanner.nextInt();
        scanner.nextLine();
        CEOF.cadastrarEleicao(tempoEleicao);
    }


}
