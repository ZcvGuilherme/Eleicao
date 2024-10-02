package CONNECTION.Servidor;

import java.io.PrintWriter;

public class Messenger {

    public static void enviarMensagem(PrintWriter saida, String mensagem) {
        // Aqui pode ser implementada alguma lógica de transformação da mensagem
        System.out.println("Enviando para o cliente: " + mensagem);
        saida.println("Servidor: " + mensagem);
    }
}