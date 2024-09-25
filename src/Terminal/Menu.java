package Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Partido> partidos;
    private Scanner scanner;

    public Menu() {
        this.partidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar Partido");
            System.out.println("2 - Cadastrar Eleição");
            System.out.println("3 - Iniciar Eleição");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarPartido();
                    break;
                case 2:
                    cadastrarEleicao();
                    break;
                case 3:
                    System.out.println("Iniciando eleição...");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private void cadastrarPartido() {
        System.out.print("Nome do partido: ");
        String nome = scanner.nextLine();
        System.out.print("Número de senadores: ");
        int senadores = scanner.nextInt();
        System.out.print("Número de deputados federais: ");
        int deputadosFederais = scanner.nextInt();
        System.out.print("Número de deputados estaduais: ");
        int deputadosEstaduais = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Partido partido = new Partido(nome, senadores, deputadosFederais, deputadosEstaduais);
        partidos.add(partido);
        System.out.println("Partido cadastrado com sucesso!");

        while (true) {
            System.out.print("Nome do candidato (ou 'sair' para terminar): ");
            String candidatoNome = scanner.nextLine();
            if (candidatoNome.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.print("Número do candidato: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            System.out.print("Cargo do candidato (presidente, governador, senador, deputado federal, deputado estadual): ");
            String cargo = scanner.nextLine();

            Candidato candidato = new Candidato(candidatoNome, nome, numero, cargo);
            if (partido.adicionarCandidato(candidato)) {
                System.out.println("Candidato adicionado ao partido.");
            } else {
                System.out.println("Limite de candidatos atingido para este cargo.");
            }
        }
    }

    private void cadastrarEleicao() {
        System.out.print("ID da eleição: ");
        String id = scanner.nextLine();
        System.out.print("Duração da eleição (em minutos): ");
        int duracao = scanner.nextInt();
        System.out.print("Número de eleitores que votaram: ");
        int numEleitores = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Eleicao eleicao = new Eleicao(id, duracao, numEleitores);
        System.out.println("Eleição cadastrada com sucesso!");
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
