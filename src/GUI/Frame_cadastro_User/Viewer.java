package GUI.Frame_cadastro_User;
import javax.swing.*;
public class Viewer {
    private JFrame frame;
    private JTextField txtID;
    private JButton botaoConfirmar;

    private JLabel labelID;

    public Viewer() {
        frame = new JFrame("Tela Inicial");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50, 100);
        frame.setResizable(false);

        labelID = new JLabel(" ");

        JPanel panel = new JPanel();
        panel.setLayout(null);

        txtID = new JTextField(20);
        botaoConfirmar = new JButton("Confirmar");
        JLabel labelIDLegenda = new JLabel("Id: ");

        labelIDLegenda.setBounds(50, 100, 100, 25);
        labelID.setBounds(50, 230, 400, 25);
        txtID.setBounds(150, 100, 200, 25);
        botaoConfirmar.setBounds(150, 250, 100, 25);



        panel.add(labelIDLegenda);
        panel.add(txtID);
        panel.add(botaoConfirmar);
        panel.add(labelID);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
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
}
