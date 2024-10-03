package CONNECTION;

import CONNECTION.EleitorServer.EleitorServer;
import java.io.IOException;



public class MainEleitor {

     public static void main(String[] args) {
        EleitorServer eleitorServer = new EleitorServer();
        try {
            eleitorServer.conectar("localhost", 5004); // Conecta ao servidor
            eleitorServer.receberLista(); // Recebe a lista
            eleitorServer.fecharConexao(); // Fecha a conexão
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    

