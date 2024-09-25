package Terminal;

public class Candidato {
    private String nome;
    private String partido;
    private int numero;
    private String cargo;

    public Candidato(String nome, String partido, int numero, String cargo) {
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", partido='" + partido + '\'' +
                ", numero=" + numero +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
