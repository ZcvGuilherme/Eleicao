package CONNECTION.Servidor;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class Servidor {
    private ServerSocket serverSocket;

<<<<<<< HEAD
<<<<<<< HEAD
    public void iniciar(int porta, Eleicao eleicao, int tempo) throws IOException {
=======
    public void iniciar(int porta) throws IOException {
>>>>>>> parent of ecbfade (commit conexao)
=======
    public void iniciar(int porta) throws IOException {
>>>>>>> parent of ecbfade (commit conexao)
        serverSocket = new ServerSocket(porta);
        serverSocket.setSoTimeout(tempo * 60000); 
        System.out.println("Servidor iniciado na porta " + porta);
 
            while (true) {
                try{
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());
<<<<<<< HEAD
<<<<<<< HEAD
                   
            } catch (SocketTimeoutException e) {
                System.out.println("Tempo de eleição encerrado.");
                break;
            }
           // serverSocket.setSoTimeout(10000);
               
    }

  
=======
=======
>>>>>>> parent of ecbfade (commit conexao)
                List<String> lista = Arrays.asList("Item1", "Item2", "Item3");
                enviarLista(socket, lista);    
            }    
    }

    private void enviarLista(Socket socket, List<String> lista) throws IOException {
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(lista); // Serializa e envia a lista
        saida.flush(); // Garante que os dados são enviados
        System.out.println("Lista enviada ao cliente.");
    }
>>>>>>> parent of ecbfade (commit conexao)

    
}

}