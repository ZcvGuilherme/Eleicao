package Terminal;
import Terminal.cadastro.CadastroCandidato;
import Terminal.utili.utilitaveis;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String menu = "1 - Cadastrar Partido\n2 - Cadastrar Eleição\n3 - Iniciar Eleição\n4 - Sair\n";
        Scanner scanner = new Scanner(System.in);
        while (true) {
        utilitaveis.limpaTela();
        System.out.println(menu);
        System.out.print("Digite uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:

                utilitaveis.limpaTela();
                utilitaveis.SlowPrint("Digite o nome do partido: ", 80);
                String nomePartido = scanner.nextLine();


                //----------------------------CADASTRO PRESIDENTE-----------------------------------\\
                utilitaveis.limpaTela();
                utilitaveis.SlowPrint("Digite o nome do Presidente: ", 50);
                String nomePres = scanner.nextLine();
                utilitaveis.limpaTela();
                utilitaveis.SlowPrint("Digite o número do Presidente", 50);
                int numpres = scanner.nextInt();
                CadastroCandidato.cadastrarCandidato(nomePres, numpres, "Presidente", nomePartido);
                //-----------------------------------------------------------------------------------\\
                //---------------------------CADASTRO GOVERNADOR--------------------------------------\\    
                utilitaveis.SlowPrint("Digite o nome do Governador: ", 50);
                String nomeGov = scanner.nextLine();
                utilitaveis.SlowPrint("Digite o número do Presidente", 50);
                int numGov = scanner.nextInt();
                CadastroCandidato.cadastrarCandidato(nomeGov, numGov, "Governador", nomePartido);
                //-----------------------------------------------------------------------------------\\
    
                //-----------------------------------------------------------------------------------\\
                //---------------------------CADASTRO SENADORES--------------------------------------\\ 
                utilitaveis.SlowPrint("Quantos senadores são? (1 - 3)", 50);
                int quantSen = scanner.nextInt();
                if (quantSen > 3){
                    quantSen = 3;
                } else if (quantSen < 1){
                    quantSen = 1;
                }
                for (int i = 1; i <= quantSen; i++){
                    utilitaveis.limpaTela();
                    utilitaveis.SlowPrint("Digite o nome do Senador: ", 50);
                    String nomeSen = scanner.nextLine();
                    utilitaveis.limpaTela();
                    utilitaveis.SlowPrint("Digite o número do Senador", 50);
                    int numSen = scanner.nextInt();
                    CadastroCandidato.cadastrarCandidato(nomeSen, numSen, "Senador", nomePartido);    
                }
                //-----------------------------------------------------------------------------------\\
                //---------------------------CADASTRO DEPUTADOS FEDERAIS--------------------------------------\\ 
                utilitaveis.SlowPrint("Quantos Deputados Federais são? (1 - 3)", 50);
                int quantDepF = scanner.nextInt();
                if (quantDepF > 3){
                    quantDepF = 3;
                } else if (quantDepF < 1){
                    quantDepF = 1;
                }
                for (int i = 1; i <= quantDepF; i++){
                    utilitaveis.limpaTela();
                    utilitaveis.SlowPrint("Digite o nome do Deputado : ", 50);
                    String nomeSen = scanner.nextLine();
                    utilitaveis.limpaTela();
                    utilitaveis.SlowPrint("Digite o número do Deputado", 50);
                    int numSen = scanner.nextInt();
                    CadastroCandidato.cadastrarCandidato(nomeSen, numSen, "Deputado Federal", nomePartido);    
                }
                //-----------------------------------------------------------------------------------\\
                //---------------------------CADASTRO DEPUTADOS ESTADUAIS--------------------------------------\\ 
                utilitaveis.SlowPrint("Quantos Deputados Estaduais são? (1 - 3)", 50);
                int quantDepE = scanner.nextInt();
                if (quantDepE > 3){
                    quantDepE = 3;
                } else if (quantDepE < 1){
                    quantDepE = 1;
                }
                for (int i = 1; i <= quantDepE; i++){
                    utilitaveis.limpaTela();
                    utilitaveis.SlowPrint("Digite o nome do Deputado: ", 50);
                    String nomeSen = scanner.nextLine();
                    utilitaveis.limpaTela();
                    utilitaveis.SlowPrint("Digite o número do Deputado", 50);
                    int numSen = scanner.nextInt();
                    CadastroCandidato.cadastrarCandidato(nomeSen, numSen, "Deputado Estadual", nomePartido);    
                }

                break;
            case 2:
                // Aqui você pode implementar o cadastro de eleição
                break;
            case 3:
                // Aqui você pode implementar a lógica para iniciar a eleição
                break;
            case 4:
                System.out.println("Saindo...");
                return; // Sai do loop e finaliza o programa
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        }
    }
}

