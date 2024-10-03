package Graphic;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class GraficoMajoritario extends JPanel {

    private List<Candidato> candidatos; // Lista de candidatos a ser exibida
    private UserDAO userDAO; // Para acessar os dados dos candidatos

    public GraficoMajoritario(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.candidatos = userDAO.ver_candidatos("Partido Exemplo"); // Ajuste para carregar candidatos de um partido
        repaint(); // Repaint para atualizar o gráfico com os candidatos
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
        int maxVotos = 200; // Valor máximo de votos para normalização

        int eixoY = getHeight() / 2 + 20;
        int eixoX = getWidth() - 20;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresMajoritarios = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

        int totalBarras = candidatos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        for (int i = 0; i < totalBarras; i++) {
            Candidato candidato = candidatos.get(i);
            int alturaBarra = (int) ((double) candidato.getvotos() / maxVotos * (getHeight() / 2 - 80));
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresMajoritarios[i % coresMajoritarios.length]); // Usar cores circulares
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            g.drawString(candidato.getNome(), x, eixoY + 15);
        }

        g.drawString("Eleições Majoritárias", (getWidth() - g.getFontMetrics().stringWidth("Eleições Majoritárias")) / 2, 30);
    }
}
