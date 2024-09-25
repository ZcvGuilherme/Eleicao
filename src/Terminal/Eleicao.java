package Terminal;

public class Eleicao {
    private String id;
    private int duracao;
    private int numEleitores;

    public Eleicao(String id, int duracao, int numEleitores) {
        this.id = id;
        this.duracao = duracao;
        this.numEleitores = numEleitores;
    }

    @Override
    public String toString() {
        return "Eleição{" +
                "id='" + id + '\'' +
                ", duracao=" + duracao +
                ", numEleitores=" + numEleitores +
                '}';
    }
}
