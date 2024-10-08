package GUI.Frame_cadastro_User.Configs;

import DATABASE.entidade.User;
import GUI.Frame_Urna.tela.TelaVota;
import GUI.Frame_cadastro_User.Tela.Viewer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class EventController {
    private Viewer view;
    private User user;
    private int IDEsperado;


    public EventController(Viewer view, int IDEsperado) {
        this.view = view;
        this.IDEsperado = IDEsperado;
        init_controller();
    }
    private void init_controller() {
        view.getBotaoConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = view.getTxtID().getText();

                // Redefine a borda para a cor padrão no início da ação
                view.getTxtID().setBorder(BorderFactory.createLineBorder(Color.GRAY));

                if (ID.isEmpty()) {
                    // Exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(view.getFrame(), "Por favor, insira um ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                    // Muda a borda do txtID para vermelho
                    view.getTxtID().setBorder(BorderFactory.createLineBorder(Color.RED));
                    return; // Evita continuar se estiver vazio
                }

                try {
                    // Tenta converter o ID em número
                    int number = Integer.parseInt(ID);
                    if (number != IDEsperado) {
                        JOptionPane.showMessageDialog(view.getFrame(), "ID não encontrado na lista.", "Erro", JOptionPane.ERROR_MESSAGE);
                        view.getTxtID().setBorder(BorderFactory.createLineBorder(Color.RED));
                        return; // Evita continuar se o ID não for encontrado
                    }
                    user = new User(number);

                    // Atualiza os labels com os dados do usuário
                    view.getLabelID().setText("ID: " + user.getId());
                    
                    // Fechar janela -> Abrir janela
                    view.getFrame().dispose();
                    TelaVota.chama_urna();

                } catch (NumberFormatException ex) {
                    // Se não for um número válido, exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(view.getFrame(), "Por favor, insira um ID válido (número).", "Erro", JOptionPane.ERROR_MESSAGE);
                    view.getTxtID().setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
    }
    
}
