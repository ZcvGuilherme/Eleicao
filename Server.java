import java.io.*;
import java.net.*;

public class Localconnection {

    // Servidor
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Aguardando conexão...");
            Socket socket = serverSocket.accept();
            System.out.println("Conexão estabelecida com " + socket.getInetAddress());

            // Lógica da urna eletrônica aqui

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cliente
    public static void conectar() {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Enviar dados para a urna
            out.println("Dados da votação");

            // Receber resposta
            String resposta = in.readLine();
            System.out.println("Resposta do servidor: " + resposta);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}