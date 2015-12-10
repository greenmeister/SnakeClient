package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import SDK.Score;



    /**Creating JPanel class with J Components**/
public class HighScorePanel extends JPanel {


        private JLabel lblHighScore;
        private JButton btnBack;
        private JTable tblHighScore;

        /**
         * Creating the panel and adding J components to it
         **/
        public HighScorePanel() {
            setLayout(null);

            /**Setting Names on the components, Setting their font and setting their bounds adding them to panel**/


            lblHighScore = new JLabel("highscores of the games");
            lblHighScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
            lblHighScore.setBounds(20, 34, 400, 35);
            add(lblHighScore);


            btnBack = new JButton("Back");
            btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnBack.setBounds(163, 375, 171, 38);
            add(btnBack);

            /**ScrollPane for table**/

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(20, 60, 400, 300);
            add(scrollPane);


            /**Creating the table and Setting the row names in the object with "", "", "" . for example "username"**/


            tblHighScore = new JTable(new DefaultTableModel(new Object[]{"username", "score"}, 0));
            scrollPane.setViewportView(tblHighScore);


        }


        /**
         * getters for controller class
         **/


        public JButton getBtnBack() {
            return btnBack;
        }

        /**Adding actionListener to JButton**/

        public void addActionListener(ActionListener event) {

            btnBack.addActionListener(event);


        }

        /**Creating table method and telling it what the input will be for the rows. Input for the "username" row will be "score.getUser().getUsername
         * Takes an array of the class score as parameter calling it scores. Then loops through scores and populates the table**/

        public void highScoreTable(Score[] scores) {
            DefaultTableModel model = (DefaultTableModel) tblHighScore.getModel();

            for (Score score : scores) {
                model.addRow(new Object[]{score.getUser().getUsername(), score.getScore()});
            }
        }

        /** a method to clear the table. Otherwise the table keeps adding the same data without removing it
         * if you keep going in and out of the JPanel**/


        public void clearHighscore() {
            DefaultTableModel model = (DefaultTableModel) tblHighScore.getModel();
            model.setRowCount(0);

        }

    }