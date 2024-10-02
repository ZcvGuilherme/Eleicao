package GUI.Frame_Urna;

import javax.swing.*;
import java.awt.*;

public class QuadroBranco {

    public static void adicionarAoPanel(JPanel panel, int x, int y, int largura, int altura) {
        // Cria o painel branco
        JPanel quadroBranco = new JPanel();
        quadroBranco.setBackground(Color.WHITE);
        quadroBranco.setBounds(x, y, largura, altura);
        quadroBranco.setLayout(null); // Usar layout nulo para posicionamento manual

        // Cria e adiciona os componentes (texto e campo de texto)
        JLabel textoLabelCargo = CriadorComponentes.criarLabel("Cargo", 100, 30, 400, 80);
        JLabel textoLabelNome = CriadorComponentes.criarLabel("Nome:", 50, 300, 400, 80);
        JLabel textoLabelPartido = CriadorComponentes.criarLabel("Partido:", 50, 400, 400, 80);
        JTextField campoTexto = CriadorComponentes.criarTextField(100, 150, 200, 50);

        quadroBranco.add(textoLabelCargo);
        quadroBranco.add(textoLabelNome);
        quadroBranco.add(textoLabelPartido);
        quadroBranco.add(campoTexto);

        // Adiciona o quadro branco ao painel principal
        panel.add(quadroBranco);
    }
}
