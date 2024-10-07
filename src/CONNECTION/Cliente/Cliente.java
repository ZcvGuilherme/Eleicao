package CONNECTION.Cliente;

import java.io.*;
import java.net.*;
import DATABASE.entidade.Eleicao;

import java.lang.ClassNotFoundException;
import java.util.List;
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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Integer receberID() {
        Integer id = null;
        try {
            // Cria o ObjectInputStream para receber dados do servidor via socket
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
    
            // Recebe o objeto (esperando que seja um Integer) e faz o cast
            id = (Integer) entrada.readObject();
            System.err.println("ID recebido: " + id);
        } catch (IOException | ClassNotFoundException e) {
            // Tratamento de exceção caso ocorra algum problema na comunicação ou no cast
            e.printStackTrace();
        }
    
        return id;  // Retorna o ID recebido (ou null caso ocorra uma falha)
    }
    
    public void fecharConexao() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

}   
