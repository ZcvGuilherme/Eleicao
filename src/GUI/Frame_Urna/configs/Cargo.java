package GUI.Frame_Urna.configs;

import CONNECTION.Cliente.Cliente;
import DATABASE.entidade.Candidato;
import java.util.List;

import GUI.Eleicao.SeparadorCargo;
public enum Cargo {
    PRESIDENTE("Presidente", 2),
    GOVERNADOR("Governador", 3), 
    SENADOR("Senador", 4), 
    DEPUTADO_FEDERAL("Deputado Federal", 5), 
    DEPUTADO_ESTADUAL("Deputado Estadual", 5);

    private final String nome;
    private final int maxDigitos;
    private List<Candidato> listaCandidatos;


    Cargo(String nome, int maxDigitos) {
        this.nome = nome;
        this.maxDigitos = maxDigitos;
    }
    public void carregarCandidatos(Cliente cliente) {
        switch (this) {
            case PRESIDENTE:
                listaCandidatos = SeparadorCargo.SeparaPresidente(cliente);
                break;
            case GOVERNADOR:
                listaCandidatos = SeparadorCargo.SeparaGovernador(cliente);
                break;
            case SENADOR:
                listaCandidatos = SeparadorCargo.SeparaSenador(cliente);
                break;
            case DEPUTADO_FEDERAL:
                listaCandidatos = SeparadorCargo.SeparaDeputadoF(cliente);
                break;
            case DEPUTADO_ESTADUAL:
                listaCandidatos = SeparadorCargo.SeparaDeputadoE(cliente);
                break;
        }
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
