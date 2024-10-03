package GUI.Frame_Urna;

import javax.swing.*;

public class TelaVota {
    
    public static void chama_urna() {
        JFrame frame = new JFrame("Urna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Criar e adicionar o quadro branco
        JTextField campoTexto = QuadroBranco.adicionarAoPanel(panel, 50, 50, 700, 600);

        // Criar e adicionar os botões
        BotaoCriar.adicionarBotoesNumericos(panel, campoTexto);
        BotaoCriar.adicionarBotoesFuncionais(panel, campoTexto);
        

        frame.setVisible(true);
    }
}
