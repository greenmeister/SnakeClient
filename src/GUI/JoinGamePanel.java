package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;


/**
 * Created by Greenmeister on 27/11/15.
 */

public class JoinGamePanel extends JPanel {
    private JLabel lblJoinGame;
    private JLabel lblSearchForGame;
    private JButton btnJoinGame;
    private JButton btnBack;
    private JTextField  textFieldGameID;

    /**
     * Create the panel.
     */
    public JoinGamePanel() {


        setLayout(null);

        lblJoinGame = new JLabel("JOIN GAME");
        lblJoinGame.setBounds(164, 6, 68, 33);
        add(lblJoinGame);

        textFieldGameID = new JTextField();
        textFieldGameID.setBounds(53, 115, 179, 34);
        add(textFieldGameID);


        lblSearchForGame = new JLabel("Search for game by ID");
        lblSearchForGame.setBounds(39, 70, 144, 33);
        add(lblSearchForGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(124, 219, 171, 41);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(124, 319, 171, 39);
        add(btnBack);

    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }


    public void addActionListener(ActionListener event){

        btnBack.addActionListener(event);
        btnJoinGame.addActionListener(event);
    }


    }
