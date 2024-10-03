package CONNECTION;

<<<<<<< Updated upstream
import CONNECTION.Servidor.Servidor;
import DATABASE.entidade.Eleicao;
import java.io.IOException;

public class MainServidor {

    public static void iniciarServidor(Eleicao eleicao){
        Servidor servidor = new Servidor();
        try {
            servidor.iniciar(5005, eleicao);
=======
import CONNECTION.ServidorEleicao.ServidorEleicao;
import java.io.IOException;



public class MainServidor {
    public static void main(String[] args) throws IOException {
        ServidorEleicao servidor = new ServidorEleicao();
        servidor.iniciar(5004);
 
       try {
        servidor.iniciar(5004);
>>>>>>> Stashed changes
        } catch (IOException e) {
            System.out.println("Erro na conexão com o servidor: " + e.getMessage());
        }
    }
    
}
