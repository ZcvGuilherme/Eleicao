package GUI;

import java.awt.*;
import javax.swing.*;

public class teste {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Urna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(null); // Manter layout nulo para os botões
        frame.add(panel);
        placeComponents(panel);
        
        // Adicionando o quadro branco
        JPanel quadroBranco = new JPanel();
        quadroBranco.setBackground(Color.WHITE);
        quadroBranco.setBounds(50, 50, 700, 600); // Ajuste a posição e tamanho conforme necessário
        panel.add(quadroBranco);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        /* Fonte */
        Font fontbotao = new Font("Arial", Font.PLAIN, 40); // Fonte Arial, estilo normal, tamanho 40
        Font fontbotaotxt = new Font("Arial", Font.PLAIN, 20);

        /* Botões Números */
        // Botões n
        for (int n = 1; n <= 9; n++) {
            JButton botao = new JButton(String.valueOf(n));
            botao.setBounds(910 + (n - 1) % 3 * 120, 150 + (n - 1) / 3 * 100, 100, 70);
            botao.setFont(fontbotao);
            panel.add(botao);
        }

        // Botão 0
        JButton Botao0 = new JButton("0");
        Botao0.setBounds(1030, 450, 100, 70);
        panel.add(Botao0);
        Botao0.setFont(fontbotao);

        /* Botões Outros */
        // Branco
        JButton BotaoBranco = new JButton("Branco");
        BotaoBranco.setBounds(850, 600, 150, 70);
        panel.add(BotaoBranco);
        BotaoBranco.setFont(fontbotaotxt);
        
        // Corrige
        JButton BotaoCorrige = new JButton("Corrige");
        BotaoCorrige.setBounds(1010, 600, 150, 70);
        panel.add(BotaoCorrige);
        BotaoCorrige.setFont(fontbotaotxt);
    
        // Confirma
        JButton BotaoConfirma = new JButton("Confirma");
        BotaoConfirma.setBounds(1170, 570, 150, 100);
        panel.add(BotaoConfirma);
        BotaoConfirma.setFont(fontbotaotxt);
    }
}
