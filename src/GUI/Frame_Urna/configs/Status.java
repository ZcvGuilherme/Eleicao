package GUI.Frame_Urna.configs;
import javax.swing.text.AttributeSet;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;

public class Status {

    public static void configurarTela(Cargo cargo, JLabel textoCargo, JTextField campoTexto, JLabel errorLabel) {
    // Atualiza o texto do cargo
    textoCargo.setText(cargo.getNome());

    // Limita o número de dígitos no campo de texto
    ((AbstractDocument) campoTexto.getDocument()).setDocumentFilter(new NumericDocumentFilter(errorLabel) {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string != null && isNumeric(string) && campoTexto.getText().length() < cargo.getMaxDigitos()) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text != null && isNumeric(text) && campoTexto.getText().length() - length + text.length() <= cargo.getMaxDigitos()) {
                super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}
