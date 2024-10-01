package CONNECTION.Cliente;
import CONNECTION.Cliente.MensagemListener;
import CONNECTION.Cliente.MensagemSender;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int porta = 12345;

        try {
            Socket socket = new Socket(host, porta);
            new MensagemListener(socket).start();
            new MensagemSender(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
