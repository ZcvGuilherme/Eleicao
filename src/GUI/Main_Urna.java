package GUI;

import GUI.Eleicao.Separador;
import GUI.Frame_cadastro_User.Tela.Starter;
public class Main_Urna {
    public static void main(String[] args) {
        Separador.printEleicao();
        /*
         * Inicia conexão com a rede
         * -------------------------
         * se conexão for um sucessor inicia o processo da urna:
         * Se identifique
         * aparece a urna
         * terminou os votos, finaliza
         */
        Starter.venha();
    }
}
