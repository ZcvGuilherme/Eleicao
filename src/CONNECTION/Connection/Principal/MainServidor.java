package CONNECTION.Connection.Principal;

import java.io.IOException;

public class MainServidor {
    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor();
        try {
            servidor.iniciar(5004);  // Definindo a porta 5000
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }
}

