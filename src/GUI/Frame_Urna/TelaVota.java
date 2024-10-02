package GUI.Frame_Urna;

import javax.swing.*;

public class TelaVota {
    public static void chama_urna() {
        SwingUtilities.invokeLater(() -> {
            new UrnaFrame().setVisible(true);
        });
    }
}
