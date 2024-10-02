package GUI.Frame_Urna;

import javax.swing.*;
import java.awt.*;

public class BotaoCriar {

    private static final Font FONT_BOTAO = new Font("Arial", Font.PLAIN, 40);
    private static final Font FONT_BOTAO_TEXTO = new Font("Arial", Font.PLAIN, 20);

    public static void adicionarBotoesNumericos(JPanel panel) {
        for (int n = 1; n <= 9; n++) {
            JButton botao = new JButton(String.valueOf(n));
            botao.setBounds(910 + (n - 1) % 3 * 120, 150 + (n - 1) / 3 * 100, 100, 70);
            botao.setFont(FONT_BOTAO);
            panel.add(botao);
        }

        JButton botao0 = new JButton("0");
        botao0.setBounds(1030, 450, 100, 70);
        botao0.setFont(FONT_BOTAO);
        panel.add(botao0);
    }

    public static void adicionarBotoesFuncionais(JPanel panel) {
        JButton botaoBranco = criarBotao("Branco", 850, 600, 150, 70, FONT_BOTAO_TEXTO);
        panel.add(botaoBranco);

        JButton botaoCorrige = criarBotao("Corrige", 1010, 600, 150, 70, FONT_BOTAO_TEXTO);
        panel.add(botaoCorrige);

        JButton botaoConfirma = criarBotao("Confirma", 1170, 570, 150, 100, FONT_BOTAO_TEXTO);
        panel.add(botaoConfirma);
    }

    private static JButton criarBotao(String texto, int x, int y, int largura, int altura, Font fonte) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, largura, altura);
        botao.setFont(fonte);
        return botao;
    }
}

