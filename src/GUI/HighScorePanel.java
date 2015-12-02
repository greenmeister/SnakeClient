package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;




public class HighScorePanel extends JPanel {


    private JButton btnBack;

    /**
     * Create the panel.
     */
    public HighScorePanel() {


        btnBack = new JButton("Back");
        btnBack.setBounds(163, 345, 171, 38);
        add(btnBack);

    }



    public JButton getBtnBack() {
        return btnBack;
    }

    public void addActionListener(ActionListener event) {

        btnBack.addActionListener(event);


    }
}