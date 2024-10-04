package CONNECTION;

import CONNECTION.Cliente.Cliente;
import GUI.Frame_cadastro_User.Tela.Starter;
import java.io.IOException;

public class MainCliente {

     public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 5004); // Conecta ao servidor
            cliente.receberLista(); // Recebe a lista
            Starter.iniciarInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iniciarCliente(){
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 5004); // Conecta ao servidor
            cliente.receberLista(); // Recebe a lista
            Starter.iniciarInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    

