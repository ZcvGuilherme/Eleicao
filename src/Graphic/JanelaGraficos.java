package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import DATABASE.entidade.Candidato; // Certifique-se de que a classe Candidato está importada corretamente

public class JanelaGraficos extends JFrame implements ActionListener {

    private JPanel cardPanel; // Painel que contém os gráficos
    private CardLayout cardLayout; // Layout que permite alternar entre diferentes componentes (gráficos)

    public JanelaGraficos() {
        setTitle("Resultados das Eleições"); // Define o título da janela
        setSize(800, 600); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        setLayout(new BorderLayout()); // Define o layout principal da janela

        cardPanel = new JPanel(); // Inicializa o painel que conterá os gráficos
        cardLayout = new CardLayout(); // Inicializa o layout de cartão para alternar entre os gráficos
        cardPanel.setLayout(cardLayout); // Define o layout do painel

        // Inicializa candidatos
        List<Candidato> candidatos = criarCandidatos(); // Método para criar a lista de candidatos

        // Adicionando gráficos proporcionais
        cardPanel.add(new GraficoMajoritario(true), "Presidente"); // Gráfico para Presidente
        cardPanel.add(new GraficoMajoritario(false), "Governador"); // Gráfico para Governador
        cardPanel.add(new GraficoProporcional("Senador", candidatos), "Senador"); // Gráfico para Senador
        cardPanel.add(new GraficoProporcional("Deputado Federal", candidatos), "Deputado Federal"); // Gráfico para Deputado Federal
        cardPanel.add(new GraficoProporcional("Deputado Estadual", candidatos), "Deputado Estadual"); // Gráfico para Deputado Estadual

        // Painel de botões para alternar entre os gráficos
        JPanel buttonPanel = new JPanel(); // Cria um painel para os botões
        String[] buttonLabels = {"Presidente", "Governador", "Senador", "Deputado Federal", "Deputado Estadual"}; // Rótulos dos botões
        for (String label : buttonLabels) { // Cria botões para cada rótulo
            JButton button = new JButton(label); // Cria um novo botão com o rótulo
            button.addActionListener(this); // Adiciona um ouvinte de ação ao botão
            buttonPanel.add(button); // Adiciona o botão ao painel de botões
        }

        // Adiciona os componentes ao layout principal
        add(buttonPanel, BorderLayout.NORTH); // Adiciona o painel de botões ao topo da janela
        add(cardPanel, BorderLayout.CENTER); // Adiciona o painel de gráficos ao centro da janela
    }

    private List<Candidato> criarCandidatos() {
        List<Candidato> candidatos = new ArrayList<>(); // Cria uma lista para armazenar os candidatos
        // Adicione a lógica para criar candidatos e adicioná-los à lista
        // Exemplo: candidatos.add(new Candidato(...));
        return candidatos; // Retorna a lista de candidatos
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtém o comando (rótulo) do botão pressionado
        cardLayout.show(cardPanel, command); // Mostra o gráfico correspondente ao botão pressionado
    }

    public static void main(String[] args) {
        JanelaGraficos janela = new JanelaGraficos(); // Cria uma nova instância da janela de gráficos
        janela.setVisible(true); // Exibe a janela
    }
}
