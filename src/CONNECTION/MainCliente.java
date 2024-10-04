package CONNECTION;

import CONNECTION.Cliente.Cliente;
import GUI.Frame_cadastro_User.Tela.Starter;
import java.io.IOException;
import DATABASE.entidade.Eleicao;
import java.util.List;
public class MainCliente {

     public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 5004); // Conecta ao servidor
            cliente.receberLista(); // Recebe a lista
            Starter.iniciarInterface(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iniciarCliente(){
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("192.168.1.5", 5004); // Conecta ao servidor
            cliente.receberLista();
            Starter.iniciarInterface(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    

