package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInforme {
        public static void main(String[] args) {
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        /* Campo de texto para entrada de informações */
        // Nome
        JTextField txtNome = new JTextField(20);
        // CPF
        JTextField txtCPF = new JTextField(20);

        /* Botão para informações */
        JButton botaoAtualizar = new JButton("Atualizar");
        JButton botaoConfirmar = new JButton("Confirmar");

        /* Label para exibir as informações */
        // Nome
        JLabel labelNome = new JLabel(" ");
        // CPF
        JLabel labelCPF = new JLabel(" ");

        /* Adiciona um ActionListener ao botão */
        botaoAtualizar.addActionListener(new ActionListener() {
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
        txtNome.setBounds(50, 50, 200, 30);
        txtCPF.setBounds(50, 100, 200, 30);
        botaoAtualizar.setBounds(50, 150, 100, 30);
        botaoConfirmar.setBounds(160, 150, 100, 30);
        labelNome.setBounds(50, 200, 300, 30);
        labelCPF.setBounds(50, 250, 300, 30);
        // Adicionar os botões
        panel.setLayout(null);
        panel.add(txtNome);
        panel.add(txtCPF);
        panel.add(botaoAtualizar);
        panel.add(botaoConfirmar);
        panel.add(labelNome);
        panel.add(labelCPF);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

}