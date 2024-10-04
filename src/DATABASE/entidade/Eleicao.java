package DATABASE.entidade;

import java.io.Serializable;
import java.util.List;

public class Eleicao implements Serializable{
    private List<Candidato> candidatos;
    private int ID;
    private int tempo;
    private int presidenteVotoNull;
    private int governadorVotoNull;
    private int senadorVotoNull;
    private int deputadoFVotoNull;
    private int deputadoEVotoNull;
    private int votoBranco;

    // Construtor completo
    public Eleicao(List<Candidato> candidatos, int ID, int tempo, int presidenteVotoNull, int governadorVotoNull, int senadorVotoNull, int deputadoFVotoNull, int deputadoEVotoNull, int votoBranco) {
        this.candidatos = candidatos;
        this.ID = ID;
        this.tempo = tempo;
        this.presidenteVotoNull = presidenteVotoNull;
        this.governadorVotoNull = governadorVotoNull;
        this.senadorVotoNull = senadorVotoNull;
        this.deputadoFVotoNull = deputadoFVotoNull;
        this.deputadoEVotoNull = deputadoEVotoNull;
        this.votoBranco = votoBranco;
    }

    // Getters e Setters
    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getPresidenteVotoNull() {
        return presidenteVotoNull;
    }

    public void addPresidenteVotoNull() {
        this.presidenteVotoNull += 1;
    }

    public int getGovernadorVotoNull() {
        return governadorVotoNull;
    }

    public void addGovernadorVotoNull() {
        this.governadorVotoNull += 1;
    }

    public int getSenadorVotoNull() {
        return senadorVotoNull;
    }

    public void addSenadorVotoNull() {
        this.senadorVotoNull += 1;
    }

    public int getDeputadoFVotoNull() {
        return deputadoFVotoNull;
    }

    public void addDeputadoFVotoNull() {
        this.deputadoFVotoNull += 1;
    }

    public int getDeputadoEVotoNull() {
        return deputadoEVotoNull;
    }

    public void addDeputadoEVotoNull() {
        this.deputadoEVotoNull += 1 ;
    }

    public int getVotoBranco() {
        return votoBranco;
    }

    public void addVotoBranco() {
        this.votoBranco += 1;
    }

    @Override
    public String toString() {
        return "Eleicao{" +
               "candidatos=" + candidatos +
               ", ID=" + ID +
               ", tempo=" + tempo +
               ", presidenteVotoNull=" + presidenteVotoNull +
               ", governadorVotoNull=" + governadorVotoNull +
               ", senadorVotoNull=" + senadorVotoNull +
               ", deputadoFVotoNull=" + deputadoFVotoNull +
               ", deputadoEVotoNull=" + deputadoEVotoNull +
               ", votoBranco=" + votoBranco +
               '}';
    }
}
