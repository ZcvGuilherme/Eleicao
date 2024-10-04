package GUI.Eleicao;

import DATABASE.entidade.Candidato;
import java.util.ArrayList;
import java.util.List;


public class Separador {
    public static List<Candidato> filtro(List<Candidato> candidatos, String cargo) {
        List<Candidato> candidatoFiltrado = new ArrayList<>();

        for (Candidato candidato : candidatos){
            if (candidato.getCargo().equalsIgnoreCase(cargo)){
                candidatoFiltrado.add(candidato);
            }
        }
        return candidatoFiltrado;
    }

    
    public static void printEleicao(List<Candidato> candidatos){
        
        List<Candidato> presidente = Separador.filtro(candidatos, "Presidente");

        System.out.println("Candidatos ao cargo de Prefeito:");
        for (Candidato c : presidente) {
            System.out.println("Número: " + c.getNum());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Partido: " + c.getPartido());
            System.out.println("-----------------------------");
        }
    }

    public static List<Candidato> gerarCandidatosDeExemplo() {
        List<Candidato> candidatos = new ArrayList<>();

        // Candidatos a Presidente
        candidatos.add(new Candidato("Candidato A", 12, "Presidente", "Partido A"));
        candidatos.add(new Candidato("Candidato B", 34, "Presidente", "Partido B"));

        // Candidatos a Governador
        candidatos.add(new Candidato("Candidato C", 56, "Governador", "Partido C"));
        candidatos.add(new Candidato("Candidato D", 78, "Governador", "Partido D"));

        // Candidatos a Senador
        candidatos.add(new Candidato("Candidato E", 90, "Senador", "Partido E"));

        // Candidatos a Deputado Federal
        candidatos.add(new Candidato("Candidato F", 1234, "Deputado Federal", "Partido F"));

        // Candidatos a Deputado Estadual
        candidatos.add(new Candidato("Candidato G", 5678, "Deputado Estadual", "Partido G"));

        return candidatos;
    }
}
