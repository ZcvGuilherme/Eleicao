package CONNECTION.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // IP do servidor (localhost para a rede local) e porta
        String serverAddress = "127.0.0.1"; // Para conexão Wi-Fi, use o IP local da máquina do servidor
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Conectado ao servidor em " + serverAddress + ":" + port);

            // Streams para enviar e receber dados
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Enviando mensagem para o servidor
            output.println("Olá, servidor!");

            // Lendo resposta do servidor
            String serverMessage = input.readLine();
            System.out.println("Mensagem do servidor: " + serverMessage);

            // Fechando o socket
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
