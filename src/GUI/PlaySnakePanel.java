package GUI;

/**
 * Created by Greenmeister on 26/11/15.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class PlaySnakePanel extends JPanel {
    private JLabel lblPlaySnake;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
    private JButton btnBack;
    private JButton btnHowToPlay;
    /**
     * Create the panel.
     */
    public PlaySnakePanel() {
        setLayout(null);

        lblPlaySnake = new JLabel("Play a game of Snake.");
        lblPlaySnake.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPlaySnake.setBounds(229, 29, 156, 34);
        add(lblPlaySnake);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(215, 125, 187, 41);
        add(btnCreateGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(215, 181, 187, 41);
        add(btnJoinGame);

        btnHowToPlay = new JButton("How to play");
        btnHowToPlay.setBounds(215, 241, 187, 41);
        add(btnHowToPlay);

        btnBack = new JButton("Back");
        btnBack.setBounds(215, 304, 187, 41);
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

    public JButton getBtnHowToPlay() {
        return btnHowToPlay;
    }


    public void addActionListener(ActionListener event) {

        btnJoinGame.addActionListener(event);
        btnBack.addActionListener(event);
        btnCreateGame.addActionListener(event);
        btnHowToPlay.addActionListener(event);



    }

}
