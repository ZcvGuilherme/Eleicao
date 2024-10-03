package CONNECTION;

import java.io.IOException;

import CONNECTION.Cliente.Cliente;

public class MainCliente {

     public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            cliente.conectar("localhost", 5004); // Conecta ao servidor
            cliente.receberLista(); // Recebe a lista
            cliente.fecharConexao(); // Fecha a conexão
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
    

