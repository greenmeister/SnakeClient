package GUI;

import SDK.Gamer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Greenmeister on 08/12/15.
 */
/**Creating JPanel class with J Components**/
public class UserScoresPanel extends JPanel {


        private JButton btnBack;
        private JTable tblScores;


    /**
     * Creating the panel and adding J components to it
     **/
        public UserScoresPanel() {
            setLayout(null);

            /**Setting Names on the components,setting font and setting their bounds and adding them to panel**/

            btnBack = new JButton("back");
            btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnBack.setBounds(163, 375, 171, 38);
            add(btnBack);

            /**ScrollPane for table**/

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(20, 60, 400, 300);
            add(scrollPane);

            /**Creating the table and Setting the row names in the object with "", "", "" . for example "Score"**/



            tblScores = new JTable(new DefaultTableModel(new Object[]{"Winner","Score"}, 0));
            scrollPane.setViewportView(tblScores);
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
     * Takes an array of the class Gamer as parameter calling it gamers. Then loops through scores and populates the table**/


    public void scoresTable(Gamer[] gamers) {
        DefaultTableModel model = (DefaultTableModel) tblScores.getModel();

        for (Gamer gamer : gamers) {
            model.addRow(new Object[]{gamer.isWinner(), gamer.getScore()});

        }

    }

    /** a method to clear the table. Otherwise the table keeps adding the same data without removing it
     * if you keep going in and out of the JPanel**/



    public void clearScoresTable() {
            DefaultTableModel model = (DefaultTableModel) tblScores.getModel();
            model.setRowCount(0);


        }

    }
