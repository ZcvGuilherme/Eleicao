package entidade;

public class Candidato {
    private String nome;
    private int numero;
    private String cargo;
    private String partido;
    private int votos = 0;

    //NOME DO CANDIDATO
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome =  nome;
    }


    //NUMERO DO CANDIDATO
    public int getNum(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero =  numero;
    }


    //Cargo DO CANDIDATO
    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo =  cargo;
    }


    //Partido DO CANDIDATO
    public String getPartido(){
        return partido;
    }
    public void setPartido(String partido){
        this.partido =  partido;
    }

    
    //NOME DO CANDIDATO
    public int getvotos(){
        return votos;
    }
    public void AddVoto(){
        this.votos =  votos + 1;
    }
}
