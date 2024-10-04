package GUI;

import GUI.Frame_cadastro_User.Tela.Starter;
public class Main_Urna {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
         * Inicia conexão com a rede
         * -------------------------
         * se conexão for um sucessor inicia o processo da urna:
         * Se identifique
         * aparece a urna
         * terminou os votos, finaliza
         */
        Starter.iniciarInterface();
    }
}