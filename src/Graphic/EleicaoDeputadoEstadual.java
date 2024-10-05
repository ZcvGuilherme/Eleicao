package Graphic;

import DATABASE.entidade.Candidato;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class EleicaoDeputadoEstadual {

    private static final int TOTAL_CADEIRAS = 6; // Número padrão de cadeiras
    private Map<String, Integer> votosPartidos; // Mapa para armazenar votos por partido
    private List<Candidato> candidatos; // Lista de candidatos

    // Construtor que recebe a lista de candidatos
    public EleicaoDeputadoEstadual(List<Candidato> candidatos) {
        this.candidatos = candidatos; // Armazena a lista de candidatos
        this.votosPartidos = new HashMap<>(); // Inicializa o mapa de votos
        calcularVotosPorPartido(); // Chama o método para calcular os votos por partido
    }

    // Método para calcular a quantidade de votos por partido
    private void calcularVotosPorPartido() {
        // Contar votos por partido
        for (Candidato candidato : candidatos) {
            String partido = candidato.getPartido(); // Obtém o partido do candidato
            // Incrementa o voto para o partido correspondente
            votosPartidos.put(partido, votosPartidos.getOrDefault(partido, 0) + candidato.getvotos());
        }
    }

    // Método para calcular a distribuição das cadeiras entre os partidos
    public void calcularDistribuicaoCadeiras() {
        int[] cadeirasPartidos = new int[votosPartidos.size()]; // Array para armazenar a quantidade de cadeiras por partido
        double[] quocientes = new double[votosPartidos.size()]; // Array para armazenar os quocientes
        String[] partidosArray = votosPartidos.keySet().toArray(new String[0]); // Converte as chaves do mapa em um array

        // Loop para distribuir as cadeiras
        for (int i = 0; i < TOTAL_CADEIRAS; i++) {
            // Calcula os quocientes para cada partido
            for (int j = 0; j < votosPartidos.size(); j++) {
                quocientes[j] = (double) votosPartidos.get(partidosArray[j]) / (cadeirasPartidos[j] + 1);
            }

            // Encontra o partido com o maior quociente e incrementa a quantidade de cadeiras
            int partidoMaiorQuociente = getPartidoMaiorQuociente(quocientes);
            cadeirasPartidos[partidoMaiorQuociente]++;
        }

        // Imprimir resultados
        for (int i = 0; i < votosPartidos.size(); i++) {
            System.out.println("Partido " + partidosArray[i] + " recebeu " + cadeirasPartidos[i] + " cadeiras."); // Mostra a distribuição de cadeiras
        }
    }

    // Método para encontrar o índice do partido com o maior quociente
    private int getPartidoMaiorQuociente(double[] quocientes) {
        int index = 0; // Inicializa o índice
        double maior = quocientes[0]; // Assume que o primeiro é o maior
        for (int i = 1; i < quocientes.length; i++) {
            // Se encontrar um quociente maior, atualiza o índice e o valor maior
            if (quocientes[i] > maior) {
                maior = quocientes[i];
                index = i;
            }
        }
        return index; // Retorna o índice do maior quociente
    }

    public static void main(String[] args) {
        // Gera uma lista de candidatos e cria uma instância da eleição para deputados estaduais
        List<Candidato> candidatos = GeradorEleicao.gerarEleicao().getCandidatos();
        if (candidatos != null && !candidatos.isEmpty()) { // Verifica se há candidatos disponíveis
            EleicaoDeputadoEstadual eleicao = new EleicaoDeputadoEstadual(candidatos); // Sem passar o número de cadeiras
            eleicao.calcularDistribuicaoCadeiras(); // Calcula a distribuição das cadeiras
        } else {
            System.out.println("Nenhum candidato disponível."); // Mensagem caso não haja candidatos
        }
    }
}
