package Terminal.modelo;

import java.util.ArrayList;

public class Partido {
    private String nome;
    private int qtdSenadores;
    private int qtdDeputadosFederais;
    private int qtdDeputadosEstaduais;
    private boolean temPresidente;
    private boolean temGovernador;
    private ArrayList<Candidato> candidatos;

    public Partido(String nome, int qtdSenadores, int qtdDeputadosFederais, int qtdDeputadosEstaduais) {
        this.nome = nome;
        this.qtdSenadores = qtdSenadores;
        this.qtdDeputadosFederais = qtdDeputadosFederais;
        this.qtdDeputadosEstaduais = qtdDeputadosEstaduais;
        this.temPresidente = false;
        this.temGovernador = false;
        this.candidatos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean adicionarCandidato(Candidato candidato) {
        String cargo = candidato.getCargo();

        if (cargo.equals("Presidente") && temPresidente) {
            System.out.println("Já existe um candidato a Presidente para o partido " + nome);
            return false;
        }
        if (cargo.equals("Governador") && temGovernador) {
            System.out.println("Já existe um candidato a Governador para o partido " + nome);
            return false;
        }
        if (cargo.equals("Senador") && qtdSenadores == 0) {
            System.out.println("Já atingiu o limite de Senadores para o partido " + nome);
            return false;
        }
        if (cargo.equals("Deputado Federal") && qtdDeputadosFederais == 0) {
            System.out.println("Já atingiu o limite de Deputados Federais para o partido " + nome);
            return false;
        }
        if (cargo.equals("Deputado Estadual") && qtdDeputadosEstaduais == 0) {
            System.out.println("Já atingiu o limite de Deputados Estaduais para o partido " + nome);
            return false;
        }

        candidatos.add(candidato);

        switch (cargo) {
            case "Presidente":
                temPresidente = true;
                break;
            case "Governador":
                temGovernador = true;
                break;
            case "Senador":
                qtdSenadores--;
                break;
            case "Deputado Federal":
                qtdDeputadosFederais--;
                break;
            case "Deputado Estadual":
                qtdDeputadosEstaduais--;
                break;
        }
        return true;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }
}
