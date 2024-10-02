package CONNECTION.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;

    public void conectar(String endereco, int porta) throws IOException {

        socket = new Socket();
        try {
            socket = new Socket(endereco, porta);
            System.out.println("Conectado ao servidor: " + endereco + ":" + porta);
            
            // Após a conexão bem-sucedida, inicialize os streams
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Conectado ao servidor.");

            // Continue com o processamento do cliente

        } catch (IOException e) {
            System.err.println("Erro ao tentar conectar ao servidor: " + e.getMessage());
            e.printStackTrace();
        }     
    }

    public void enviarMensagem(String mensagem) {
        saida.println(mensagem);
    }

    public void receberMensagem() throws IOException {
        String resposta = entrada.readLine();
        System.out.println("Resposta do servidor: " + resposta);
    }

    public void fecharConexao() throws IOException {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }
}