package CONNECTION.Connection.Principal;

import java.io.IOException;

public class MainCliente {

    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente(); // Inicialize o cliente como necessário
        Receptor receptor = new Receptor(cliente); // Crie uma instância de Receptor

        try {
            // Conectar ao servidor (supondo que você tenha um método para isso)
            cliente.conectar("127.0.0.1", 5004); // Defina o IP e a porta do servidor
            receptor.monitorar(); // Chame o método monitorar
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cliente.fecharConexao(); // Certifique-se de fechar a conexão ao final
        }
    }

}