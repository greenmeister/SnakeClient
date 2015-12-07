package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Greenmeister on 30/11/15.
 */

    /**Create Jpanel class with J Componenets**/
public class CreateGamePanel extends JPanel {

    private JLabel labelCreateGame;
    private JLabel labelGameControls;
    private JLabel labelMapSize;
    private JLabel labelName;
    private JTextField textGameControls;
    private JTextField textMapSize;
    private JTextField textName;
    private JButton btnBack;
    private JButton btnCreate;


        /**Creating the panel and adding J components to it**/

    public CreateGamePanel() {
        setLayout(null);
        setSize(new Dimension(700, 550));

        /**Setting Names on the components, Setting their font and setting their bounds adding them to panel**/

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
        textGameControls.setBounds(266, 120, 230, 34);
        add(textGameControls);


        textMapSize = new JTextField("");
        textMapSize.setBounds(266, 183, 230, 34);
        add(textMapSize);

        textName = new JTextField("");
        textName.setBounds(266, 253, 230, 34);
        add(textName);

        btnBack = new JButton("Back");
        btnBack.setBounds( 280, 485, 192, 34);
        add(btnBack);


        btnCreate = new JButton("Create Game");
        btnCreate.setBounds(280, 418, 192, 34);
        add(btnCreate);


    }

    /**Created getters for the controller class**/


    public String getTextGameControls() {
        return textGameControls.getText();}



    /**Parsing the int to to extract the value from the textField**/
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




    /**Addding actionListener to JButtons**/

    public void addActionListener(ActionListener event) {

        btnBack.addActionListener(event);
        btnCreate.addActionListener(event);
    }

}
