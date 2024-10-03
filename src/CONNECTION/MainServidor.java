package CONNECTION;

import java.io.IOException;

import CONNECTION.Servidor.Servidor;

public class MainServidor {
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        
        try {
            servidor.iniciar(5004); // Inicia o servidor na porta 5001
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
