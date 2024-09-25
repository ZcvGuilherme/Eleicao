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

    private void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void cadastrarPresidente(Partido partido) {
        limpaTela();
        System.out.print("Digite o nome do presidente: ");
        String nomePresidente = scanner.nextLine();
        System.out.print("Digite o número do presidente: ");
        int numeroPresidente = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Candidato presidente = new Candidato(nomePresidente, partido.getNome(), numeroPresidente, "presidente");
        if (partido.adicionarCandidato(presidente)) {
            System.out.println("Presidente cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar presidente. Já existe um candidato para este cargo.");
        }
    }

    private void cadastrarGovernador(Partido partido) {
        limpaTela();
        System.out.print("Digite o nome do governador: ");
        String nomeGovernador = scanner.nextLine();
        System.out.print("Digite o número do governador: ");
        int numeroGovernador = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Candidato governador = new Candidato(nomeGovernador, partido.getNome(), numeroGovernador, "governador");
        if (partido.adicionarCandidato(governador)) {
            System.out.println("Governador cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar governador. Já existe um candidato para este cargo.");
        }
    }

    private void cadastrarCandidato(Partido partido) {
        while (true) {
            limpaTela();
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

            Candidato candidato = new Candidato(nomeCandidato, partido.getNome(), numeroCandidato, cargo);

            if (partido.adicionarCandidato(candidato)) {
                System.out.println("Candidato " + nomeCandidato + " cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar candidato. Limite de candidatos atingido para este cargo.");
            }

            System.out.print("Deseja cadastrar outro candidato? (s/n): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    private void cadastrarPartido() {
        limpaTela();
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
        cadastrarPresidente(partido);
        
        // Cadastro de governador
        cadastrarGovernador(partido);
        
        // Cadastro de senadores e deputados
        cadastrarCandidato(partido);
    }

    public void exibirMenu() {
        String menu = "1 - Cadastrar Partido\n2 - Cadastrar Eleição\n3 - Iniciar Eleição\n4 - Sair\n";

        while (true) {
            limpaTela();
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
