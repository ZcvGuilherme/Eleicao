package GUI.Frame_Urna.configs;
import javax.swing.JTextField;
public class StatusManager {
    private Cargo cargoAtual;

    public Cargo getCargoAtual() {
        return cargoAtual;
    }

    public void setCargoAtual(Cargo cargoAtual) {
        this.cargoAtual = cargoAtual;
    }
    public void processarConfirmacao(JTextField campoTexto) {
        String numero = campoTexto.getText();
        if (numero.length() > 0) {
            // Aqui você pode implementar a lógica de confirmação.
            // Por exemplo, você pode armazenar o voto ou realizar outras operações.
    
            System.out.println("Voto confirmado: " + numero);
    
            // Troca o cargo atual para o próximo
            switch (cargoAtual) {
                case PRESIDENTE:
                    setCargoAtual(Cargo.GOVERNADOR);
                    break;
                case GOVERNADOR:
                    setCargoAtual(Cargo.SENADOR);
                    break;
                case SENADOR:
                    setCargoAtual(Cargo.DEPUTADO_FEDERAL);
                    break;
                case DEPUTADO_FEDERAL:
                    setCargoAtual(Cargo.DEPUTADO_ESTADUAL);
                    break;
                case DEPUTADO_ESTADUAL:
                    System.out.println("Fim das votações.");
                    break;
            }
    
            // Atualiza a interface (limpa o campo de texto, por exemplo)
            campoTexto.setText("");
    
            // Exibe o cargo atual após a mudança
            System.out.println("Cargo Atual: " + cargoAtual.getNome());
        }
    }
    
}
