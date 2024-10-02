package CONNECTION.Cliente;

import java.util.Scanner;
import java.io.IOException;

public class Receptor {
    private Cliente cliente;

    public Receptor(Cliente cliente) {
        this.cliente = cliente;
    }

    public void monitorar() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String mensagem;
        
        while (true) {
            System.out.print("Digite uma mensagem (ou 'sair' para encerrar): ");
            mensagem = scanner.nextLine();
            
            if (mensagem.equalsIgnoreCase("sair")) {
                cliente.fecharConexao(); 
                System.out.println("Conexão encerrada.");
                break;
            } else {
                cliente.enviarMensagem(mensagem);
                cliente.receberMensagem();
            }
        }
        
        scanner.close();
    }
}