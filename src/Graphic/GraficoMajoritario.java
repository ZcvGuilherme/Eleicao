package Graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class GraficoMajoritario extends JPanel {

    private List<String> candidatos = new ArrayList<>();
    private List<Integer> votos = new ArrayList<>();

    public GraficoMajoritario() {
        gerarTabela();
    }

    // Gera tabela de candidatos majoritários
    private void gerarTabela() {
        candidatos.add("Candidato A");
        votos.add(150);
        candidatos.add("Candidato B");
        votos.add(120);
        candidatos.add("Candidato C");
        votos.add(80);
        candidatos.add("Candidato D");
        votos.add(50);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraficoMajoritario(g);
    }

    // Desenha o gráfico de eleições majoritárias
    private void drawGraficoMajoritario(Graphics g) {
        int larguraBarra = 60;
        int espacoEntreBarras = 30;
        int maxVotos = 200;

        int eixoY = getHeight() / 2 + 20;
        int eixoX = getWidth() - 20;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresMajoritarios = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

        int totalBarras = votos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        for (int i = 0; i < votos.size(); i++) {
            int alturaBarra = (int) ((double) votos.get(i) / maxVotos * (getHeight() / 2 - 80));
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresMajoritarios[i]);
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            // Desenha os votos acima da barra
            g.drawString(String.valueOf(votos.get(i)), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(votos.get(i))) / 2, y - 5);
            g.drawString(candidatos.get(i), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(candidatos.get(i)) / 2, eixoY + 15);
        }

        g.drawString("Eleições Majoritárias", (getWidth() - g.getFontMetrics().stringWidth("Eleições Majoritárias")) / 2, 30);
    }
}
