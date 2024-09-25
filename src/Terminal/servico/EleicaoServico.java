package Terminal.servico;

import Terminal.modelo.Candidato;
import Terminal.modelo.Eleicao;
import Terminal.modelo.Partido;

import java.util.Scanner;

public class EleicaoServico {
    
    private Eleicao eleicao;

    public void criarEleicao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da eleição:");
        int idEleicao = scanner.nextInt();
        System.out.println("Digite o tempo de duração da eleição (em horas):");
        int duracaoEleicao = scanner.nextInt();
        eleicao = new Eleicao(idEleicao, duracaoEleicao);
    }

    public void cadastrarPartidos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos partidos deseja cadastrar?");
        int qtdPartidos = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        for (int i = 0; i < qtdPartidos; i++) {
            System.out.println("Digite o nome do partido:");
            String nomePartido = scanner.nextLine();
            System.out.println("Digite o número de senadores que o partido pode ter:");
            int qtdSenadores = scanner.nextInt();
            System.out.println("Digite o número de deputados federais que o partido pode ter:");
            int qtdDeputadosFederais = scanner.nextInt();
            System.out.println("Digite o número de deputados estaduais que o partido pode ter:");
            int qtdDeputadosEstaduais = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            Partido partido = new Partido(nomePartido, qtdSenadores, qtdDeputadosFederais, qtdDeputadosEstaduais);
            eleicao.adicionarPartido(partido);

            cadastrarCandidatosPartido(partido);
        }
    }

    public void cadastrarCandidatosPartido(Partido partido) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos candidatos deseja cadastrar para o partido " + partido.getNome() + "?");
        int qtdCandidatos = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        for (int j = 0; j < qtdCandidatos; j++) {
            System.out.println("Digite o nome do candidato:");
            String nomeCandidato = scanner.nextLine();
            System.out.println("Digite o número do candidato:");
            int numeroCandidato = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha
            System.out.println("Digite o cargo do candidato (Presidente, Governador, Senador, Deputado Federal, Deputado Estadual):");
            String cargoCandidato = scanner.nextLine();

            Candidato candidato = new Candidato(nomeCandidato, partido, numeroCandidato, cargoCandidato);
            if (!partido.adicionarCandidato(candidato)) {
                System.out.println("Não foi possível adicionar o candidato ao partido.");
            }
        }
    }

    public Eleicao getEleicao() {
        return eleicao;
    }
}
