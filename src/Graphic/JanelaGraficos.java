package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaGraficos extends JFrame implements ActionListener {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    public JanelaGraficos() {
        setTitle("Resultados das Eleições");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cria o painel com CardLayout para os gráficos
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Adiciona os painéis dos gráficos
        cardPanel.add(new GraficoMajoritario(true), "Presidente"); 
        cardPanel.add(new GraficoMajoritario(false), "Governador"); 
        cardPanel.add(new GraficoProporcional("Senador"), "Senador");
        cardPanel.add(new GraficoProporcional("Deputado Federal"), "Deputado Federal");
        cardPanel.add(new GraficoProporcional("Deputado Estadual"), "Deputado Estadual");

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        String[] buttonLabels = {"Presidente", "Governador", "Senador", "Deputado Federal", "Deputado Estadual"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        // Adiciona os componentes à janela
        add(buttonPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Troca o cartão ativo com base no botão clicado
        String command = e.getActionCommand();
        cardLayout.show(cardPanel, command);
    }

    public static void main(String[] args) {
        JanelaGraficos janela = new JanelaGraficos();
        janela.setVisible(true);
    }
}