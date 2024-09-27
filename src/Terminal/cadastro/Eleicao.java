package Terminal.cadastro;

import java.util.Scanner;

public class Eleicao {
    private int idEleicao;
    private int duracaoMinutos;

    // Construtor
    public Eleicao(int idEleicao, int duracaoMinutos) {
        this.idEleicao = idEleicao;
        this.duracaoMinutos = duracaoMinutos;
    }

    // Getters e Setters (opcionais)
    public int getIdEleicao() {
        return idEleicao;
    }

    public void setIdEleicao(int idEleicao) {
        this.idEleicao = idEleicao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    // Método para cadastrar eleição
    public static Eleicao cadastrarEleicao(Scanner scanner) {
        System.out.print("Digite o ID da Eleição: ");
        int idEleicao = scanner.nextInt();

        System.out.print("Digite a duração da eleição em minutos: ");
        int duracaoMinutos = scanner.nextInt();

        // Criando uma nova eleição
        Eleicao novaEleicao = new Eleicao(idEleicao, duracaoMinutos);

        System.out.println("Eleição cadastrada com sucesso!");
        System.out.println("ID da Eleição: " + novaEleicao.getIdEleicao());
        System.out.println("Duração: " + novaEleicao.getDuracaoMinutos() + " minutos");

        return novaEleicao;
    }
}
