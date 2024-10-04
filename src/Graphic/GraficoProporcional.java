package Graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class GraficoProporcional extends JPanel {

    private List<String> candidatos = new ArrayList<>();
    private List<Integer> votos = new ArrayList<>();
    private List<Integer> cadeiras = new ArrayList<>();
    private int totalCadeiras = 10; // Total de cadeiras disponíveis no parlamento

    public GraficoProporcional() {
        gerarTabela();
        calcularCadeiras();
    }

    // Gera tabela de candidatos proporcionais
    private void gerarTabela() {
        candidatos.add("Candidato A");
        votos.add(150);
        candidatos.add("Candidato B");
        votos.add(120);
        candidatos.add("Candidato C");
        votos.add(80);
        candidatos.add("Candidato D");
        votos.add(50);
        
        // Adicionando votos brancos e nulos
        candidatos.add("Votos Brancos");
        votos.add(30);
        candidatos.add("Votos Nulos");
        votos.add(20);
    }

    // Calcula o número de cadeiras proporcionalmente aos votos (exceto para brancos e nulos)
    private void calcularCadeiras() {
        int totalVotosValidos = 0;

        // Soma apenas os votos válidos (exclui brancos e nulos)
        for (int i = 0; i < votos.size() - 2; i++) {
            totalVotosValidos += votos.get(i);
        }

        // Calcula as cadeiras com base na proporção de votos válidos
        for (int i = 0; i < votos.size() - 2; i++) {
            int cadeirasPartido = (int) Math.round(((double) votos.get(i) / totalVotosValidos) * totalCadeiras);
            cadeiras.add(cadeirasPartido);
        }

        // Para brancos e nulos, as cadeiras são zero
        cadeiras.add(0);  // Votos Brancos
        cadeiras.add(0);  // Votos Nulos
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraficoProporcional(g);
    }

    // Desenha o gráfico de eleições proporcionais com o número de cadeiras
    private void drawGraficoProporcional(Graphics g) {
        int larguraBarra = 60;
        int espacoEntreBarras = 30;

        int eixoY = getHeight() - 60;  // Ajuste para garantir que o eixo fique na parte inferior da janela
        int eixoX = getWidth() - 40;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresProporcionais = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.LIGHT_GRAY, Color.DARK_GRAY};

        int totalBarras = votos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        for (int i = 0; i < votos.size(); i++) {
            // Calcula a altura da barra proporcional ao total de cadeiras
            int alturaBarra = (int) ((double) cadeiras.get(i) / totalCadeiras * (getHeight() - 100));  // Ajuste na altura da barra
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresProporcionais[i]);
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            // Desenha o número de cadeiras acima da barra (ou votos no caso de brancos/nulos)
            if (i < cadeiras.size() - 2) {
                g.drawString(String.valueOf(cadeiras.get(i)), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(cadeiras.get(i))) / 2, y - 5);
            } else {
                g.drawString(String.valueOf(votos.get(i)), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(votos.get(i))) / 2, y - 5);
            }
            g.drawString(candidatos.get(i), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(candidatos.get(i)) / 2, eixoY + 15);
        }

        g.drawString("Eleições Proporcionais", (getWidth() - g.getFontMetrics().stringWidth("Eleições Proporcionais")) / 2, 30);
    }
}
