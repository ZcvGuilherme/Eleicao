package GUI.Frame_Urna;

import javax.swing.*;
import java.awt.*;

public class QuadroBranco {

    public static void adicionarAoPanel(JPanel panel, int x, int y, int largura, int altura) {
        JPanel quadroBranco = new JPanel();
        quadroBranco.setBackground(Color.WHITE);
        quadroBranco.setBounds(x, y, largura, altura);
        panel.add(quadroBranco);
    }
}
