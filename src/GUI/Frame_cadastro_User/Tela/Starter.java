package GUI.Frame_cadastro_User.Tela;

import GUI.Frame_cadastro_User.Configs.EventController;

import java.util.List;

import CONNECTION.Cliente.Cliente;
public class Starter {
    public static void iniciarInterface(){
        List<Integer> ids = new Cliente().receberID();
        Viewer view = new Viewer();
        EventController controller = new EventController(view, ids);
    }
}
