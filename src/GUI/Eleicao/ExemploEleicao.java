package GUI.Eleicao;

import DATABASE.entidade.Candidato;
import GUI.Frame_Urna.configs.Cargo;

import java.util.ArrayList;
import java.util.List;

public class ExemploEleicao {

    public static void main(String[] args) {
        // Gerar candidatos para exemplo
        List<Candidato> candidatos = gerarCandidatosDeExemplo();

        // Separar os candidatos por cargo e atribuir ao enum Cargo
        Cargo.PRESIDENTE.setListaCandidatos(Separador.filtro(candidatos, "Presidente"));
        Cargo.GOVERNADOR.setListaCandidatos(Separador.filtro(candidatos, "Governador"));
        Cargo.SENADOR.setListaCandidatos(Separador.filtro(candidatos, "Senador"));
        Cargo.DEPUTADO_FEDERAL.setListaCandidatos(Separador.filtro(candidatos, "Deputado Federal"));
        Cargo.DEPUTADO_ESTADUAL.setListaCandidatos(Separador.filtro(candidatos, "Deputado Estadual"));

        // Testar a impressão dos candidatos de um cargo específico
        System.out.println("Candidatos a Presidente:");
        for (Candidato c : Cargo.PRESIDENTE.getListaCandidatos()) {
            System.out.println(c);
        }

        System.out.println("\nCandidatos a Governador:");
        for (Candidato c : Cargo.GOVERNADOR.getListaCandidatos()) {
            System.out.println(c);
        }

        // Continue para outros cargos, se necessário...
    }

    private static List<Candidato> gerarCandidatosDeExemplo() {
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
