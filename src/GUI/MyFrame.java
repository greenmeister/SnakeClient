package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Greenmeister on 25/11/15.
 */

    /**Creating class with final strings and J components. The final strings are used in controller class to show the proper JPanels
     * also used to add Panels to contentPane**/

public class MyFrame extends JFrame {

    public static final Dimension SIZE = new Dimension(700, 550);
    public static final String LOGIN = "LOGIN";
    public static final String MENU = "MENU";
    public static final String DELETE = "DELETE";
    public static final String HIGHSCORE = "HIGHSCORE";
    public static final String PLAY = "PLAY";
    public static final String JOIN = "JOIN";
    public static final String CREATE = "CREATE";
    public static final String MYGAMES = "MYGAMES";
    public static final String SCORES = "SCORES";


    private LoginPanel loginPanel;
    private MenuPanel menuPanel;
    private DeleteGamePanel deleteGamePanel;
    private HighScorePanel highScorePanel;
    private PlaySnakePanel playSnakePanel;
    private JoinGamePanel joinGamePanel;
    private CreateGamePanel createGamePanel;
    private CreatedGamesPanel createdGamesPanel;
    private UserScoresPanel userScoresPanel;
        /**Chose CardLayout for GUI **/
    private CardLayout c;
    private JPanel contentPane;


    /**Creating the frame in the Constructor. **/
    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**Creating ContentPane on which the JPanels are attached**/

        contentPane = new JPanel();
        setContentPane(contentPane);
        c = new CardLayout();
        contentPane.setLayout(c);

        loginPanel = new LoginPanel();
        contentPane.add(loginPanel, LOGIN);

        menuPanel = new MenuPanel();
        contentPane.add(menuPanel, MENU);

        deleteGamePanel = new DeleteGamePanel();
        contentPane.add(deleteGamePanel, DELETE);

        highScorePanel = new HighScorePanel();
        contentPane.add(highScorePanel, HIGHSCORE);

        playSnakePanel = new PlaySnakePanel();
        contentPane.add(playSnakePanel, PLAY);

        joinGamePanel = new JoinGamePanel();
        contentPane.add(joinGamePanel, JOIN);

        createGamePanel = new CreateGamePanel();
        contentPane.add(createGamePanel, CREATE);

        createdGamesPanel = new CreatedGamesPanel();
        contentPane.add(createdGamesPanel, MYGAMES);

        userScoresPanel = new UserScoresPanel();
        contentPane.add(userScoresPanel, SCORES);


        /**makes sure that JFrame will be visible when starting program**/
        setVisible(true);
        /**cannot rezise the frame**/
        setResizable(false);
        /**Setting the title on the frame**/
        setTitle("TheSnakeGame");

            /**setting the bounds of the frame**/
        setBounds(300, 125, (int) SIZE.getWidth(), (int) SIZE.getHeight());

    }

    /**method which is used in controller class to show the various JPanels that corresponds to users actions**/
    public void show(String card) {
        c.show(contentPane, card);


    }

    /**Getters  for the controller class to use**/

    public MenuPanel getMenuPanel() {return menuPanel;}

    public DeleteGamePanel getDeleteGamePanel() {
        return deleteGamePanel;
    }

    public HighScorePanel getHighScorePanel() {
        return highScorePanel;
    }

    public PlaySnakePanel getPlaySnakePanel() {
        return playSnakePanel;
    }

    public JoinGamePanel getJoinGamePanel() {
        return joinGamePanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public CreateGamePanel getCreateGamePanel() {
        return createGamePanel;
    }

    public CreatedGamesPanel getCreatedGamesPanel(){return createdGamesPanel;}

    public UserScoresPanel getUserScoresPanel(){return userScoresPanel;}

}



