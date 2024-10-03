package CONNECTION.Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // Porta onde o servidor estará ouvindo
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor aguardando conexões na porta " + port);

            // Aceitando a conexão do cliente
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado!");

            // Streams para enviar e receber dados
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Lendo mensagem do cliente
            String clientMessage = input.readLine();
            System.out.println("Mensagem do cliente: " + clientMessage);

            // Enviando resposta para o cliente
            output.println("Olá, cliente! Mensagem recebida.");

            // Fechando o socket
            socket.close();
            System.out.println("Conexão encerrada.");
        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
