package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import DATABASE.entidade.Candidato; // Certifique-se de que a classe Candidato está importada corretamente

public class JanelaGraficos extends JFrame implements ActionListener {

    private JPanel cardPanel; // Painel que conterá os diferentes gráficos
    private CardLayout cardLayout; // Layout que permite alternar entre os gráficos

    public JanelaGraficos() {
        setTitle("Resultados das Eleições"); // Define o título da janela
        setSize(800, 600); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento da janela
        setLayout(new BorderLayout()); // Define o layout da janela

        cardPanel = new JPanel(); // Inicializa o painel de cartões
        cardLayout = new CardLayout(); // Inicializa o CardLayout para o painel
        cardPanel.setLayout(cardLayout); // Define o layout do painel como CardLayout

        // Inicializa candidatos
        List<Candidato> candidatos = criarCandidatos(); // Método para criar a lista de candidatos

        // Adicionando gráficos proporcionais ao painel de cartões
        cardPanel.add(new GraficoMajoritario(true), "Presidente");  // Gráfico para eleição presidencial
        cardPanel.add(new GraficoMajoritario(false), "Governador"); // Gráfico para eleição de governador
        cardPanel.add(new GraficoProporcional("Senador", candidatos), "Senador"); // Gráfico para eleição de senador
        cardPanel.add(new GraficoProporcional("Deputado Federal", candidatos), "Deputado Federal"); // Gráfico para deputado federal
        cardPanel.add(new GraficoProporcional("Deputado Estadual", candidatos), "Deputado Estadual"); // Gráfico para deputado estadual

        // Painel de botões para alternar entre os gráficos
        JPanel buttonPanel = new JPanel(); // Cria um painel para os botões
        String[] buttonLabels = {"Presidente", "Governador", "Senador", "Deputado Federal", "Deputado Estadual"}; // Rótulos dos botões
        for (String label : buttonLabels) { // Para cada rótulo, cria um botão
            JButton button = new JButton(label); // Cria um novo botão
            button.addActionListener(this); // Adiciona um ActionListener ao botão
            buttonPanel.add(button); // Adiciona o botão ao painel de botões
        }

        // Adiciona os componentes ao layout principal
        add(buttonPanel, BorderLayout.NORTH); // Adiciona o painel de botões na parte superior
        add(cardPanel, BorderLayout.CENTER); // Adiciona o painel de cartões no centro
    }

    private List<Candidato> criarCandidatos() {
        List<Candidato> candidatos = new ArrayList<>(); // Inicializa a lista de candidatos

        // Adicionando candidatos fictícios para eleições proporcionais
        candidatos.add(new Candidato("Candidato Senador 1", 101, "Senador", "Partido A"));
        candidatos.add(new Candidato("Candidato Senador 2", 102, "Senador", "Partido B"));
        candidatos.add(new Candidato("Candidato Deputado Federal 1", 201, "Deputado Federal", "Partido C"));
        candidatos.add(new Candidato("Candidato Deputado Federal 2", 202, "Deputado Federal", "Partido D"));
        candidatos.add(new Candidato("Candidato Deputado Estadual 1", 301, "Deputado Estadual", "Partido E"));
        candidatos.add(new Candidato("Candidato Deputado Estadual 2", 302, "Deputado Estadual", "Partido F"));

        // Adicionando candidatos fictícios para eleições majoritárias
        candidatos.add(new Candidato("Candidato Presidente 1", 401, "Presidente", "Partido G"));
        candidatos.add(new Candidato("Candidato Presidente 2", 402, "Presidente", "Partido H"));
        candidatos.add(new Candidato("Candidato Governador 1", 501, "Governador", "Partido I"));
        candidatos.add(new Candidato("Candidato Governador 2", 502, "Governador", "Partido J"));

        return candidatos; // Retorna a lista de candidatos criada
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtém o comando do botão pressionado
        cardLayout.show(cardPanel, command); // Mostra o painel correspondente ao comando
    }

    public static void main(String[] args) {
        JanelaGraficos janela = new JanelaGraficos(); // Cria uma nova janela de gráficos
        janela.setVisible(true); // Torna a janela visível
    }
}
