package CONNECTION.Connection.Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketDAO extends Thread {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;

    public SocketDAO(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream(), true);

            String mensagem;
            while ((mensagem = entrada.readLine()) != null) {
                System.out.println("Recebido: " + mensagem);
                Messenger.enviarMensagem(saida, mensagem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}