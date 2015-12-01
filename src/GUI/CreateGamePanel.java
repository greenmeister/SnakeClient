package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Greenmeister on 30/11/15.
 */
public class CreateGamePanel extends JPanel {

    private JLabel labelCreateGame;
    private JLabel labelGameControls;
    private JLabel labelMapSize;
    private JLabel labelName;
    private JTextField textGameControls;
    private JTextField textMapSize;
    private JTextField textName;
    private JButton btnBack;
    private JButton btnHowToPlay;
    private JButton btnCreate;




    public CreateGamePanel() {
        setLayout(null);
        setSize(new Dimension(700, 550));


        labelCreateGame = new JLabel("Create Game");
        labelCreateGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelCreateGame.setBounds(297, 51, 115, 25);
        add(labelCreateGame);

        labelGameControls = new JLabel("Insert game Controls");
        labelGameControls.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelGameControls.setBounds(24, 119, 192, 34);
        add(labelGameControls);

        labelMapSize = new JLabel("Insert your map size");
        labelMapSize.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelMapSize.setBounds(24, 182, 205, 34);
        add(labelMapSize);

        labelName = new JLabel("Name of the Game");
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelName.setBounds(24, 237, 220, 44);
        add(labelName);

        textGameControls = new JTextField("");
        textGameControls.setBounds(280, 120, 192, 34);
        add(textGameControls);

        textMapSize = new JTextField("");
        textMapSize.setBounds(280, 183, 192, 34);
        add(textMapSize);

        textName = new JTextField("");
        textName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textName.setBounds(266, 231, 220, 56);
        add(textName);

        btnBack = new JButton("Back");
        btnBack.setBounds( 280, 485, 192, 34);
        add(btnBack);

        btnHowToPlay = new JButton("How to play");
        btnHowToPlay.setBounds(280, 383, 192, 34);
        add(btnHowToPlay);

        btnCreate = new JButton("Create Game");
        btnCreate.setBounds(280, 293, 192, 34);
        add(btnCreate);


    }



    public String getTextGameControls() {
        return textGameControls.getText();}



    public int getTextMapSize() {

        return Integer.parseInt(textMapSize.getText());
    }

    public String getTextName() {
        return textName.getText();
    }


    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnCreate() {return btnCreate;}



    public JButton getBtnHowToPlay() {
        return btnHowToPlay;
    }

    public void addActionListener(ActionListener event) {

        btnBack.addActionListener(event);
        btnHowToPlay.addActionListener(event);
        btnCreate.addActionListener(event);
    }

}
