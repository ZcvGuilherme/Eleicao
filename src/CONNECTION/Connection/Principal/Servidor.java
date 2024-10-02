package CONNECTION.Connection.Principal;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Servidor {
    private ServerSocket serverSocket;

    public void iniciar(int porta) throws IOException {
        serverSocket = new ServerSocket(porta);
        System.out.println("Servidor iniciado na porta " + porta);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado: " + socket.getInetAddress());
            new SocketDAO(socket).start();
        }
    }

    public void parar() throws IOException {
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
    } 
}
