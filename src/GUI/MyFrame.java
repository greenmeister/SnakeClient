package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Greenmeister on 25/11/15.
 */
public class MyFrame extends JFrame {

    public static final Dimension SIZE = new Dimension(700, 550);
    public static final String LOGIN = "LOGIN";
    public static final String MENU = "MENU";
    public static final String DELETE = "DELETE";
    public static final String HIGHSCORE = "HIGHSCORE";
    public static final String PLAY = "PLAY";
    public static final String JOIN = "JOIN";
    public static final String CREATE = "CREATE";


    private LoginPanel loginPanel;
    private MenuPanel menuPanel;
    private DeleteGamePanel deleteGamePanel;
    private HighScorePanel highScorePanel;
    private PlaySnakePanel playSnakePanel;
    private JoinGamePanel joinGamePanel;
    private CreateGamePanel createGamePanel;
    private CardLayout c;
    private JPanel contentPane;

    public MyFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



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




        setVisible(true);
        setResizable(false);
        setTitle("TheSnakeGame");


        setBounds(300, 125, (int) SIZE.getWidth(), (int) SIZE.getHeight());

    }
    public void show(String card) {
        c.show(contentPane, card);


    }
    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public DeleteGamePanel getDeleteGamePanel() {
        return deleteGamePanel;
    }
    public HighScorePanel getHighScorePanel(){
        return highScorePanel;
    }
    public PlaySnakePanel getPlaySnakePanel(){
        return playSnakePanel;}

    public JoinGamePanel getJoinGamePanel() {
        return joinGamePanel;}
    public LoginPanel getLoginPanel() {
        return loginPanel;}
    public CreateGamePanel getCreateGamePanel(){
        return createGamePanel;}


}



