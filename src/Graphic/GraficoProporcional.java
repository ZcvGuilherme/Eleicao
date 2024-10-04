package Graphic;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraficoProporcional extends JPanel {

    private List<Candidato> partidos = new ArrayList<>();
    private String tipo;
    private int totalVotos = setVotosTotais();
    private int cadeiras = 4;
    private UserDAO dao = new UserDAO();

    public GraficoProporcional(String tipo) {
        this.tipo = tipo;
        gerarTabela();
    }

    // Gera tabela de partidos proporcionais
    private void gerarTabela() {
        
        partidos = dao.retornoTodosCandidatos(); // Recupera todos os candidatos

        
        // Aqui, você deve filtrar os candidatos de acordo com o tipo para obter as cadeiras
        // e definir a lógica para obter o número de cadeiras por partido.
    }
    private int setVotosTotais(){
        List<Candidato> candidatos = dao.retornoTodosCandidatos();
        return candidatos.size();
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
        int maxCadeiras = 15;  // Ajuste para o número máximo de cadeiras que pode ser mostrado

        int eixoY = getHeight() - 60;
        int eixoX = getWidth() - 40;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresProporcionais = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.CYAN};

        int totalBarras = partidos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        for (int i = 0; i < partidos.size(); i++) {
            Candidato partido = partidos.get(i);
            int alturaBarra = (int) ((double) partido.getvotos() / maxCadeiras * (getHeight() - 100));
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresProporcionais[i % coresProporcionais.length]); // Use uma cor do array
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            // Desenha o número de cadeiras acima da barra
            g.drawString(String.valueOf(partido.getvotos()), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(partido.getvotos())) / 2, y - 5);
            g.drawString(partido.getPartido(), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(partido.getPartido()) / 2, eixoY + 15);
        }

        g.drawString(tipo + " - Cadeiras", (getWidth() - g.getFontMetrics().stringWidth(tipo + " - Cadeiras")) / 2, 30);
    }
}
