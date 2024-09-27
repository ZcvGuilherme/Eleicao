package Terminal.cadastro;

import Terminal.utili.utilitaveis;
import java.util.Scanner;
public class MainCadastro {
    Scanner scanner = new Scanner(System.in);

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
        CadastroCandidato.cadastrarCandidato(nome, num, cargo, nomePartido);
        }



    public void SenxDep(String nomePartido, String cargoP, String cargoS, int numMax){
        utilitaveis.limpaTela();
        String vari = String.format("Quantos %s são? (1 - %d)", cargoP, numMax);
        String vari2 = String.format("Digite o nome do %s: ", cargoS);
        String vari3 = String.format("Digite o numero do %s: ", cargoS);
        utilitaveis.SlowPrint(vari, 30);
        int quant = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        if (quant > numMax){
            quant = 3;
        } else if (quant < numMax){
            quant = 1;
        }
        for (int i = 1; i <= quant; i++){
            utilitaveis.limpaTela();
            utilitaveis.SlowPrint(vari2, 30);
            String nomeSen = scanner.nextLine();
            utilitaveis.limpaTela();
            utilitaveis.SlowPrint(vari3, 30);
            int numSen = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            CadastroCandidato.cadastrarCandidato(nomeSen, numSen, cargoS, nomePartido);    
        }
    }
}
