package Graphic;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public abstract class Grafico extends JPanel {
    protected List<String> rotulos; // Para os rótulos (candidatos ou partidos)
    protected List<Integer> valores; // Para os votos ou cadeiras

    protected int larguraBarra = 60; // Largura da barra
    protected int espacoEntreBarras = 30; // Espaço entre barras
    protected int maxValor; // Valor máximo para escalar as barras

    public Grafico(List<String> rotulos, List<Integer> valores, int maxValor) {
        this.rotulos = rotulos;
        this.valores = valores;
        this.maxValor = maxValor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrafico(g);
    }

    protected abstract void drawGrafico(Graphics g); // Método a ser implementado nas subclasses
}
