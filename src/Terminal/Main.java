package Terminal;
import DATABASE.DAO.UserDAO;
import Terminal.cadastro.AcessCanditatos;
import Terminal.cadastro.AcessEleicoes;
import Terminal.cadastro.MainCadastro;
import Terminal.utili.utilitaveis;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MainCadastro cadastro = new MainCadastro();
        
        String menu = "1 - Cadastrar Partido\n2 - Ver Partidos\n3 - Cadastrar Eleição\n4 - Ver Eleições\n5 - Cadastrar Eleitores\n6 - Iniciar Eleição\n7 - Sair\n";
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
                cadastro.menuCadastro(nomePartido, "Presidente");
                cadastro.menuCadastro(nomePartido, "Governador");
                //-----------------------------------------------------------------------------------\\
                cadastro.SenxDep(nomePartido, "Senadores", "Senador", 3);
                cadastro.SenxDep(nomePartido, "Deputados Federais", "Deputado Federal", 5);
                cadastro.SenxDep(nomePartido, "Deputados Estaduais", "Deputado Estadual", 5);
                break;
            case 2:
                utilitaveis.SlowPrint("Qual Partido você deseja ver? ", 30);
                String pergunta = scanner.nextLine();
                AcessCanditatos.manageDB(pergunta);
                scanner.nextLine();
                break;
            case 3:
                utilitaveis.limpaTela();
                cadastro.MenuEleicao();
                break;
            case 4:
                utilitaveis.limpaTela();
                new AcessEleicoes().exibirEleicoes();
                scanner.nextLine();
                break;
            case 5:
                utilitaveis.SlowPrint("Digite quantos eleitores serão cadastrados:", 30);
                int quant = scanner.nextInt();
                scanner.nextLine();
                new UserDAO().add_eleitores(quant);
                scanner.nextLine();
                break;
            case 6:
                System.out.println("Digite o id da eleição para começar: ");
                int id = scanner.nextInt();
                new AcessEleicoes().iniciarEleicao(id);
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 7:
            System.out.println("Saindo...");
            scanner.close();
            return; // Sai do loop e finaliza o programa
            default:
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
}