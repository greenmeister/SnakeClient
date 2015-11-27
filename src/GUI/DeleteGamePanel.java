package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by Greenmeister on 27/11/15.
 */



public class DeleteGamePanel extends JPanel {
    private JLabel lblDeleteGame;
    private JLabel lblInsertGameId;
    private JTextField gameID;
    private JButton btnDelete;
    private JButton btnBack;
    private JLabel Background;


    /**
     * Create the panel.
     */
    public DeleteGamePanel() {

        setLayout(null);
        setSize(700, 550);

        lblDeleteGame = new JLabel("DELETE GAME");
        lblDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblDeleteGame.setBounds(297, 49, 127, 33);
        add(lblDeleteGame);

        lblInsertGameId = new JLabel("Please type Game ID to Delete Game");
        lblInsertGameId.setBounds(243, 133, 236, 33);
        add(lblInsertGameId);

        gameID = new JTextField();
        gameID.setBounds(243, 178, 236, 39);
        add(gameID);
        gameID.setColumns(10);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(274, 368, 171, 41);
        add(btnDelete);

        btnBack = new JButton("Back");
        btnBack.setBounds(274, 475, 171, 41);
        add(btnBack);

        try // tries to load image
        {
            BufferedImage img = ImageIO.read(this.getClass().getResource("/Pictures/delete.jpg"));
            Background = new JLabel("");
            Background.setIcon(new ImageIcon(img));
            Background.setBounds(0, 0, 700, 550);
            add(Background);
        } // try ends
        catch (IOException ex) {

        }

    }

    public int getGameID() {
        return Integer.parseInt(gameID.getText());
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void addActionListener(ActionListener event) {

        btnDelete.addActionListener(event);
        btnBack.addActionListener(event);


    }


}
