package Graphic;

import DATABASE.entidade.Candidato;
import DATABASE.entidade.Eleicao;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorEleicao {

    public static Eleicao gerarEleicao() {
        List<Candidato> candidatos = new ArrayList<>();
        Random random = new Random();

        // Adiciona candidatos do PT
        candidatos.add(new Candidato("Carlos Silva", 17, "Presidente", "PT"));
        candidatos.add(new Candidato("Ana Souza", 138, "Governador", "PT"));
        candidatos.add(new Candidato("Joaquim Ferreira", 1234, "Senador", "PT"));
        candidatos.add(new Candidato("Mariana Oliveira", 1290, "Senador", "PT"));
        candidatos.add(new Candidato("Roberto Costa", 16004, "Deputado Federal", "PT"));
        candidatos.add(new Candidato("Cláudia Mendes", 16005, "Deputado Federal", "PT"));
        candidatos.add(new Candidato("Fernando Almeida", 16013, "Deputado Federal", "PT"));
        candidatos.add(new Candidato("Gustavo Martins", 22007, "Deputado Estadual", "PT"));
        candidatos.add(new Candidato("Larissa Pereira", 22015, "Deputado Estadual", "PT"));
        candidatos.add(new Candidato("Ricardo Santos", 22021, "Deputado Estadual", "PT"));

        // Adiciona candidatos do PSDB
        candidatos.add(new Candidato("Bruno Oliveira", 28, "Presidente", "PSDB"));
        candidatos.add(new Candidato("Tatiane Ramos", 215, "Governador", "PSDB"));
        candidatos.add(new Candidato("Eduardo Ferreira", 2031, "Senador", "PSDB"));
        candidatos.add(new Candidato("Sofia Lima", 2049, "Senador", "PSDB"));
        candidatos.add(new Candidato("Felipe Nascimento", 25006, "Deputado Federal", "PSDB"));
        candidatos.add(new Candidato("Marcos Silva", 25011, "Deputado Federal", "PSDB"));
        candidatos.add(new Candidato("Patrícia Gomes", 25018, "Deputado Federal", "PSDB"));
        candidatos.add(new Candidato("Vinícius Martins", 33005, "Deputado Estadual", "PSDB"));
        candidatos.add(new Candidato("Beatriz Oliveira", 33009, "Deputado Estadual", "PSDB"));
        candidatos.add(new Candidato("Tiago Mendes", 33020, "Deputado Estadual", "PSDB"));

        // Adiciona candidatos do PROS
        candidatos.add(new Candidato("Lucas Pereira", 35, "Presidente", "PROS"));
        candidatos.add(new Candidato("Fernanda Alves", 245, "Governador", "PROS"));
        candidatos.add(new Candidato("Pedro Henrique", 6242, "Senador", "PROS"));
        candidatos.add(new Candidato("Renata Lima", 3065, "Senador", "PROS"));
        candidatos.add(new Candidato("Marcio Silva", 74332, "Deputado Federal", "PROS"));
        candidatos.add(new Candidato("Juliana Costa", 76319, "Deputado Federal", "PROS"));
        candidatos.add(new Candidato("André Lima", 81734, "Deputado Federal", "PROS"));
        candidatos.add(new Candidato("Fernanda Santos", 86042, "Deputado Estadual", "PROS"));
        candidatos.add(new Candidato("Ricardo Gomes", 97207, "Deputado Estadual", "PROS"));
        candidatos.add(new Candidato("Camila Oliveira", 96433, "Deputado Estadual", "PROS"));

        // Atribuir um número aleatório de votos para cada candidato
        for (Candidato candidato : candidatos) {
            int votos = random.nextInt(100); // Votos aleatórios entre 0 e 99
            for (int j = 0; j < votos; j++) {
                candidato.AddVoto(); // Adiciona o voto ao candidato
            }
        }

        // Gera a eleição
        Eleicao eleicao = new Eleicao(candidatos, 1, 60, 0, 0, 0, 0, 0, 0);
        
        return eleicao;
    }
}
