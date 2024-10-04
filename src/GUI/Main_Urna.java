package GUI;
import CONNECTION.MainCliente;
public class Main_Urna {
    public static void main(String[] args) {
        /*
         * Inicia conexão com a rede
         * -------------------------
         * se conexão for um sucessor inicia o processo da urna:
         * Se identifique
         * aparece a urna
         * terminou os votos, finaliza
         */
        MainCliente.iniciarCliente();
    }
}