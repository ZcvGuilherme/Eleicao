package Graphic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGraphic {

    // Normaliza os valores para uma escala de 0 a 100
    public List<Double> normalizarValores(List<Integer> valores, int maxValor) {
        List<Double> valoresNormalizados = new ArrayList<>();
        for (int valor : valores) {
            valoresNormalizados.add((double) valor / maxValor * 100);
        }
        return valoresNormalizados;
    }

    // Método para gerar dados fictícios com votos nulos e brancos
    public List<List<?>> gerarDadosExemploComNulosBrancos() {
        List<String> rotulos = Arrays.asList("Candidato A", "Candidato B", "Nulo", "Branco");
        List<Integer> votos = Arrays.asList(150, 120, 30, 20);

        List<List<?>> dadosExemplo = new ArrayList<>();
        dadosExemplo.add(rotulos); // Adiciona rótulos
        dadosExemplo.add(votos);   // Adiciona os votos

        return dadosExemplo;
    }
}
