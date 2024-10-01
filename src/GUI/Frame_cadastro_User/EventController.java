package GUI.Frame_cadastro_User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EventController {
    private Viewer view;
    private User user;
    
    public EventController(Viewer view) {
        this.view = view;
        init_controller();
    }
    private void init_controller(){
        view.getBotaoConfirmar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = view.getTxtID().getText();
                int number = Integer.parseInt(ID);
                user = new User(number);

                // Atualiza os labels com os dados do usuário
                view.getLabelID().setText("ID: " + user.getId());

            }
        });
    }
}
