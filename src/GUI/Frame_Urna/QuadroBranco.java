package GUI.Frame_Urna;

import java.awt.*;
import javax.swing.*;


class QuadroBranco implements CriadorComponentes {
    @Override
    public void criadorComponentes(JPanel panel) {
        JPanel quadroBranco = new JPanel();
        quadroBranco.setBackground(Color.WHITE);
        quadroBranco.setBounds(50, 50, 700, 600);
        panel.add(quadroBranco);
    }
}