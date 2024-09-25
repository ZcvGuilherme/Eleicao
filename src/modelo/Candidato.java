package modelo;

public class Candidato {
    private String nome;
    private Partido partido;
    private int numero;
    private String cargo;

    public Candidato(String nome, Partido partido, int numero, String cargo) {
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public Partido getPartido() {
        return partido;
    }

    public int getNumero() {
        return numero;
    }

    public String getCargo() {
        return cargo;
    }
}
