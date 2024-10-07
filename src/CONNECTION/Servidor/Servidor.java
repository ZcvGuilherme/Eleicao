package CONNECTION.Servidor;

import DATABASE.DAO.UserDAO;
import DATABASE.entidade.Eleicao;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Random;

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
        if (lista.isEmpty()) {
            System.out.println("Todos os IDs já foram distribuídos.");
            return; // Ou pode tratar isso de outra forma
        }
        // Gera um índice aleatório dentro dos limites da lista
        Random random = new Random();
        int indexAleatorio = random.nextInt(lista.size());  // Gera um número aleatório de 0 até o tamanho da lista - 1

        // Atribui o ID aleatório e o remove da lista
        int idCliente = lista.remove(indexAleatorio); 
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(idCliente);  // Envia apenas o ID, não a lista inteira
        saida.flush();
    
        System.out.println("ID " + idCliente + " enviado ao cliente.");
    }
    public void parar() throws IOException {
        isRunning = false; // Interrompe o loop do servidor
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();  // Fecha o socket do servidor
            System.out.println("Servidor parado.");
        }
    }
    
}
