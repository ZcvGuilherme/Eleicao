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
    public List<Integer> receberID() {
        List<Integer> lista = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            lista = (List<Integer>) entrada.readObject();  // Cast para List<Integer>
            System.err.println("Lista recebida: " + lista);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();  // Tratamento de exceção
        }
        return lista;  // Retorna a lista (mesmo se for null)
    }
    
    public void fecharConexao() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

}   
