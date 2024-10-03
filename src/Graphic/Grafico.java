package Graphic;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.List;

public abstract class Grafico extends JPanel {

    protected List<Candidato> candidatos; // Lista de candidatos a ser exibida
    protected UserDAO userDAO; // Para acessar os dados dos candidatos

    // Construtor que inicializa o UserDAO e a lista de candidatos
    public Grafico(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.candidatos = userDAO.ver_candidatos("Partido Exemplo"); // Ajuste para carregar candidatos de um partido
        repaint(); // Repaint para atualizar o gráfico com os candidatos
    }

    // Método abstrato para ser implementado nas subclasses
    protected abstract void drawGrafico(Graphics g);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrafico(g); // Chama o método de desenho do gráfico
    }
}
