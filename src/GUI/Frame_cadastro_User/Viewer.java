package GUI.Frame_cadastro_User;
import java.awt.Font;
import javax.swing.*;
public class Viewer {
    private JFrame frame;
    private JTextField txtID;
    private JButton botaoConfirmar;
    private JLabel labelID;
    private JLabel indicacao;
    public Viewer() {
        frame = new JFrame("Tela Inicial");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(550, 200);
        frame.setResizable(false);

        labelID = new JLabel(" ");
        indicacao = new JLabel("DIGITE SEU ID");
        indicacao.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel panel = new JPanel();
        panel.setLayout(null);

        txtID = new JTextField(20);
        new Placeholder(txtID, "Ex:. 001");
        
        botaoConfirmar = new JButton("Confirmar");


        indicacao.setBounds(75, 10, 200, 25);
        labelID.setBounds(50, 230, 400, 25);
        txtID.setBounds(100, 50, 80, 25);
        botaoConfirmar.setBounds(90, 90, 100, 25);


        panel.add(indicacao);
        panel.add(txtID);
        panel.add(botaoConfirmar);
        panel.add(labelID);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        SwingUtilities.invokeLater(() -> {
            // Muda o foco para o painel ou outro componente
            panel.requestFocusInWindow(); 
        });
    }
    
    public JTextField getTxtID(){
            return txtID;
    }
    public JButton getBotaoConfirmar(){
        return botaoConfirmar;
    }

    public JLabel getLabelID(){
        return labelID;
    }
    public JFrame getFrame() {
        return frame;
    }
}
