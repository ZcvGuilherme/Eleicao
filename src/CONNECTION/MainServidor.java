package CONNECTION;

import CONNECTION.Servidor.Servidor;
import DATABASE.entidade.Eleicao;
import java.io.IOException;

public class MainServidor {

    public static void iniciarServidor(Eleicao eleicao){
        Servidor servidor = new Servidor();
        try {
            servidor.iniciar(5005, eleicao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
