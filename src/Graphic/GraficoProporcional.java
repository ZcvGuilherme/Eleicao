package Graphic;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class GraficoProporcional extends JPanel {

    private List<Candidato> candidatos; // Lista de candidatos a ser exibida
    private UserDAO userDAO; // Para acessar os dados dos candidatos

    public GraficoProporcional(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.candidatos = userDAO.ver_candidatos("Partido Exemplo"); // Ajuste para carregar candidatos de um partido
        repaint(); // Repaint para atualizar o gráfico com os candidatos
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
        int maxCadeiras = 20; // Valor máximo de cadeiras para normalização

        int eixoY = getHeight() / 2 + 20;
        int eixoX = getWidth() - 20;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresProporcionais = {Color.MAGENTA, Color.CYAN, Color.YELLOW};

        int totalBarras = candidatos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        for (int i = 0; i < totalBarras; i++) {
            Candidato candidato = candidatos.get(i);
            int alturaBarra = (int) ((double) candidato.getvotos() / maxCadeiras * (getHeight() / 2 - 60));
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresProporcionais[i % coresProporcionais.length]); // Usar cores circulares
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            g.drawString(candidato.getNome(), x, eixoY + 15);
        }

        g.drawString("Eleições Proporcionais", (getWidth() - g.getFontMetrics().stringWidth("Eleições Proporcionais")) / 2, 30);
    }
}
