package GUI;

/**
 * Created by Greenmeister on 26/11/15.
 */
import javax.swing.*;
import java.awt.event.ActionListener;

public class PlaySnakePanel extends JPanel {
    private JLabel lblPlaySnake;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public PlaySnakePanel() {
        setLayout(null);

        lblPlaySnake = new JLabel("PLAY SNAKE");
        lblPlaySnake.setBounds(151, 22, 82, 34);
        add(lblPlaySnake);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(99, 95, 187, 41);
        add(btnCreateGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(99, 178, 187, 41);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(99, 253, 187, 41);
        add(btnBack);
    }

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    public void addActionListener(ActionListener event) {

        btnJoinGame.addActionListener(event);
        btnBack.addActionListener(event);
        btnCreateGame.addActionListener(event);


    }

}
