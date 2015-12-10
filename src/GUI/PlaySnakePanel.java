package GUI;

/**
 * Created by Greenmeister on 26/11/15.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**Create Jpanel class with J Componenets**/


public class PlaySnakePanel extends JPanel {
    private JLabel lblPlaySnake;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
    private JButton btnBack;
    private JButton btnHowToPlay;
    private JButton btnMyGames;
    private JButton btnMyScores;
    private JLabel Background;




    /**Creating the panel and adding J components to it**/

    public PlaySnakePanel() {
        setLayout(null);

        /**Setting Names on the components, Setting their font and setting their bounds adding them to panel**/



        lblPlaySnake = new JLabel("Play a game of Snake.");
        lblPlaySnake.setFont(new Font("Tahoma", Font.PLAIN, 16));
        /**Changing the color of the Label to match with background picture**/
        lblPlaySnake.setForeground(new Color(255, 228, 181));
        lblPlaySnake.setBounds(229, 29, 156, 34);
        add(lblPlaySnake);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCreateGame.setBounds(215, 125, 187, 41);
        add(btnCreateGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnJoinGame.setBounds(215, 181, 187, 41);
        add(btnJoinGame);

        btnHowToPlay = new JButton("How to play");
        btnHowToPlay.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnHowToPlay.setBounds(215, 241, 187, 41);
        add(btnHowToPlay);

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.setBounds(215, 304, 187, 41);
        add(btnBack);

        btnMyGames = new JButton("Your created games");
        btnMyGames.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnMyGames.setBounds(188, 428, 255, 41);
        add(btnMyGames);

        btnMyScores = new JButton("Your scores");
        btnMyScores.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnMyScores.setBounds(188, 373, 255, 41);
        add(btnMyScores);

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

    /**Created getters for the controller class**/

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

    public JButton getbtnMyGames(){return btnMyGames;}

    public JButton getBtnMyScores(){return btnMyScores;}


    /**Addding actionListener to JButtons**/

    public void addActionListener(ActionListener event) {

        btnJoinGame.addActionListener(event);
        btnBack.addActionListener(event);
        btnCreateGame.addActionListener(event);
        btnHowToPlay.addActionListener(event);
        btnMyGames.addActionListener(event);
        btnMyScores.addActionListener(event);



    }

}
