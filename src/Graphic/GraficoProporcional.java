package Graphic;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import DATABASE.entidade.Candidato;

public class GraficoProporcional extends JPanel {

    private String tipoEleicao; // Tipo da eleição (e.g., Senador, Deputado)
    private int[] cadeiras; // Quantidade de cadeiras distribuídas
    private String[] partidos; // Partidos envolvidos na eleição

    public GraficoProporcional(String tipoEleicao, List<Candidato> candidatos) {
        this.tipoEleicao = tipoEleicao; // Define o tipo de eleição
        this.cadeiras = new int[]{0}; // Inicializa o array de cadeiras com um valor padrão
        this.partidos = new String[]{""}; // Inicializa o array de partidos com um valor padrão
        
        // Gera os dados com base no tipo de eleição
        gerarDados(tipoEleicao, candidatos); // Chama o método para gerar os dados
    }

    private void gerarDados(String tipoEleicao, List<Candidato> candidatos) {
        // Apenas para fins de exemplo, valores fixos foram atribuídos
        // Você pode ajustar conforme a lógica necessária para os dados reais
        
        switch (tipoEleicao) {
            case "Senador":
                cadeiras = new int[]{2, 1, 1, 0}; // Exemplo de distribuição de cadeiras para Senador
                partidos = new String[]{"Partido A", "Partido B", "Partido C", "Partido D"}; // Nomes dos partidos
                break;
            case "Deputado Federal":
                cadeiras = new int[]{5, 3, 2, 1}; // Exemplo de distribuição de cadeiras para Deputado Federal
                partidos = new String[]{"Partido X", "Partido Y", "Partido Z", "Partido W"};
                break;
            case "Deputado Estadual":
                cadeiras = new int[]{8, 5, 3, 2}; // Exemplo de distribuição de cadeiras para Deputado Estadual
                partidos = new String[]{"Partido P", "Partido Q", "Partido R", "Partido S"};
                break;
            default:
                cadeiras = new int[0]; // Sem dados
                partidos = new String[0]; // Sem partidos
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Chama o método da superclasse para limpar o painel
        desenharGrafico(g); // Chama o método para desenhar o gráfico
    }

    private void desenharGrafico(Graphics g) {
        int larguraBarra = 60; // Largura de cada barra do gráfico
        int espacoEntreBarras = 30; // Espaço entre as barras
        int alturaMaxima = getHeight() - 150; // Ajuste da altura máxima do gráfico

        // Eixos do gráfico
        int eixoY = getHeight() - 100;  // Ajusta o eixo Y para a parte inferior
        int eixoX = getWidth() - 40; // Ajusta o eixo X para a parte direita

        g.drawLine(40, 40, 40, eixoY);  // Desenha o eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Desenha o eixo X

        // Cores para os partidos
        Color[] cores = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE}; // Define cores para as barras

        // Calcula o tamanho total do gráfico para centralizar as barras
        int totalBarras = cadeiras.length; // Total de barras a serem desenhadas
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras); // Largura total do gráfico
        int inicioX = (getWidth() - larguraTotal) / 2; // Ponto inicial para centralizar as barras

        // Desenha as barras de cada partido
        for (int i = 0; i < cadeiras.length; i++) {
            int alturaBarra = (int) ((double) cadeiras[i] / getMaxCadeiras() * alturaMaxima); // Calcula a altura da barra
            int x = inicioX + i * (larguraBarra + espacoEntreBarras); // Calcula a posição X da barra
            int y = eixoY - alturaBarra; // Calcula a posição Y da barra

            g.setColor(cores[i % cores.length]);  // Define a cor da barra
            g.fillRect(x, y, larguraBarra, alturaBarra); // Desenha a barra

            // Desenha os números das cadeiras acima da barra
            g.setColor(Color.BLACK); // Define a cor do texto
            g.drawString(String.valueOf(cadeiras[i]), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(cadeiras[i])) / 2, y - 5); // Números das cadeiras
            g.drawString(partidos[i], x + larguraBarra / 2 - g.getFontMetrics().stringWidth(partidos[i]) / 2, eixoY + 15); // Nomes dos partidos
        }

        // Desenha o título do gráfico
        g.drawString(tipoEleicao + " - Cadeiras", (getWidth() - g.getFontMetrics().stringWidth(tipoEleicao + " - Cadeiras")) / 2, 30); // Título do gráfico
    }

    private int getMaxCadeiras() {
        // Retorna o número máximo de cadeiras para normalizar o tamanho das barras
        int max = 0; // Inicializa o máximo
        for (int cadeira : cadeiras) { // Itera sobre as cadeiras
            if (cadeira > max) {
                max = cadeira; // Atualiza o máximo se necessário
            }
        }
        return max; // Retorna o valor máximo encontrado
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

        repaint(); // Chama repaint para atualizar a visualização do gráfico
    }
}
