package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;


/**
 * Created by Greenmeister on 27/11/15.
 */


public class HighScorePanel extends JPanel {

    private JLabel lblHighscore;
    private JLabel lbl1stplace;
    private JLabel lbl1score;
    private JLabel lbl2ndPlace;
    private JLabel lbl2score;
    private JLabel lbl3rdPlace;
    private JLabel lbl3score;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public HighScorePanel() {
        setLayout(null);

        lblHighscore = new JLabel("HIGHSCORES");
        lblHighscore.setBounds(168, 6, 86, 33);
        add(lblHighscore);

        lbl1stplace = new JLabel("1st place");
        lbl1stplace.setBounds(37, 89, 62, 33);
        add(lbl1stplace);

        lbl1score = new JLabel("");
        lbl1score.setBounds(37, 116, 1444, 38);
        add(lbl1score);

        lbl2ndPlace = new JLabel("2nd place");
        lbl2ndPlace.setBounds(192, 89, 62, 33);
        add(lbl2ndPlace);

        lbl2score = new JLabel("");
        lbl2score.setBounds(190, 116, 144, 38);
        add(lbl2score);

        lbl3rdPlace = new JLabel("3rd place");
        lbl3rdPlace.setBounds(370, 89, 62, 33);
        add(lbl3rdPlace);

        lbl3score = new JLabel("");
        lbl3score.setBounds(346, 116, 155, 38);
        add(lbl3score);

        btnBack = new JButton("Back");
        btnBack.setBounds(163, 345, 171, 38);
        add(btnBack);

    }

    public JLabel getLbl1score() {
        return lbl1score;
    }

    public JLabel getLbl2score() {
        return lbl2score;
    }

    public JLabel getLbl3score() {
        return lbl3score;
    }


    public JButton getBtnBack() {
        return btnBack;
    }

    public void addActionListener(ActionListener event) {

        btnBack.addActionListener(event);


    }
}