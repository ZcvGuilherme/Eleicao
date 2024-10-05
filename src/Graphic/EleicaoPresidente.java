package Graphic;

import DATABASE.entidade.Candidato; // Importa a classe Candidato
import java.util.List; // Importa a classe List

public class EleicaoPresidente {

    private List<Candidato> candidatos; // Lista de candidatos

    // Construtor que recebe a lista de candidatos
    public EleicaoPresidente(List<Candidato> candidatos) {
        this.candidatos = candidatos; // Inicializa a lista de candidatos
    }

    // Método para calcular o resultado da eleição
    public void calcularResultadoEleicao() {
        Candidato vencedor = null; // Variável para armazenar o vencedor
        int maxVotos = 0; // Inicializa o número máximo de votos

        // Encontrar o candidato com o maior número de votos
        for (Candidato candidato : candidatos) {
            if (candidato.getvotos() > maxVotos) {
                vencedor = candidato; // Atualiza o vencedor
                maxVotos = candidato.getvotos(); // Atualiza o máximo de votos
            }
        }

        // Imprimir o resultado
        if (vencedor != null) {
            System.out.println("O vencedor para Presidente é: " + vencedor.getNome() + " com " + maxVotos + " votos."); // Exibe o vencedor e seus votos
        }
    }

    public static void main(String[] args) {
        List<Candidato> candidatos = GeradorEleicao.gerarEleicao().getCandidatos(); // Gera a lista de candidatos
        EleicaoPresidente eleicao = new EleicaoPresidente(candidatos); // Cria uma nova instância da eleição
        eleicao.calcularResultadoEleicao(); // Calcula e exibe o resultado da eleição
    }
}
