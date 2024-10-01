package CONNECTION.Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import CONNECTION.Servidor.ServidorHandler;
public class Servidor {
    private static final int PORTA = 12345;

    public static void main(String[] args) {
        System.out.println("Servidor iniciado...");
        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ServidorHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
