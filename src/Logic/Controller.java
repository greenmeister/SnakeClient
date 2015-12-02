package Logic;

import GUI.*;
import com.sun.jersey.api.client.ClientResponse;
import SDK.User;
import SDK.Gamer;
import SDK.Game;
import com.google.gson.Gson;
import SDK.ServerConnection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Greenmeister on 05/11/15.
 */
public class Controller {

    private MyFrame myFrame;
    private User LoggedInUser;


    public Controller() {

        myFrame = new MyFrame();


    }


    public void run() {

        myFrame.getMenuPanel().addActionListener(new MenuPanelActionListener());
        myFrame.getLoginPanel().addActionListener(new LoginPanelActionListener());
        myFrame.getDeleteGamePanel().addActionListener(new DeleteGamePanelActionListener());
        myFrame.getHighScorePanel().addActionListener(new HighScorePanelActionListener());
        myFrame.getPlaySnakePanel().addActionListener(new PlaySnakePanelActionListener());
        myFrame.getJoinGamePanel().addActionListener(new JoinGamePanelActionListener());
        myFrame.getCreateGamePanel().addActionListener(new CreateGamePanelActionListener());

        myFrame.show(myFrame.LOGIN);
    }

    private class LoginPanelActionListener implements ActionListener {
        boolean authenticated = false;


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getLoginPanel().getBtnLogin()) {

                String username = myFrame.getLoginPanel().getTxtFieldUser().getText();
                String password = myFrame.getLoginPanel().getTxtFieldPw().getText();
                System.out.println(password);


                LoggedInUser = new User();
                LoggedInUser.setPassword(password);
                LoggedInUser.setUsername(username);


                String json = new Gson().toJson(LoggedInUser);


                ServerConnection con = new ServerConnection();
                ClientResponse response = con.post(json, "login");


                if (response.getStatus() == 200) {
                    authenticated = true;
                    System.out.println("User validated");
                    JOptionPane.showMessageDialog(myFrame, "Successful Login");
                    myFrame.getLoginPanel().getTxtFieldUser().setText("");
                    myFrame.getLoginPanel().getTxtFieldPw().setText("");
                    myFrame.show(myFrame.MENU);

                }
                if (response.getStatus() == 500) {

                    authenticated = false;
                    System.out.println("Bad request");
                    JOptionPane.showMessageDialog(myFrame, "The server did not understand the request");
                    myFrame.getLoginPanel().getTxtFieldUser().setText("");
                    myFrame.getLoginPanel().getTxtFieldPw().setText("");
                    myFrame.show(myFrame.LOGIN);


                }
                if (response.getStatus() == 401) {

                    authenticated = false;
                    System.out.println("Unauthorized");
                    JOptionPane.showMessageDialog(myFrame, "User could not be authorized");
                    myFrame.getLoginPanel().getTxtFieldUser().setText("");
                    myFrame.getLoginPanel().getTxtFieldPw().setText("");
                    myFrame.show(myFrame.LOGIN);


                }

            }
        }
    }


    private class MenuPanelActionListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getMenuPanel().getBtnDeleteGame()) {
                myFrame.show(myFrame.DELETE);

            } else if (event.getSource() == myFrame.getMenuPanel().getBtnHighscores()) {


                myFrame.show(myFrame.HIGHSCORE);


            } else if (event.getSource() == myFrame.getMenuPanel().getBtnLogout()) {

                myFrame.show(myFrame.LOGIN);

            } else if (event.getSource() == myFrame.getMenuPanel().getBtnPlaySnake()) {

                myFrame.show(myFrame.PLAY);

            }

        }
    }

    private class DeleteGamePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getDeleteGamePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);

            }
            if (event.getSource() == myFrame.getDeleteGamePanel().getBtnDelete()) {
                try {

                    int gameID = myFrame.getDeleteGamePanel().getGameID();


                    if (gameID != 0) {


                        ServerConnection con = new ServerConnection();
                        ClientResponse response = con.delete("games/" + gameID);

                        if (response.getStatus() == 200) {
                            System.out.println("Game deleted");
                            JOptionPane.showMessageDialog(myFrame, "Game was deleted");
                            myFrame.show(myFrame.DELETE);
                        }

                        if (response.getStatus() == 400) {
                            System.out.println("Game not deleted");
                            JOptionPane.showMessageDialog(myFrame, "Invalid ID - Game not deleted");
                            myFrame.show(myFrame.DELETE);


                            System.out.println(response.getStatus());

                        }
                    }


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(myFrame, "ID Must consist of numbers",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


    private class HighScorePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == myFrame.getHighScorePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);
            }
        }
    }

    private class PlaySnakePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == myFrame.getPlaySnakePanel().getBtnJoinGame()) {

                myFrame.show(myFrame.JOIN);

            }
            if (event.getSource() == myFrame.getPlaySnakePanel().getBtnCreateGame()) {
                myFrame.show(MyFrame.CREATE);
            } else if (event.getSource() == myFrame.getPlaySnakePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);

            }
        }
    }

    private class JoinGamePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == myFrame.getJoinGamePanel().getBtnBack()) {

                myFrame.show(myFrame.PLAY);
            }
        }

    }

    private class CreateGamePanelActionListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == myFrame.getCreateGamePanel().getBtnHowToPlay()) {

                JOptionPane.showMessageDialog(myFrame, "Press W,A,S,D buttons to insert your game controls. \n" +
                        "W corresponds to one movement up with your snake \n" +
                        "A corresponds to one movement to the left with your snake.\n" +
                        "S corresponds to one movement down with you snake.\n" +
                        "D corresponds to one movement to the right with your snake \n" +
                        "Mapsize shall be a number");
            }
            if (event.getSource() == myFrame.getCreateGamePanel().getBtnCreate()) {


                int mapSize = myFrame.getCreateGamePanel().getTextMapSize();
                String controls = myFrame.getCreateGamePanel().getTextGameControls();
                String GameName = myFrame.getCreateGamePanel().getTextName();


                if (mapSize != 0 && !controls.equals("")) {

                    Gamer host = new Gamer();
                    host.setId(LoggedInUser.getId());
                    host.setControls(controls);

                    Game game = new Game();
                    game.setName(GameName);
                    game.setMapSize(mapSize);
                    game.setHost(host);


                    String json = new Gson().toJson(game);

                    ServerConnection con = new ServerConnection();
                    ClientResponse response = con.post(json, "games");

                    System.out.println(json);

                    if (response.getStatus() == 201) {
                        JOptionPane.showMessageDialog(myFrame, "Game Created! Your game ID is :" + host.getId());
                        myFrame.show(myFrame.MENU);

                    }
                }

            } else if (event.getSource() == myFrame.getCreateGamePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);


            }
        }
    }
}



















