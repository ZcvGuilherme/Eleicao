package Terminal.Menu;

import Terminal.cadastro.Partido;
import Terminal.utili.utilitaveis;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
será que nao está codigo demais?
mais de 100 linhas, um monte de funções fazendo coisas diferentes, será que nao da pra separar e otimizar um pouco?
cade as pastas separadas que eu fiz?
elas servem exatamente pra separar os arquivos que estao juntas aqui
 */
public class Menu {
    private List<Partido> partidos;
    private Scanner scanner;

    public Menu() {
        this.partidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    

    private void cadastrarGovernador(Partido partido) {
        utilitaveis.limpaTela();
        System.out.print("Digite o nome do governador: ");
        String nomeGovernador = scanner.nextLine();
        System.out.print("Digite o número do governador: ");
        int numeroGovernador = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

      
        
    }
    /*
     * outra sugestao:
     * voce ve q teve que fazer o mesmo método para governador e presidente, correto?
     * e eu estou pendindo ali embaixo pra tu fazer o mesmo para o senador e deputados
     * se ta tendo repetição, vc pode fazer esse loop, com as mesmas verificações que eu coloquei
     * la embaixo, em um metodo generico, que vai criar um candidato generico pro loop, q vc vai 
     * ter que passar pelos atributos as mudanças, por exemplo, o que muda?
     * o nome do cargo
     * a verificação de quantos candidatos daquele cargo podem ter
     * 
     * sao so dois atributos, que se vc fizer uma classe generica vc consegue armazenar com mais facilidade, isso aproveita e diminui o codigo separando ele mais em outros arquivos
     */
    private void cadastrarCandidato(Partido partido) {
        while (true) {
            utilitaveis.limpaTela();
            System.out.print("Digite o cargo do candidato (senador, deputado federal, deputado estadual) ou 'sair' para encerrar: ");
            String cargo = scanner.nextLine();
            if (cargo.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o nome do candidato: ");
            String nomeCandidato = scanner.nextLine();
            System.out.print("Digite o número do candidato: ");
            int numeroCandidato = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer


            

            System.out.print("Deseja cadastrar outro candidato? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void cadastrarPartido() {
        utilitaveis.limpaTela();
        System.out.print("Digite o nome do partido: ");
        String nomePartido = scanner.nextLine();
        System.out.print("Quantos senadores haverá no partido? ");
        int limiteSenadores = scanner.nextInt();
        System.out.print("Quantos deputados federais haverá no partido? ");
        int limiteDeputadosFederais = scanner.nextInt();
        System.out.print("Quantos deputados estaduais haverá no partido? ");
        int limiteDeputadosEstaduais = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Partido partido = new Partido(nomePartido, limiteSenadores, limiteDeputadosFederais, limiteDeputadosEstaduais);
        partidos.add(partido);
        System.out.println("Partido " + nomePartido + " cadastrado com sucesso!");

        // Cadastro de presidente

        
        // Cadastro de governador
        cadastrarGovernador(partido);
        
        // Cadastro de senadores e deputados
        /*
         essa parte.... pq vc n fez um para cada?
         ficaria mais organizado e menos confuso, do mesmo jeito que voce fez para o presidente e  governador, deve ter para o resto dos candidatos, inclusive está faltando a tratação de erros, a minha sugestão é que voce refaça a parte desse dos candidatos, porque ele tem q ter a seguinte lógica:
         senadores:
         entra na função/loop dos senadores:
         pergunta quantos são:
         pede o nome e o número exato que o candidato precisa ter
         e o loop continua até que o numero de senador seja atingido


         a mesma coisa pros deputados

         da mais trabalho mas fica mais facil nao so pra colocar dps mas tbm pra automatizar o processo também

         */
        cadastrarCandidato(partido);
    }

    public void exibirMenu() {
        String menu = "1 - Cadastrar Partido\n2 - Cadastrar Eleição\n3 - Iniciar Eleição\n4 - Sair\n";

        while (true) {
            utilitaveis.limpaTela();
            System.out.println(menu);
            System.out.print("Digite uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarPartido();
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
