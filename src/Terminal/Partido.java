package Terminal;

import java.util.ArrayList;
import java.util.List;

public class Partido {
    private String nome;
    private List<Candidato> candidatos;
    private static final int MAX_PRESIDENTE = 1;
    private static final int MAX_GOVERNADOR = 1;
    private int maxSenadores;
    private int maxDepFederais;
    private int maxDepEstaduais;

    public Partido(String nome, int maxSenadores, int maxDepFederais, int maxDepEstaduais) {
        this.nome = nome;
        this.candidatos = new ArrayList<>();
        this.maxSenadores = maxSenadores;
        this.maxDepFederais = maxDepFederais;
        this.maxDepEstaduais = maxDepEstaduais;
    }

    public boolean adicionarCandidato(Candidato candidato) {
        switch (candidato.getCargo().toLowerCase()) {
            case "presidente":
                if (quantidadePorCargo("presidente") < MAX_PRESIDENTE) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "governador":
                if (quantidadePorCargo("governador") < MAX_GOVERNADOR) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "senador":
                if (quantidadePorCargo("senador") < maxSenadores) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "deputado federal":
                if (quantidadePorCargo("deputado federal") < maxDepFederais) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "deputado estadual":
                if (quantidadePorCargo("deputado estadual") < maxDepEstaduais) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
        }
        return false;
    }

    private int quantidadePorCargo(String cargo) {
        int count = 0;
        for (Candidato candidato : candidatos) {
            if (candidato.getCargo().equalsIgnoreCase(cargo)) {
                count++;
            }
        }
        return count;
    }
}