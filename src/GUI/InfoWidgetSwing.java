package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoWidgetSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Widget de Informações");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Campo de texto para entrada de informações
        JTextField textField = new JTextField(20);
        
        // Botão para atualizar as informações
        JButton button = new JButton("Atualizar");
        
        // Label para exibir as informações
        JLabel label = new JLabel("Informações: ");
        
        // Adiciona um ActionListener ao botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                label.setText("Informações: " + input);
            }
        });
        
        // Cria um painel e adiciona os componentes
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);
        panel.add(label);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

