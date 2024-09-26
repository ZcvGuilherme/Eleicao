package Terminal.cadastro;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    private String nome;
    private int limiteSenadores;
    private int limiteDeputadosFederais;
    private int limiteDeputadosEstaduais;
    private List<Candidato> candidatos;

    public Partido(String nome, int limiteSenadores, int limiteDeputadosFederais, int limiteDeputadosEstaduais) {
        this.nome = nome;
        this.limiteSenadores = limiteSenadores;
        this.limiteDeputadosFederais = limiteDeputadosFederais;
        this.limiteDeputadosEstaduais = limiteDeputadosEstaduais;
        this.candidatos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean adicionarCandidato(Candidato candidato) {
        switch (candidato.getCargo().toLowerCase()) {
            case "senador":
                if (getNumCandidatosPorCargo("senador") < limiteSenadores) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "deputado federal":
                if (getNumCandidatosPorCargo("deputado federal") < limiteDeputadosFederais) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "deputado estadual":
                if (getNumCandidatosPorCargo("deputado estadual") < limiteDeputadosEstaduais) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "governador":
                if (getNumCandidatosPorCargo("governador") == 0) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
            case "presidente":
                if (getNumCandidatosPorCargo("presidente") == 0) {
                    candidatos.add(candidato);
                    return true;
                }
                break;
        }
        return false; // Limite atingido ou cargo já ocupado
    }

    private int getNumCandidatosPorCargo(String cargo) {
        int count = 0;
        for (Candidato c : candidatos) {
            if (c.getCargo().equalsIgnoreCase(cargo)) {
                count++;
            }
        }
        return count;
    }
}
