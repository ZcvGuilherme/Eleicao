package GUI.Eleicao;
import DATABASE.entidade.Candidato;
import DATABASE.entidade.Eleicao;

import java.util.List;
import CONNECTION.Cliente.Cliente;
import java.io.IOException;
public class SeparadorCargo {
    public static List<Candidato> SeparaPresidente() throws IOException, ClassNotFoundException{
        Eleicao eleicao = new Cliente().receberLista();
        List<Candidato> presidentes = Separador.filtro(eleicao.getCandidatos(), "Presidente");
        return presidentes;
    }
}
