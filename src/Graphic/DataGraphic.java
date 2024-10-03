package Graphic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Classe responsável pelo processamento de dados dos gráficos
public class DataGraphic {

    // Calcula o valor máximo da lista para escalar os gráficos
    public int calcularMaxValor(List<Integer> valores) {
        int maxValor = 0;
        for (int valor : valores) {
            if (valor > maxValor) {
                maxValor = valor;
            }
        }
        return maxValor;
    }

    // Normaliza os valores para uma escala de 0 a 100
    public List<Double> normalizarValores(List<Integer> valores, int maxValor) {
        List<Double> valoresNormalizados = new ArrayList<>();
        for (int valor : valores) {
            valoresNormalizados.add((double) valor / maxValor * 100);
        }
        return valoresNormalizados;
    }

    // Método de exemplo para gerar dados fictícios
    public List<List<?>> gerarDadosExemplo() {
        // Substituindo List.of() por Arrays.asList() para compatibilidade com Java 8
        List<String> rotulos = Arrays.asList("Candidato A", "Candidato B", "Candidato C", "Candidato D");
        List<Integer> votos = Arrays.asList(150, 120, 80, 50);

        List<List<?>> dadosExemplo = new ArrayList<>();
        dadosExemplo.add(rotulos); // Adiciona a lista de rótulos
        dadosExemplo.add(votos);   // Adiciona a lista de valores (votos)

        return dadosExemplo;
    }
}
