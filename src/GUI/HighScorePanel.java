package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import SDK.Score;




public class HighScorePanel extends JPanel {


    private JLabel lblHighScore;
    private JButton btnBack;
    private JTable tblHighScore;

    /**
     * Create the panel.
     */
    public HighScorePanel() {
        setLayout(null);

        lblHighScore = new JLabel("highscores of the games");
        lblHighScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHighScore.setBounds(20, 34, 400, 35);
        add(lblHighScore);



        btnBack = new JButton("Back");
        btnBack.setBounds(163, 375, 171, 38);
        add(btnBack);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 400, 300);
        add(scrollPane);

        tblHighScore = new JTable((new DefaultTableModel(new Object[]{"username", "score"}, 0)));
        scrollPane.setViewportView(tblHighScore);



    }



    public JButton getBtnBack() {
        return btnBack;
    }

    public void addActionListener(ActionListener event) {

        btnBack.addActionListener(event);


    }

}