package CONNECTION.ServidorEleicao;

import java.io.*;
import java.net.*;


public class ServidorEleicao {

    private ServerSocket serverSocket;

    public void iniciar(int porta) throws IOException {
        ServerSocket servidor = new ServerSocket(porta);
        System.out.println("Servidor iniciado na porta " + porta);

        while (true) {
            
            try ( Socket socket = serverSocket.accept()){
                System.out.println("Cliente conectado: " + socket.getInetAddress());
                
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                
                // Enviar a ação e o ID da eleição
                out.println("INICIAR_ELEICAO");
                System.out.println("Digite o ID da Eleição para iniciar: ");
                
                int eleicaoId = Integer.parseInt(console.readLine());
                out.println(eleicaoId);
                
                // Receber a resposta do servidor
                System.out.println(in.readLine());
            }catch (IOException e){
                System.out.println("Erro na conexão com o servidor: " + e.getMessage());
            }
        }
   
        }
        
    }

            
        




                //<String> lista = Arrays.asList("Item1", "Item2", "Item3");
                //enviarLista(socket, lista);    
              
    


    
   /**  private void enviarLista(Socket socket, List<String> lista) throws IOException {
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(lista); // Serializa e envia a lista
        saida.flush(); // Garante que os dados são enviados
        System.out.println("Lista enviada ao cliente.");
    }*/

    


