package CONNECTION;

import CONNECTION.Cliente.Cliente;
import GUI.Frame_cadastro_User.Tela.Starter;
import java.io.IOException;
import DATABASE.entidade.Eleicao;
import java.util.List;
public class MainCliente {

     public static void main(String[] args) {
        iniciarCliente();
    }

    public static void iniciarCliente(){
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("192.168.1.5", 5004); // Conecta ao servidor
            Eleicao eleicao = cliente.receberLista();
            Starter.iniciarInterface(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    

