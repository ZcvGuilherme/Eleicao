package GUI.Frame_Urna;

import javax.swing.*;

public class TelaVota {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UrnaFrame().setVisible(true);
        });
    }
}
