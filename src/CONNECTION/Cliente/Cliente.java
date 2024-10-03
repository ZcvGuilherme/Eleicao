package CONNECTION.Cliente;

import DATABASE.entidade.Eleicao;
import java.io.*;
import java.net.*;




public class Cliente {
    private Socket socket;
  
    public void conectar(String endereco, int porta) throws IOException {
        socket = new Socket(endereco, porta);
        System.out.println("Conectado ao servidor.");
      
    }
   
    public void receberObjeto() throws IOException, ClassNotFoundException{
        ObjectInputStream entrada = new  ObjectInputStream(socket.getInputStream());
        Eleicao eleicao = (Eleicao) entrada.readObject();
        System.out.println("Objeto recebido " + eleicao.toString());

    }

   
    public void fecharConexao() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

}   
