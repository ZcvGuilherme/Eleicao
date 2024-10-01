package GUI.Frame_Urna;

import java.awt.*;
import javax.swing.*;

class UrnaPanel extends JPanel {
    public UrnaPanel() {
        setLayout(null);
        placeComponents();
    }

    private void placeComponents() {
        createButtons();
        createWhiteBoard();
    }

    private void createWhiteBoard() {
        JPanel quadroBranco = new JPanel();
        quadroBranco.setBackground(Color.WHITE);
        quadroBranco.setBounds(50, 50, 700, 600);
        add(quadroBranco);
    }

    private void createButtons() {
        Font fontBotao = new Font("Arial", Font.PLAIN, 40);
        Font fontBotaoTxt = new Font("Arial", Font.PLAIN, 20);

        for (int n = 1; n <= 9; n++) {
            addButton(String.valueOf(n), 910 + (n - 1) % 3 * 120, 150 + (n - 1) / 3 * 100, fontBotao);
        }
        addButton("0", 1030, 450, fontBotao);
        addButton("Branco", 850, 600, fontBotaoTxt);
        addButton("Corrige", 1010, 600, fontBotaoTxt);
        addButton("Confirma", 1170, 570, fontBotaoTxt, 150, 100);
    }

    private void addButton(String text, int x, int y, Font font) {
        addButton(text, x, y, font, 100, 70);
    }

    private void addButton(String text, int x, int y, Font font, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        add(button);
    }
}
