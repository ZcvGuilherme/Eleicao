package CONNECTION;

import java.io.IOException;

import CONNECTION.Cliente.Cliente;

public class MainCliente {

    public static void iniciarCliente() throws ClassNotFoundException{
        Cliente cliente = new Cliente();
        try {
<<<<<<< HEAD
            cliente.conectar("10.14.127.217", 5004); // Conecta ao servidor
            cliente.receberObjeto();
            Starter.iniciarInterface();
                
        } catch (IOException e) {
=======
            cliente.conectar("localhost", 5004); // Conecta ao servidor
            cliente.receberLista(); // Recebe a lista
            cliente.fecharConexao(); // Fecha a conexão
        } catch (IOException | ClassNotFoundException e) {
>>>>>>> parent of ecbfade (commit conexao)
            e.printStackTrace();
        }
    }
}
    

