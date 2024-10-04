package CONNECTION.Cliente;

import java.io.*;
import java.net.*;
import java.util.List;



public class Cliente {
    private Socket socket;
  
    public void conectar(String endereco, int porta) throws IOException {
        socket = new Socket(endereco, porta);
        System.out.println("Conectado ao servidor.");
      
    }

    @SuppressWarnings("unchecked")
    public void receberLista() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
      
        List<String> lista = (List<String>) entrada.readObject(); // Desserializa a lista recebida
        System.out.println("Lista recebida do servidor: " + lista);
    }

    public void fecharConexao() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

}   
