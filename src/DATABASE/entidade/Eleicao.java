package DATABASE.entidade;


public class Eleicao {
    private int idEleicao;
    private int duracaoMinutos;

    // Construtor
    public Eleicao(int idEleicao, int duracaoMinutos) {
        this.idEleicao = idEleicao;
        this.duracaoMinutos = duracaoMinutos;
    }

    // Getters e Setters (opcionais)
    public int getIdEleicao() {
        return idEleicao;
    }

    public void setIdEleicao(int idEleicao) {
        this.idEleicao = idEleicao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    // Método para cadastrar eleição
    
}
