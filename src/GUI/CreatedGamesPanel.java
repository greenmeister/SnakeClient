package GUI;

import SDK.Game;
import SDK.Score;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Greenmeister on 08/12/15.
 */

/**Create Jpanel class with J Componenets**/
public class CreatedGamesPanel extends JPanel {

    private JButton btnBack;
    private JTable tblGames;


    /**Creating the panel and adding J components to it**/
    public CreatedGamesPanel() {
        setLayout(null);

        /**Setting Names on the components, Setting their font and setting their bounds adding them to panel**/

        btnBack = new JButton("back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.setBounds(163, 375, 171, 38);
        add(btnBack);


        /**JScrollPane and JTable added**/

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 400, 300);
        add(scrollPane);

        /**Creating the table and Setting the row names in the object with "", "", "" . for example "gameId"**/

        tblGames = new JTable(new DefaultTableModel(new Object[]{"gameId", "created", "Status"}, 0));
        scrollPane.setViewportView(tblGames);
    }

    /**Created getters for the controller class**/
    public JButton getBtnBack() {
        return btnBack;
    }

    /**Adding actionListener to JButton**/

    public void addActionListener(ActionListener event) {

        btnBack.addActionListener(event);


    }
    /**Creating Gamestable method and telling it what the input will be for the rows. Input for the "gameId" row will be "game.getGameId()"
     *
     * Takes an array of the class Game as parameter calling it games. Then loops through games and populates the table**/


    public void gamesTable(Game[] games) {
        DefaultTableModel model = (DefaultTableModel) tblGames.getModel();

        for (Game game : games) {
            model.addRow(new Object[]{game.getGameId(), game.getCreated(), game.getStatus()});
        }
    }

    /** a method to clear the table. Otherwise the table keeps adding the same data without removing it
     * if you keep going in and out of the JPanel**/

    public void clearGamesTable() {
        DefaultTableModel model = (DefaultTableModel) tblGames.getModel();
        model.setRowCount(0);


    }
}