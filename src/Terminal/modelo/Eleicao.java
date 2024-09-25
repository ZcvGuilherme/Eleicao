package Terminal.modelo;

import java.util.ArrayList;

public class Eleicao {
    private int id;
    private int duracao;
    private ArrayList<Partido> partidos;

    public Eleicao(int id, int duracao) {
        this.id = id;
        this.duracao = duracao;
        this.partidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getDuracao() {
        return duracao;
    }

    public void adicionarPartido(Partido partido) {
        partidos.add(partido);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
}
