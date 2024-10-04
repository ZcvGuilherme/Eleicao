package GUI.Frame_Urna.configs;

import javax.swing.text.AttributeSet;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class NumericDocumentFilter extends DocumentFilter {
    private final JLabel errorLabel;

    public NumericDocumentFilter(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null && isNumeric(string)) {
            if (errorLabel != null) {
                errorLabel.setText(""); // Limpa a mensagem de erro
            }
            super.insertString(fb, offset, string, attr);
        } else {
            showErrorMessage();
        }
    }
    
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null && isNumeric(text)) {
            if (errorLabel != null) {
                errorLabel.setText(""); // Limpa a mensagem de erro
            }
            super.replace(fb, offset, length, text, attrs);
        } else {
            showErrorMessage();
        }
    }
    

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
        if (errorLabel != null) {
            errorLabel.setText(""); // Limpa a mensagem de erro ao remover
        }
    }

    public boolean isNumeric(String str) {
        return str.matches("[0-9]*"); // Verifica se a string contém apenas números
    }

    private void showErrorMessage() {
        if (errorLabel != null) {
            errorLabel.setText("Apenas números são permitidos");
            errorLabel.setForeground(Color.RED);
        }
    }
}
