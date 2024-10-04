package GUI.Frame_cadastro_User.Configs;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;

public class Placeholder {
    private JTextField textField;
    private String placeholder;

    public Placeholder(JTextField textField, String placeholder) {
        this.textField = textField;
        this.placeholder = placeholder;
        
        // Configura o texto de placeholder
        setPlaceholder();
    }

    private void setPlaceholder() {
        // Define o texto de placeholder
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY); // Define a cor do texto como cinza

        // Adiciona um foco para limpar o placeholder quando o campo recebe foco
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK); // Muda a cor do texto para preto
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY); // Restaura a cor do texto
                    textField.setText(placeholder);
                }
            }
        });
    }
}
