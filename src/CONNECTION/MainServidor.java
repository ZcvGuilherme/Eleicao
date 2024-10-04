package CONNECTION;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< Updated upstream
import CONNECTION.Servidor.Servidor;
import DATABASE.entidade.Eleicao;
=======
>>>>>>> parent of ecbfade (commit conexao)
=======
>>>>>>> parent of ecbfade (commit conexao)
import java.io.IOException;

import CONNECTION.Servidor.Servidor;

public class MainServidor {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        
        try {
<<<<<<< HEAD
<<<<<<< HEAD
            servidor.iniciar(5005, eleicao);
=======
import CONNECTION.ServidorEleicao.ServidorEleicao;
import java.io.IOException;



public class MainServidor {
    public static void main(String[] args) throws IOException {
        ServidorEleicao servidor = new ServidorEleicao();
        servidor.iniciar(5004);
 
       try {
        servidor.iniciar(5004);
>>>>>>> Stashed changes
=======
            servidor.iniciar(5004); // Inicia o servidor na porta 5001
>>>>>>> parent of ecbfade (commit conexao)
=======
            servidor.iniciar(5004); // Inicia o servidor na porta 5001
>>>>>>> parent of ecbfade (commit conexao)
        } catch (IOException e) {
            System.out.println("Erro na conexão com o servidor: " + e.getMessage());
        }
    }
    
}
