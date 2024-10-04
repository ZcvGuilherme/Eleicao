package GUI.Eleicao;
import DATABASE.entidade.Candidato;
import DATABASE.entidade.Eleicao;

import java.util.List;
import CONNECTION.Cliente.Cliente;

public class SeparadorCargo {
    public static List<Candidato> SeparaPresidente() {
        Eleicao eleicao = new Cliente().receberLista();
        List<Candidato> presidentes = Separador.filtro(eleicao.getCandidatos(), "Presidente");
        return presidentes;
    }
    public static List<Candidato> SeparaGovernador() {
        Eleicao eleicao = new Cliente().receberLista();
        List<Candidato> governador = Separador.filtro(eleicao.getCandidatos(), "Governador");
        return governador;
    }
    public static List<Candidato> SeparaSenador() {
        Eleicao eleicao = new Cliente().receberLista();
        List<Candidato> senador = Separador.filtro(eleicao.getCandidatos(), "Senador");
        return senador;
    }
    public static List<Candidato> SeparaDeputadoF() {
        Eleicao eleicao = new Cliente().receberLista();
        List<Candidato> dep = Separador.filtro(eleicao.getCandidatos(), "Deputado Federal");
        return dep;
    }
    public static List<Candidato> SeparaDeputadoE() {
        Eleicao eleicao = new Cliente().receberLista();
        List<Candidato> dep = Separador.filtro(eleicao.getCandidatos(), "Deputado Estadual");
        return dep;
    }
}
