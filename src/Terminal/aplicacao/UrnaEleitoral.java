package Terminal.aplicacao;

import Terminal.servico.EleicaoServico;

public class UrnaEleitoral {

    public static void main(String[] args) {
        EleicaoServico eleicaoServico = new EleicaoServico();

        // Criação de eleição
        eleicaoServico.criarEleicao();

        // Cadastro de partidos e candidatos
        eleicaoServico.cadastrarPartidos();

        System.out.println("Eleição cadastrada com sucesso!");
    }
}
