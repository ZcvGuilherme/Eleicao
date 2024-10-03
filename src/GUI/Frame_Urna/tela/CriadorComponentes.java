package GUI.Frame_Urna.tela;

import javax.swing.*;
import java.awt.*;

public class CriadorComponentes {

    public static JLabel criarLabel(String texto, int x, int y, int largura, int altura) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, largura, altura);
        label.setFont(new Font("Arial", Font.PLAIN, 50)); // Define a fonte
        return label;
    }

    public static JTextField criarTextField(int x, int y, int largura, int altura) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, largura, altura);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        return textField;
    }
}
