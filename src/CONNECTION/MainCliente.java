package CONNECTION;

import CONNECTION.Cliente.Cliente;
import GUI.Frame_cadastro_User.Tela.Starter;
import java.io.IOException;

public class MainCliente {

    public static void iniciarCliente() throws ClassNotFoundException{
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("10.14.127.217", 5004); // Conecta ao servidor
            cliente.receberObjeto();
            Starter.iniciarInterface();
                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    

