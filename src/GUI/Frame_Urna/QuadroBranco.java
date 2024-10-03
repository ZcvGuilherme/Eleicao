package GUI.Frame_Urna;

import GUI.NumericDocumentFilter;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import java.awt.*;

public class QuadroBranco {

    public static JTextField adicionarAoPanel(JPanel panel, int x, int y, int largura, int altura) {
        // Cria o painel branco
        JPanel quadroBranco = new JPanel();
        quadroBranco.setBackground(Color.WHITE);
        quadroBranco.setBounds(x, y, largura, altura);
        quadroBranco.setLayout(null); // Usar layout nulo para posicionamento manual

        // Cria e adiciona os componentes (texto e campo de texto)
        JLabel textoLabelCargo = CriadorComponentes.criarLabel("Cargo", 250, 30, 400, 80);
        JLabel textoLabelNome = CriadorComponentes.criarLabel("Nome:", 50, 300, 400, 80);
        JLabel textoLabelPartido = CriadorComponentes.criarLabel("Partido:", 50, 400, 400, 80);
        JLabel textoLabelNumero = CriadorComponentes.criarLabel("Numero:", 50, 150, 400, 80);
        JTextField campoTexto = CriadorComponentes.criarTextField(280, 170, 200, 50);

        quadroBranco.add(textoLabelCargo);
        quadroBranco.add(textoLabelNome);
        quadroBranco.add(textoLabelPartido);
        quadroBranco.add(textoLabelNumero);
        quadroBranco.add(campoTexto);   

        // Adiciona o quadro branco ao painel principal
        panel.add(quadroBranco);

        return campoTexto;
    }
}
