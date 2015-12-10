package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


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
    private JLabel Background;

        /**Creating the panel and adding J components to it**/
    public JoinGamePanel() {


        /**Setting Names on the components, Setting their font and setting their bounds and adding them to panel**/
        setLayout(null);

        lblJoinGame = new JLabel("JOIN GAME");
        lblJoinGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        /**Changing the color of the Label to match with background picture**/
        lblJoinGame.setForeground(new Color(255, 228, 181));
        lblJoinGame.setBounds(268, 6, 83, 33);
        add(lblJoinGame);

        textFieldGameID = new JTextField();
        textFieldGameID.setBounds(223, 116, 179, 34);
        add(textFieldGameID);

        lblControls = new JLabel("Insert Your Game controls");
        lblControls.setFont(new Font("Tahoma", Font.PLAIN, 16));
        /**Changing the color of the Label to match with background picture**/
        lblControls.setForeground(new Color(255, 228, 181));
        lblControls.setBounds(18, 189, 193, 33);
        add(lblControls);

        textFieldOppControls = new JTextField();
        textFieldOppControls.setBounds(223, 188, 179, 34);
        add(textFieldOppControls);


        lblSearchForGame = new JLabel("Search for game by ID");
        lblSearchForGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        /**Changing the color of the Label to match with background picture**/
        lblSearchForGame.setForeground(new Color(255, 228, 181));
        lblSearchForGame.setBounds(18, 117, 193, 33);
        add(lblSearchForGame);


        btnJoinGame = new JButton("Join game");
        btnJoinGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnJoinGame.setBounds(223, 292, 179, 41);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.setBounds(223, 493, 179, 39);
        add(btnBack);

        /**Adding background image**/

        try { /** tries to load image **/

            BufferedImage img = ImageIO.read(this.getClass().getResource("/Pictures/snake.jpg"));
            Background = new JLabel("");
            Background.setIcon(new ImageIcon(img));
            Background.setBounds(0, 0, 700, 550);
            add(Background);
        } catch (IOException ex) {

        }

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


        /**Parsing the int to to extract the value from the textField**/
    public int getTextFieldGameID() {
        return Integer.parseInt(textFieldGameID.getText());

    }



        /**Adding actionlistner to Jbutton**/
    public void addActionListener(ActionListener event){

        btnBack.addActionListener(event);
        btnJoinGame.addActionListener(event);
    }



    }

