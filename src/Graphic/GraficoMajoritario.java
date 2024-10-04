package Graphic;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraficoMajoritario extends JPanel {

    private List<Candidato> candidatos = new ArrayList<>();
    private int brancos;
    private int nulos;
    private boolean isPresidente;

    public GraficoMajoritario(boolean isPresidente) {
        this.isPresidente = isPresidente;
        gerarTabela();
    }

    // Gera tabela de candidatos majoritários
    private void gerarTabela() {
        UserDAO userDAO = new UserDAO();
        if (isPresidente) {
            candidatos = userDAO.ver_candidatos("Presidente");
        } else {
            candidatos = userDAO.ver_candidatos("Governador");
        }

        // Aqui, você deve buscar os votos nulos e brancos de outra maneira (exemplo, de uma tabela de eleição)
        // brancos e nulos podem ser buscados através de uma consulta apropriada ao banco de dados
        // Para fins de exemplo, vamos usar valores fixos
        this.brancos = 20; // Exemplo de votos brancos
        this.nulos = 10; // Exemplo de votos nulos
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

        int eixoY = getHeight() - 100;  // Ajusta para garantir que o eixo fique na parte inferior da janela
        int eixoX = getWidth() - 40;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresMajoritarios = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

        int totalBarras = candidatos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        // Desenha as barras dos candidatos
        for (int i = 0; i < candidatos.size(); i++) {
            Candidato candidato = candidatos.get(i);
            int alturaBarra = (int) ((double) candidato.getvotos() / maxVotos * (getHeight() - 150));  // Ajuste na altura da barra
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresMajoritarios[i % coresMajoritarios.length]); // Use uma cor do array
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            // Desenha os votos acima da barra
            g.drawString(String.valueOf(candidato.getvotos()), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(candidato.getvotos())) / 2, y - 5);
            g.drawString(candidato.getNome(), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(candidato.getNome()) / 2, eixoY + 15);
        }

        // Desenha as barras de votos brancos e nulos
        int alturaBrancos = (int) ((double) brancos / maxVotos * (getHeight() - 150));
        int alturaNulos = (int) ((double) nulos / maxVotos * (getHeight() - 150));
        int xBrancos = inicioX + totalBarras * (larguraBarra + espacoEntreBarras);
        int xNulos = xBrancos + larguraBarra + espacoEntreBarras;

        // Espaço para brancos e nulos centralizados
        g.setColor(Color.WHITE);
        g.fillRect(xBrancos, eixoY - alturaBrancos, larguraBarra, alturaBrancos);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(brancos), xBrancos + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(brancos)) / 2, eixoY - alturaBrancos - 5);
        g.drawString("Brancos", xBrancos + larguraBarra / 2 - g.getFontMetrics().stringWidth("Brancos") / 2, eixoY + 15);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(xNulos, eixoY - alturaNulos, larguraBarra, alturaNulos);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(nulos), xNulos + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(nulos)) / 2, eixoY - alturaNulos - 5);
        g.drawString("Nulos", xNulos + larguraBarra / 2 - g.getFontMetrics().stringWidth("Nulos") / 2, eixoY + 15);

        // Desenha o título do gráfico
        String titulo = isPresidente ? "Presidente" : "Governador";
        g.drawString(titulo + " - Votos", (getWidth() - g.getFontMetrics().stringWidth(titulo + " - Votos")) / 2, 30);
    }
}
