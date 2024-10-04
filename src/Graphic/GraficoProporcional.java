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
    private int totalVotos;
    private int cadeiras = 10;  // Número de cadeiras a serem distribuídas (ajustável)
    private UserDAO dao = new UserDAO();
    private List<Integer> cadeirasPorPartido = new ArrayList<>(); // Armazenar cadeiras distribuídas para cada partido

    public GraficoProporcional(String tipo) {
        this.tipo = tipo;
        gerarTabela();
        calcularCadeiras();  // Calcula as cadeiras ao iniciar o gráfico
    }

    // Gera tabela de partidos proporcionais
    private void gerarTabela() {
        partidos = dao.retornoTodosCandidatos(); // Recupera todos os candidatos (ou partidos, se aplicável)
        totalVotos = setVotosTotais();
    }

    private int setVotosTotais() {
        int totalVotos = 0;
        for (Candidato candidato : partidos) {
            totalVotos += candidato.getvotos();
        }
        return totalVotos;
    }

    // Método que distribui cadeiras usando o método de Hondt
    private void calcularCadeiras() {
        // Inicializa o array de cadeiras por partido
        cadeirasPorPartido.clear();
        int[] cadeirasTemp = new int[partidos.size()]; // Array temporário para armazenar cadeiras
        List<Double> quocientes = new ArrayList<>();

        // Gera quocientes para cada partido (votos / divisores)
        for (Candidato partido : partidos) {
            for (int j = 1; j <= cadeiras; j++) {
                quocientes.add((double) partido.getvotos() / j);
            }
        }

        // Ordena os quocientes em ordem decrescente
        quocientes.sort((a, b) -> Double.compare(b, a));

        // Define o menor quociente que receberá uma cadeira
        double limiar = quocientes.get(cadeiras - 1);

        // Distribui as cadeiras com base no limiar
        for (int i = 0; i < partidos.size(); i++) {
            Candidato partido = partidos.get(i);
            int cadeirasRecebidas = 0;

            for (int j = 1; j <= cadeiras; j++) {
                if ((double) partido.getvotos() / j >= limiar) {
                    cadeirasRecebidas++;
                }
            }
            cadeirasTemp[i] = cadeirasRecebidas; // Armazena cadeiras recebidas por partido
            cadeirasPorPartido.add(cadeirasRecebidas); // Armazena na lista de cadeiras
        }
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
        int maxCadeiras = cadeiras;  // Número máximo de cadeiras que pode ser mostrado

        int eixoY = getHeight() - 60;
        int eixoX = getWidth() - 40;

        g.drawLine(40, 40, 40, eixoY);  // Eixo Y
        g.drawLine(40, eixoY, eixoX, eixoY);  // Eixo X

        Color[] coresProporcionais = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.CYAN};

        int totalBarras = partidos.size();
        int larguraTotal = (totalBarras * larguraBarra) + ((totalBarras - 1) * espacoEntreBarras);
        int inicioX = (getWidth() - larguraTotal) / 2; // Centraliza o gráfico

        // Desenha as barras para cada partido
        for (int i = 0; i < partidos.size(); i++) {
            Candidato partido = partidos.get(i);
            int cadeirasRecebidas = cadeirasPorPartido.get(i);  // Cadeiras calculadas para este partido
            int alturaBarra = (int) ((double) cadeirasRecebidas / maxCadeiras * (getHeight() - 100));  // Proporção da altura da barra
            int x = inicioX + i * (larguraBarra + espacoEntreBarras);
            int y = eixoY - alturaBarra;

            g.setColor(coresProporcionais[i % coresProporcionais.length]); // Use uma cor do array
            g.fillRect(x, y, larguraBarra, alturaBarra);
            g.setColor(Color.BLACK);
            // Desenha o número de cadeiras acima da barra
            g.drawString(String.valueOf(cadeirasRecebidas), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(String.valueOf(cadeirasRecebidas)) / 2, y - 5);
            g.drawString(partido.getPartido(), x + larguraBarra / 2 - g.getFontMetrics().stringWidth(partido.getPartido()) / 2, eixoY + 15);
        }

        g.drawString(tipo + " - Cadeiras", (getWidth() - g.getFontMetrics().stringWidth(tipo + " - Cadeiras")) / 2, 30);
    }
}
