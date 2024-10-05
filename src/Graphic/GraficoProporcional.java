package Graphic;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import DATABASE.entidade.Candidato;

public class GraficoProporcional extends JPanel {

    private String tipoEleicao; // Tipo de eleição (ex: Senador, Deputado Federal, etc.)
    private int[] cadeiras; // Quantidade de cadeiras distribuídas
    private String[] partidos; // Partidos envolvidos
    private int[] votos; // Votos dos candidatos

    public GraficoProporcional(String tipoEleicao, List<Candidato> candidatos) {
        this.tipoEleicao = tipoEleicao;
        this.cadeiras = new int[]{0}; // Inicializa o array de cadeiras
        this.partidos = new String[]{""}; // Inicializa o array de partidos
        this.votos = new int[candidatos.size()]; // Inicializa o array de votos

        // Gera os dados com base no tipo de eleição
        gerarDados(tipoEleicao, candidatos);
    }

    private void gerarDados(String tipoEleicao, List<Candidato> candidatos) {
        // Gera os votos dos candidatos
        for (int i = 0; i < candidatos.size(); i++) {
            votos[i] = candidatos.get(i).getvotos(); // Obtém os votos do candidato
        }

        // Define a distribuição de cadeiras e partidos com base no tipo de eleição
        switch (tipoEleicao) {
            case "Senador":
                cadeiras = new int[]{2, 1, 1, 0}; // Exemplo de distribuição de cadeiras
                partidos = new String[]{"Partido A", "Partido B", "Partido C", "Partido D"};
                break;
            case "Deputado Federal":
                cadeiras = new int[]{5, 3, 2, 1}; // Exemplo de distribuição de cadeiras
                partidos = new String[]{"Partido X", "Partido Y", "Partido Z", "Partido W"};
                break;
            case "Deputado Estadual":
                cadeiras = new int[]{8, 5, 3, 2}; // Exemplo de distribuição de cadeiras
                partidos = new String[]{"Partido P", "Partido Q", "Partido R", "Partido S"};
                break;
            default:
                cadeiras = new int[0]; // Sem dados
                partidos = new String[0];
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharGrafico(g); // Chama o método para desenhar o gráfico
    }

    private void desenharGrafico(Graphics g) {
        int larguraBarra = 60; // Largura de cada barra no gráfico
        int espacoEntreBarras = 30; // Espaço entre as barras
        int alturaMaxima = getHeight() - 150; // Ajuste da altura máxima do gráfico

        // Eixos do gráfico
        int eixoY = getHeight() - 100;  // Ajusta o eixo Y
        int eixoX = getWidth() - 40; // Ajusta o eixo X

        g.drawLine(40, 40, 40, eixoY);  // Desenha o eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Desenha o eixo X

        // Cores para os partidos
        Color[] cores = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

        // Calcula o tamanho total do gráfico para centralizar as barras
        int totalBarras = cadeiras.length; // Total de barras (partidos)
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras); // Largura total do gráfico
        int inicioX = (getWidth() - larguraTotal) / 2; // Início do desenho das barras

        // Desenha as barras de cada partido
        for (int i = 0; i < cadeiras.length; i++) {
            // Calcula a altura da barra proporcional ao número de cadeiras
            int alturaBarra = (int) ((double) cadeiras[i] / getMaxCadeiras() * alturaMaxima);
            int x = inicioX + i * (larguraBarra + espacoEntreBarras); // Posição X da barra
            int y = eixoY - alturaBarra; // Posição Y da barra

            g.setColor(cores[i % cores.length]);  // Define a cor da barra
            g.fillRect(x, y, larguraBarra, alturaBarra); // Desenha a barra

            // Desenha os números das cadeiras acima da barra
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(cadeiras[i]), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(cadeiras[i])) / 2, y - 5);
            g.drawString(partidos[i], x + larguraBarra / 2 - g.getFontMetrics().stringWidth(partidos[i]) / 2, eixoY + 15);
        }

        // Desenha o título do gráfico
        g.drawString(tipoEleicao + " - Cadeiras", (getWidth() - g.getFontMetrics().stringWidth(tipoEleicao + " - Cadeiras")) / 2, 30);
    }

    private int getMaxCadeiras() {
        // Retorna o número máximo de cadeiras para normalizar o tamanho das barras
        int max = 0; 
        for (int cadeira : cadeiras) {
            if (cadeira > max) {
                max = cadeira; // Atualiza o máximo encontrado
            }
        }
        return max; // Retorna o número máximo de cadeiras
    }

    public void setNumCadeiras(int numCadeiras) {
        // Este método pode ser ajustado se você precisar modificar as cadeiras posteriormente
        cadeiras = new int[numCadeiras]; // Inicializa o array de cadeiras com o novo tamanho
        partidos = new String[numCadeiras]; // Inicializa o array de partidos com o novo tamanho

        // Preenche o array de cadeiras e partidos com valores padrão
        for (int i = 0; i < numCadeiras; i++) {
            cadeiras[i] = (int) (Math.random() * 10); // Atribui um número aleatório de cadeiras (0 a 9)
            partidos[i] = "Partido " + (char) ('A' + i); // Atribui um nome padrão aos partidos
        }

        repaint(); // Repaint para atualizar a visualização do gráfico
    }
}
