package GUI.Eleicao;
import DATABASE.entidade.Candidato;
import DATABASE.entidade.Eleicao;

import java.util.List;
import CONNECTION.Cliente.Cliente;

public class SeparadorCargo {
    
    public static List<Candidato> SeparaPresidente(Cliente cliente) {
        Eleicao eleicao = cliente.receberLista();
        List<Candidato> presidentes = Separador.filtro(eleicao.getCandidatos(), "Presidente");
        return presidentes;
    }
    public static List<Candidato> SeparaGovernador(Cliente cliente) {
        Eleicao eleicao = cliente.receberLista();
        List<Candidato> governador = Separador.filtro(eleicao.getCandidatos(), "Governador");
        return governador;
    }
    public static List<Candidato> SeparaSenador(Cliente cliente) {
        Eleicao eleicao = cliente.receberLista();
        List<Candidato> senador = Separador.filtro(eleicao.getCandidatos(), "Senador");
        return senador;
    }
    public static List<Candidato> SeparaDeputadoF(Cliente cliente) {
        Eleicao eleicao = cliente.receberLista();
        List<Candidato> dep = Separador.filtro(eleicao.getCandidatos(), "Deputado Federal");
        return dep;
    }
    public static List<Candidato> SeparaDeputadoE(Cliente cliente) {
        Eleicao eleicao = cliente.receberLista();
        List<Candidato> dep = Separador.filtro(eleicao.getCandidatos(), "Deputado Estadual");
        return dep;
    }
}
