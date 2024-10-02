package GUI.Eleicao;

import DATABASE.entidade.Candidato;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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
    public static void printEleicao(){
        List<Candidato> candidatos = Arrays.asList(
            new Candidato("João", 1, "Prefeito", "Partido A"),
            new Candidato("Maria", 2, "Vereador", "Partido B"),
            new Candidato("Pedro", 3, "Prefeito", "Partido C"),
            new Candidato("Ana", 4, "Vereador", "Partido D")
        );
        List<Candidato> prefeito = Separador.filtro(candidatos, "Prefeito");

        System.out.println("Candidatos ao cargo de Prefeito:");
        for (Candidato c : prefeito) {
            System.out.println("Número: " + c.getNum());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Partido: " + c.getPartido());
            System.out.println("-----------------------------");
        }
    }
}
