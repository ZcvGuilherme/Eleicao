package CONNECTION.Cliente;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MensagemListener extends Thread {
    private Socket socket;

    public MensagemListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                System.out.println("Servidor: " + mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

