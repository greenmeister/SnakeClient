package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Greenmeister on 25/11/15.
 */

    /**Create Jpanel class with J Componenets**/
    public class LoginPanel extends JPanel {

    private JButton btnLogin;
    private JPasswordField txtFieldPw;
    private JTextField txtFieldUser;
    private JLabel LabelPassword;
    private JLabel LabelUserName;
    private JLabel Background;


        /**Creating the panel and adding J components to it**/

    public LoginPanel() {
        setLayout(null);

        /**Setting Names on the components, Setting their font and setting their bounds adding them to panel**/


        LabelUserName = new JLabel("Username:");
        LabelUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        /**Changing the color of the Label to match with background picture**/
        LabelUserName.setForeground(new Color(255, 228, 181));
        LabelUserName.setBounds(207, 101, 102, 34);
        add(LabelUserName);


        txtFieldUser = new JTextField();
        txtFieldUser.setBounds(316, 104, 179, 34);
        add(txtFieldUser);

        LabelPassword = new JLabel("Password:");
        LabelPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        /**Changing the color of the Label to match with background picture**/
        LabelPassword.setForeground(new Color(255, 228, 181));
        LabelPassword.setBounds(207, 158, 95, 34);
        add(LabelPassword);

        txtFieldPw = new JPasswordField();
        txtFieldPw.setBounds(316, 161, 179, 34);
        add(txtFieldPw);


        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogin.setBounds(215, 438, 262, 41);
        add(btnLogin);


        /**Adding background image**/

        try { /** tries to load image **/

            BufferedImage img = ImageIO.read(this.getClass().getResource("/Pictures/snake.jpg"));
            Background = new JLabel("");
            Background.setIcon(new ImageIcon(img));
            Background.setBounds(0, 0, 700, 550);
            add(Background);
        } catch (IOException ex) {

        }

    }
        /**Addding actionListener to JButtons**/

    public void addActionListener(ActionListener event) {

        btnLogin.addActionListener(event);


    }
        /**Created getters for the controller class**/

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JTextField getTxtFieldUser() {
        return txtFieldUser;
    }

    public JPasswordField getTxtFieldPw() {
        return txtFieldPw;

    }
}



