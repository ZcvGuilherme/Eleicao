package Graphic;

import javax.swing.*;
import java.awt.*;

public class GraficoMajoritario extends JPanel {

    private int[] votos; // Quantidade de votos para candidatos genéricos
    private String[] candidatos; // Nomes dos candidatos genéricos
    private int brancos; // Votos brancos
    private int nulos;   // Votos nulos
    private boolean isPresidente; // Define se é uma eleição para Presidente ou Governador

    public GraficoMajoritario(boolean isPresidente) { // Construtor
        this.isPresidente = isPresidente;
        gerarDados(); // Chama o método para gerar dados de votação
    }

    // Gera dados genéricos para as eleições
    private void gerarDados() {
        if (isPresidente) {
            // Dados genéricos para Presidente
            this.votos = new int[]{100, 80, 60, 40}; // Exemplo de votos
            this.candidatos = new String[]{"Candidato A", "Candidato B", "Candidato C", "Candidato D"};
        } else {
            // Dados genéricos para Governador
            this.votos = new int[]{90, 70, 50, 30}; // Exemplo de votos
            this.candidatos = new String[]{"Candidato X", "Candidato Y", "Candidato Z", "Candidato W"};
        }
        // Votos brancos e nulos genéricos
        this.brancos = 20; // Exemplo de votos brancos
        this.nulos = 10; // Exemplo de votos nulos
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Chama o método da superclasse
        drawGraficoMajoritario(g); // Chama o método para desenhar o gráfico
    }

    // Desenha o gráfico de barras para a eleição majoritária
    private void drawGraficoMajoritario(Graphics g) {
        int larguraBarra = 60; // Largura de cada barra do gráfico
        int espacoEntreBarras = 30; // Espaço entre as barras
        int maxVotos = 200; // Valor máximo de votos para normalização das barras

        int eixoY = getHeight() - 100;  // Ajuste para garantir que o eixo fique na parte inferior da janela
        int eixoX = getWidth() - 40; // Define a posição do eixo X

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresMajoritarios = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE}; // Cores para as barras

        int totalBarras = votos.length; // Total de barras a serem desenhadas
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras); // Largura total do gráfico
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        // Desenha as barras dos candidatos
        for (int i = 0; i < votos.length; i++) {
            int alturaBarra = (int) ((double) votos[i] / maxVotos * (getHeight() - 150));  // Ajuste na altura da barra
            int x = inicioX + i * (larguraBarra + espacoEntreBarras); // Calcula a posição X da barra
            int y = eixoY - alturaBarra; // Calcula a posição Y da barra

            g.setColor(coresMajoritarios[i % coresMajoritarios.length]); // Define a cor da barra
            g.fillRect(x, y, larguraBarra, alturaBarra); // Desenha a barra

            g.setColor(Color.BLACK);
            // Desenha os votos acima da barra
            g.drawString(String.valueOf(votos[i]), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(votos[i])) / 2, y - 5);
            g.drawString(candidatos[i], x + larguraBarra / 2 - g.getFontMetrics().stringWidth(candidatos[i]) / 2, eixoY + 15);
        }

        // Desenha as barras de votos brancos e nulos
        int alturaBrancos = (int) ((double) brancos / maxVotos * (getHeight() - 150)); // Calcula a altura da barra de brancos
        int alturaNulos = (int) ((double) nulos / maxVotos * (getHeight() - 150)); // Calcula a altura da barra de nulos
        int xBrancos = inicioX + totalBarras * (larguraBarra + espacoEntreBarras); // Posição da barra de brancos
        int xNulos = xBrancos + larguraBarra + espacoEntreBarras; // Posição da barra de nulos

        // Barra para votos brancos
        g.setColor(Color.WHITE); // Cor branca para a barra de votos brancos
        g.fillRect(xBrancos, eixoY - alturaBrancos, larguraBarra, alturaBrancos); // Desenha a barra de brancos
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(brancos), xBrancos + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(brancos)) / 2, eixoY - alturaBrancos - 5); // Exibe a quantidade de votos brancos
        g.drawString("Brancos", xBrancos + larguraBarra / 2 - g.getFontMetrics().stringWidth("Brancos") / 2, eixoY + 15); // Exibe o texto "Brancos"

        // Barra para votos nulos
        g.setColor(Color.LIGHT_GRAY); // Cor cinza claro para a barra de votos nulos
        g.fillRect(xNulos, eixoY - alturaNulos, larguraBarra, alturaNulos); // Desenha a barra de nulos
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(nulos), xNulos + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(nulos)) / 2, eixoY - alturaNulos - 5); // Exibe a quantidade de votos nulos
        g.drawString("Nulos", xNulos + larguraBarra / 2 - g.getFontMetrics().stringWidth("Nulos") / 2, eixoY + 15); // Exibe o texto "Nulos"

        // Desenha o título do gráfico
        String titulo = isPresidente ? "Presidente" : "Governador"; // Define o título com base no tipo de eleição
        g.drawString(titulo + " - Votos", (getWidth() - g.getFontMetrics().stringWidth(titulo + " - Votos")) / 2, 30); // Centraliza o título no topo
    }
}
