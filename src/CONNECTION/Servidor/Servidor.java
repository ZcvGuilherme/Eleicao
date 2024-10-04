package CONNECTION.Servidor;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Eleicao;
import java.io.*;
import java.net.*;
import java.util.List;

public class Servidor {
    private ServerSocket serverSocket;
    private UserDAO dao = new UserDAO();
    private boolean isRunning = false;
    public void iniciar(int porta, Eleicao eleicao, int tempo) throws IOException {
        serverSocket = new ServerSocket(porta);
        serverSocket.setSoTimeout(tempo *60000);
        isRunning = true;
        System.out.println("Servidor iniciado na porta " + porta);

            while (isRunning) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Cliente conectado: " + socket.getInetAddress());
                    enviarLista(socket, eleicao);    
                    enviarID(socket, dao.retornoID());
                } catch (SocketTimeoutException e) {
                    System.out.println("Tempo de eleição encerrado.");
                    break;
                }
                
            }    
    }

    private void enviarLista(Socket socket, Eleicao eleicao) throws IOException {
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(eleicao); // Serializa e envia a lista
        saida.flush(); // Garante que os dados são enviados
        System.out.println("Lista enviada ao cliente.");
    }

    private void enviarID(Socket socket, List<Integer> lista) throws IOException{
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(lista);
        saida.flush();
        System.out.println("Lista Enviada ao cliente");
    }
    public void parar() throws IOException {
        isRunning = false; // Interrompe o loop do servidor
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();  // Fecha o socket do servidor
            System.out.println("Servidor parado.");
        }
    }
    
}
