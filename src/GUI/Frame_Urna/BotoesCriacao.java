package GUI.Frame_Urna;

import java.awt.*;
import javax.swing.*;


class BotoesCriacao implements CriadorComponentes {
    private String text;
    private int x, y, width, height;
    private Font font;

    public BotoesCriacao(String text, int x, int y, Font font) {
        this(text, x, y, font, 100, 70);
    }

    public BotoesCriacao(String text, int x, int y, Font font, int width, int height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.font = font;
        this.width = width;
        this.height = height;
    }

    @Override
    public void criadorComponentes(JPanel panel) {
        JButton botao = new JButton(text);
        botao.setBounds(x, y, width, height);
        botao.setFont(font);
        panel.add(botao);
    }
}
