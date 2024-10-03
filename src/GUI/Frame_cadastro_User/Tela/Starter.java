package GUI.Frame_cadastro_User.Tela;

import GUI.Frame_cadastro_User.Configs.EventController;

public class Starter {
    public static void iniciarInterface(){
        Viewer view = new Viewer();
        EventController controller = new EventController(view);
    }
}
