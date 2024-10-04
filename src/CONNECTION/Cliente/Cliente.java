package CONNECTION.Cliente;

import java.io.*;
import java.net.*;
import DATABASE.entidade.Eleicao;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Cliente {
    private Socket socket;
  
    public void conectar(String endereco, int porta) throws IOException {
        socket = new Socket(endereco, porta);
        System.out.println("Conectado ao servidor.");
      
    }

    public Eleicao receberLista() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            Eleicao eleicao = (Eleicao) entrada.readObject(); // Desserializa a instância de Eleicao
            System.out.println("Objeto Eleicao recebido do servidor: " + eleicao);
            return eleicao;
        } catch (IOException e | ClassNotFoundException a) {
            e.printStackTrace();
            a.printStackTrace();
        }
        return null;
    }

    public void fecharConexao() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

}   
