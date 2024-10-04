package Graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class GraficoProporcional extends JPanel {

    private List<String> partidos = new ArrayList<>();
    private List<Integer> cadeiras = new ArrayList<>();

    public GraficoProporcional() {
        gerarTabela();
    }

    // Gera tabela de partidos proporcionais
    private void gerarTabela() {
        partidos.add("Partido X");
        cadeiras.add(10);
        partidos.add("Partido Y");
        cadeiras.add(15);
        partidos.add("Partido Z");
        cadeiras.add(5);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraficoProporcional(g);
    }

    // Desenha o gráfico de eleições proporcionais
    private void drawGraficoProporcional(Graphics g) {
        int larguraBarra = 60;
        int espacoEntreBarras = 30;
        int maxCadeiras = 20;

        int eixoY = getHeight() / 2 + 20;
        int eixoX = getWidth() - 20;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresProporcionais = {Color.MAGENTA, Color.CYAN, Color.YELLOW};

        int totalBarras = cadeiras.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        for (int i = 0; i < cadeiras.size(); i++) {
            int alturaBarra = (int) ((double) cadeiras.get(i) / maxCadeiras * (getHeight() / 2 - 60));
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresProporcionais[i]);
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            // Desenha as cadeiras acima da barra
            g.drawString(String.valueOf(cadeiras.get(i)), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(cadeiras.get(i))) / 2, y - 5);
            g.drawString(partidos.get(i), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(partidos.get(i)) / 2, eixoY + 15);
        }

        g.drawString("Eleições Proporcionais", (getWidth() - g.getFontMetrics().stringWidth("Eleições Proporcionais")) / 2, 30);
    }
}
