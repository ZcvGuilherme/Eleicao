package CONNECTION.Servidor;

import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class ServidorHandler extends Thread {
    private Socket socket;
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private PrintWriter out;

    public ServidorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out = new PrintWriter(socket.getOutputStream(), true);
            synchronized (clientWriters) {
                clientWriters.add(out);
            }
            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                System.out.println("Recebido: " + mensagem);
                synchronized (clientWriters) {
                    for (PrintWriter writer : clientWriters) {
                        writer.println(mensagem);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (clientWriters) {
                clientWriters.remove(out);
            }
        }
    }
}
