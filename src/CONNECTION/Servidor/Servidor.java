package CONNECTION.Servidor;

import DATABASE.entidade.Eleicao;
import java.io.*;
import java.net.*;

public class Servidor {
    private ServerSocket serverSocket;

    public void iniciar(int porta, Eleicao eleicao, int tempo) throws IOException {
        serverSocket = new ServerSocket(porta);
        serverSocket.setSoTimeout(tempo * 60000); 
        System.out.println("Servidor iniciado na porta " + porta);
 
            while (true) {
                try{
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());
                   
            } catch (SocketTimeoutException e) {
                System.out.println("Tempo de eleição encerrado.");
                break;
            }
           // serverSocket.setSoTimeout(10000);
               
    }

  

    
}

}