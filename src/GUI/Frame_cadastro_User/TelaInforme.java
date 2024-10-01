package GUI.Frame_cadastro_User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaInforme {
        public static void main(String[] args) {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setSize(100, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50, 100);

        /* Campo de texto para entrada de informações */
        // Nome
        JTextField txtNome = new JTextField(20);
        // CPF
        JTextField txtCPF = new JTextField(20);

        /* Botão para informações */
        JButton botaoConfirmar = new JButton("Confirmar");

        /* Label para exibir as informações */
        // Nome
        JLabel labelNome = new JLabel(" ");
        JLabel labelNomeLegenda = new JLabel("Nome: ");
        // CPF
        JLabel labelCPF = new JLabel(" ");
        JLabel labelCPFLegenda = new JLabel("CPF: ");

        /* Adiciona um ActionListener ao botão */
        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputnome = txtNome.getText();
                labelNome.setText("Nome: " + inputnome);
                String inputcpf = txtCPF.getText();
                labelCPF.setText("Nome: " + inputcpf);

            }
        });

        // Cria um painel, adiciona os componentes e define layout nulo
        JPanel panel = new JPanel();
        // Posição
        txtNome.setBounds(600, 150, 200, 30);
        txtCPF.setBounds(600, 200, 200, 30);
        botaoConfirmar.setBounds(720, 250, 100, 30);
        labelNome.setBounds(600, 350, 350, 30);
        labelCPF.setBounds(600, 400, 400, 30);
        labelNomeLegenda.setBounds(500, 150, 200, 30);
        labelCPFLegenda.setBounds(500, 200, 200, 30);
        // Adicionar os botões
        panel.setLayout(null);
        panel.add(txtNome);
        panel.add(txtCPF);
        panel.add(botaoConfirmar);
        panel.add(labelNome);
        panel.add(labelCPF);
        panel.add(labelNomeLegenda);
        panel.add(labelCPFLegenda);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

}