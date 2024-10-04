package CONNECTION;

import CONNECTION.Servidor.Servidor;
import DATABASE.entidade.Eleicao;
import java.io.IOException;

public class MainServidor {

    public static void iniciarServidor(Eleicao eleicao, int tempo){
        Servidor servidor = new Servidor();
        try {
            servidor.iniciar(5004, eleicao, tempo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
