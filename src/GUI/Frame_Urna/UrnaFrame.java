package GUI.Frame_Urna;

import javax.swing.*;

class UrnaFrame extends JFrame {
    public UrnaFrame() {
        setTitle("Urna");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(new UrnaPanel());

    }
}