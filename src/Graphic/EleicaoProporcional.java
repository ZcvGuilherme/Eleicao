package Graphic;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Candidato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EleicaoProporcional {

    private List<Candidato> partidos;
    private int totalCadeiras;  // Número de cadeiras a serem distribuídas
    private UserDAO userDAO;     // Acesso ao banco de dados
    private Map<Candidato, Integer> distribuicaoCadeiras; // Mapa para armazenar a distribuição de cadeiras

    public EleicaoProporcional(int totalCadeiras) {
        this.totalCadeiras = totalCadeiras;
        this.userDAO = new UserDAO();
        this.partidos = userDAO.retornoTodosCandidatos(); // Recupera todos os candidatos ou partidos
        this.distribuicaoCadeiras = new HashMap<>(); // Inicializa o mapa
    }

    // Método para distribuir cadeiras utilizando o método de Hondt
    // Se ainda restarem cadeiras após a distribuição inicial, elas podem ser atribuídas utilizando o método de Hondt
    // O método é responsável pela distribuição das sobras com base em uma sequência de divisões dos votos do partido 
    // (votos do partido / número de cadeiras já conquistadas + 1).
    public void calcularDistribuicaoCadeiras() {
        List<CadeiraPartido> distribuicaoQuocientes = new ArrayList<>();

        // Gera a lista de quocientes de cada partido com divisores crescentes
        for (Candidato partido : partidos) {
            for (int divisor = 1; divisor <= totalCadeiras; divisor++) {
                double quociente = (double) partido.getvotos() / divisor;
                distribuicaoQuocientes.add(new CadeiraPartido(partido, quociente));
            }
            distribuicaoCadeiras.put(partido, 0); // Inicializa a contagem de cadeiras para cada partido
        }

        // Ordena os quocientes em ordem decrescente para distribuir as cadeiras
        Collections.sort(distribuicaoQuocientes, Comparator.comparingDouble(CadeiraPartido::getQuociente).reversed());

        // Distribui as cadeiras entre os partidos/candidatos com os maiores quocientes
        for (int i = 0; i < totalCadeiras; i++) {
            CadeiraPartido cadeiraPartido = distribuicaoQuocientes.get(i);
            Candidato partido = cadeiraPartido.getPartido();
            distribuicaoCadeiras.put(partido, distribuicaoCadeiras.get(partido) + 1); // Incrementa o número de cadeiras do partido
        }

        // Imprime a distribuição final das cadeiras
        for (Candidato partido : partidos) {
            int cadeirasRecebidas = distribuicaoCadeiras.get(partido);
            System.out.println(partido.getPartido() + " recebeu " + cadeirasRecebidas + " cadeiras.");
        }
    }

    // Classe auxiliar para armazenar o quociente e o partido correspondente
    private static class CadeiraPartido {
        private Candidato partido;
        private double quociente;

        public CadeiraPartido(Candidato partido, double quociente) {
            this.partido = partido;
            this.quociente = quociente;
        }

        public Candidato getPartido() {
            return partido;
        }

        public double getQuociente() {
            return quociente;
        }
    }

    public static void main(String[] args) {
        // Exemplo: distribui 10 cadeiras para os partidos
        EleicaoProporcional eleicao = new EleicaoProporcional(10);
        eleicao.calcularDistribuicaoCadeiras();
    }
}
