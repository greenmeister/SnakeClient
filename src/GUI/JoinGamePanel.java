package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by Greenmeister on 27/11/15.
 */


    /**Creating JPanel class with J Components**/
public class JoinGamePanel extends JPanel {
    private JLabel lblJoinGame;
    private JLabel lblSearchForGame;
    private JLabel lblControls;
    private JButton btnJoinGame;
    private JButton btnBack;
    private JTextField  textFieldGameID;
    private JTextField textFieldOppControls;


        /**Creating the panel and adding J components to it**/
    public JoinGamePanel() {


        /**Setting Names on the components, Setting their font and setting their bounds and adding them to panel**/
        setLayout(null);

        lblJoinGame = new JLabel("JOIN GAME");
        lblJoinGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblJoinGame.setBounds(268, 6, 83, 33);
        add(lblJoinGame);

        textFieldGameID = new JTextField();
        textFieldGameID.setBounds(223, 116, 179, 34);
        add(textFieldGameID);

        lblControls = new JLabel("Insert Your Game controls");
        lblControls.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblControls.setBounds(18, 189, 193, 33);
        add(lblControls);

        textFieldOppControls = new JTextField();
        textFieldOppControls.setBounds(223, 188, 179, 34);
        add(textFieldOppControls);


        lblSearchForGame = new JLabel("Search for game by ID");
        lblSearchForGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSearchForGame.setBounds(18, 117, 193, 33);
        add(lblSearchForGame);


        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(223, 292, 179, 41);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(223, 493, 179, 39);
        add(btnBack);

    }
        /**getters for controller class**/

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    public String getTextFieldOppControls() {
        return textFieldOppControls.getText();}

    public int getTextFieldGameID() {
        return Integer.parseInt(textFieldGameID.getText());

    }



        /**Adding actionlistner to Jbutton**/
    public void addActionListener(ActionListener event){

        btnBack.addActionListener(event);
        btnJoinGame.addActionListener(event);
    }



    }

