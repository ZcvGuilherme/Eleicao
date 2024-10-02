package Graphic;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGraphic {
    private static JFrame frame;
    private static GraficoMajoritario graficoMajoritario;
    private static GraficoProporcional graficoProporcional;
    private static boolean isMajoritario = true; // Para controlar qual gráfico está visível

    public static void main(String[] args) {
        frame = new JFrame("Gráficos de Eleições");
        graficoMajoritario = new GraficoMajoritario();
        graficoProporcional = new GraficoProporcional();

        // Inicialmente, mostra o gráfico majoritário
        frame.setLayout(new BorderLayout());
        frame.add(graficoMajoritario, BorderLayout.CENTER);
        
        JButton botaoAlternar = new JButton("Mostrar Gráfico Proporcional");
        botaoAlternar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alternarGraficos();
            }
        });

        frame.add(botaoAlternar, BorderLayout.SOUTH);
        
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }

    private static void alternarGraficos() {
        // Alterna entre os gráficos
        if (isMajoritario) {
            frame.getContentPane().remove(graficoMajoritario);
            frame.getContentPane().add(graficoProporcional, BorderLayout.CENTER);
            isMajoritario = false;
        } else {
            frame.getContentPane().remove(graficoProporcional);
            frame.getContentPane().add(graficoMajoritario, BorderLayout.CENTER);
            isMajoritario = true;
        }
        
        frame.revalidate(); // Revalida a janela
        frame.repaint(); // Atualiza a janela
    }
}
