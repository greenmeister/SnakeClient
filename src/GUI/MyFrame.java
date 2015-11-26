package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Greenmeister on 25/11/15.
 */
public class MyFrame extends JFrame {

    public static final Dimension SIZE = new Dimension(700, 550);
    public static final String LOGIN = "LOGIN";


    private JPanel contentPane;
    private CardLayout c;
    private LoginPanel loginPanel;


    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        c = new CardLayout();
        contentPane.setLayout(c);

        loginPanel = new LoginPanel();
        contentPane.add(loginPanel, LOGIN);


        setVisible(true);
        setResizable(false);
        setTitle("TheSnakeGame");


        setBounds(300, 125, (int) SIZE.getWidth(), (int) SIZE.getHeight());

    }




    }
