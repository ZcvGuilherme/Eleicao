package Terminal;
import Terminal.cadastro.AcessCanditatos;
import Terminal.cadastro.MainCadastro;
import Terminal.utili.utilitaveis;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        MainCadastro presidente = new MainCadastro();
        MainCadastro governador = new MainCadastro();
        MainCadastro senadores = new MainCadastro();
        MainCadastro deputadosF = new MainCadastro();
        MainCadastro deputadosE = new MainCadastro();
        MainCadastro EleicaoOFICIAL = new MainCadastro();

        String menu = "1 - Cadastrar Partido\n2 - Ver Partidos\n3 - Cadastrar Eleição\n4 - Iniciar Eleição\n5 - Sair\n";
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
                utilitaveis.SlowPrint("Digite o nome do partido: ", 30);
                String nomePartido = scanner.nextLine();
                presidente.menuCadastro(nomePartido, "Presidente");
                governador.menuCadastro(nomePartido, "Governador");
                //-----------------------------------------------------------------------------------\\
                senadores.SenxDep(nomePartido, "Senadores", "Senador", 3);
                deputadosF.SenxDep(nomePartido, "Deputados Federais", "Deputado Estadual", 5);
                deputadosE.SenxDep(nomePartido, "Deputados Estaduais", "Deputado Estadual", 5);
                break;
            case 2:
                utilitaveis.SlowPrint("Qual Partido você deseja ver? ", opcao);
                String pergunta = scanner.nextLine();
                AcessCanditatos.manageDB(pergunta);
                scanner.nextLine();
                break;
            case 3:
                EleicaoOFICIAL.MenuEleicao();
                break;
            case 4:
            // Aqui você pode implementar a lógica para iniciar a eleição
                break;
            case 5:
                System.out.println("Saindo...");
                scanner.close();
                return; // Sai do loop e finaliza o programa
            default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
}

