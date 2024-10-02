package GUI.Frame_Urna;

import java.awt.*;
import javax.swing.*;

class UrnaPanel extends JPanel {
    public UrnaPanel() {
        setLayout(null);
        placeComponents();
    }

    private void placeComponents() {
        createWhiteBoard();
        createButtons();
    }

    private void createWhiteBoard() {
        CriadorComponentes whiteBoard = new QuadroBranco();
        whiteBoard.criadorComponentes(this);
    }

    private void createButtons() {
        Font fontBotao = new Font("Arial", Font.PLAIN, 40);
        Font fontBotaoTxt = new Font("Arial", Font.PLAIN, 20);

        // Criando os botões numéricos
        for (int n = 1; n <= 9; n++) {
            CriadorComponentes botao = new BotoesCriacao(String.valueOf(n), 910 + (n - 1) % 3 * 120, 150 + (n - 1) / 3 * 100, fontBotao);
            botao.criadorComponentes(this);
        }

        // Criando os botões de "0", "Branco", "Corrige", "Confirma"
        new BotoesCriacao("0", 1030, 450, fontBotao).criadorComponentes(this);
        new BotoesCriacao("Branco", 850, 600, fontBotaoTxt).criadorComponentes(this);
        new BotoesCriacao("Corrige", 1010, 600, fontBotaoTxt).criadorComponentes(this);
        new BotoesCriacao("Confirma", 1170, 570, fontBotaoTxt, 150, 100).criadorComponentes(this);
    }
}