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
}
