package CONNECTION.Servidor;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;

public class Servidor {
    private ServerSocket serverSocket;

    public void iniciar(int porta) throws IOException {
        serverSocket = new ServerSocket(porta);
        System.out.println("Servidor iniciado na porta " + porta);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());
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

    
}
