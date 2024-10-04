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
        // Inicializa a janela do JFrame
        frame = new JFrame("Gráficos de Eleições");

        // Cria os gráficos de eleições majoritárias e proporcionais
        graficoMajoritario = new GraficoMajoritario();
        graficoProporcional = new GraficoProporcional();

        // Inicialmente, exibe o gráfico majoritário
        frame.setLayout(new BorderLayout());
        frame.add(graficoMajoritario, BorderLayout.CENTER);

        // Botão para alternar entre os gráficos majoritário e proporcional
        JButton botaoAlternar = new JButton("Mostrar Gráfico Proporcional");
        botaoAlternar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alternarGraficos(botaoAlternar); // Alterna os gráficos ao clicar no botão
            }
        });

        // Adiciona o botão na parte inferior da janela
        frame.add(botaoAlternar, BorderLayout.SOUTH);

        // Configurações da janela
        frame.setSize(800, 600); // Aumentei o tamanho para garantir que os gráficos apareçam corretamente
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true);
    }

    // Método responsável por alternar entre os gráficos majoritário e proporcional
    private static void alternarGraficos(JButton botaoAlternar) {
        // Se o gráfico majoritário estiver visível, troca para o gráfico proporcional
        if (isMajoritario) {
            frame.getContentPane().remove(graficoMajoritario);
            frame.getContentPane().add(graficoProporcional, BorderLayout.CENTER);
            botaoAlternar.setText("Mostrar Gráfico Majoritário"); // Atualiza o texto do botão
            isMajoritario = false; // Define que o gráfico proporcional está visível
        } else {
            // Se o gráfico proporcional estiver visível, troca para o gráfico majoritário
            frame.getContentPane().remove(graficoProporcional);
            frame.getContentPane().add(graficoMajoritario, BorderLayout.CENTER);
            botaoAlternar.setText("Mostrar Gráfico Proporcional"); // Atualiza o texto do botão
            isMajoritario = true; // Define que o gráfico majoritário está visível
        }

        // Revalida e repinta a janela para que a troca de gráficos seja refletida
        frame.revalidate();
        frame.repaint();
    }
}
