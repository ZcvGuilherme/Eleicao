package GUI.Frame_Urna.configs;

import DATABASE.entidade.Candidato;
import java.util.List;

public enum Cargo {
    PRESIDENTE("Presidente", 2, null), 
    GOVERNADOR("Governador", 3, null), 
    SENADOR("Senador", 4, null), 
    DEPUTADO_FEDERAL("Deputado Federal", 5, null), 
    DEPUTADO_ESTADUAL("Deputado Estadual", 5, null);

    private final String nome;
    private final int maxDigitos;
    private List<Candidato> listaCandidatos;

    Cargo(String nome, int maxDigitos, List<Candidato> listaCandidatos) {
        this.nome = nome;
        this.maxDigitos = maxDigitos;
        this.listaCandidatos = listaCandidatos;
    }

    public String getNome() {
        return nome;
    }

    public int getMaxDigitos() {
        return maxDigitos;
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }
}
