package GUI;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Greenmeister on 26/11/15.
 */

/**Creating JPanel class with J Components**/

public class MenuPanel extends JPanel {

    private JButton btnPlaySnake;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogout;
    private JLabel Background;
    /**Creating the panel and adding J components to it**/

    public MenuPanel() {

        /**Setting Names on the components, Setting their font and setting their bounds adding them to panel**/

        setLayout(null);
        setSize(700, 550);


        btnPlaySnake = new JButton("Play Snake");
        btnPlaySnake.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPlaySnake.setBounds(208, 142, 255, 41);
        add(btnPlaySnake);

        btnHighscores = new JButton("Highscores");
        btnHighscores.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHighscores.setBounds(208, 197, 255, 41);
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete game");
        btnDeleteGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDeleteGame.setBounds(208, 250, 255, 41);
        add(btnDeleteGame);

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogout.setBounds(208, 486, 255, 41);
        add(btnLogout);



     
        /**Adding background image**/

        try /**Tries to load image **/
        {
            BufferedImage img = ImageIO.read(this.getClass().getResource("/Pictures/snake.jpg")); // loads image from package image images
            Background = new JLabel(""); // creates label without text
            Background.setIcon(new ImageIcon(img)); // sets label icon to the loaded image
            Background.setBounds(0, 0, 700, 550); // sets background size
            add(Background);

        } // try ends
        catch (IOException ex) {

        }


    }    /**Created getters for the controller class**/


    public JButton getBtnPlaySnake() {
        return btnPlaySnake;
    }

    public JButton getBtnHighscores() {
        return btnHighscores;
    }

    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }



    /**Addding actionListener to JButtons**/

    public void addActionListener(ActionListener event) {

        btnDeleteGame.addActionListener(event);
        btnHighscores.addActionListener(event);
        btnLogout.addActionListener(event);
        btnPlaySnake.addActionListener(event);


    }
}




