package Logic;

import GUI.*;
import SDK.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Controller {

    private MyFrame myFrame;
    private ServerConnection con = new ServerConnection();
    private Methods method;


    public Controller() {

        myFrame = new MyFrame();
        method = new Methods();


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


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getLoginPanel().getBtnLogin()) {

                String username = myFrame.getLoginPanel().getTxtFieldUser().getText();
                String password = myFrame.getLoginPanel().getTxtFieldPw().getText();


                method.login(username, password);


                JOptionPane.showMessageDialog(myFrame, "Successful Login");
                myFrame.getLoginPanel().getTxtFieldUser().setText("");
                myFrame.getLoginPanel().getTxtFieldPw().setText("");
                myFrame.show(myFrame.MENU);

            } else {
                JOptionPane.showMessageDialog(myFrame, "Login failed");
                myFrame.getLoginPanel().getTxtFieldUser().setText("");
                myFrame.getLoginPanel().getTxtFieldPw().setText("");

            }
        }
    }


    private class MenuPanelActionListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getMenuPanel().getBtnDeleteGame()) {
                myFrame.show(myFrame.DELETE);

            } else if (event.getSource() == myFrame.getMenuPanel().getBtnHighscores()) {


                myFrame.show(MyFrame.HIGHSCORE);




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


                        method.deleteGame(gameID);
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
            if (event.getSource() == myFrame.getPlaySnakePanel().getBtnHowToPlay()) {

                JOptionPane.showMessageDialog(myFrame, "Press W,A,S,D buttons to insert your game controls. \n" +
                        "W corresponds to one movement up with your snake \n" +
                        "A corresponds to one movement to the left with your snake.\n" +
                        "S corresponds to one movement down with you snake.\n" +
                        "D corresponds to one movement to the right with your snake \n" +
                        "Mapsize shall be a number");
            }

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
            if (event.getSource() == myFrame.getJoinGamePanel().getBtnJoinGame()) {


                try {


                    int gameID = myFrame.getJoinGamePanel().getTextFieldGameID();
                    String oppControls = myFrame.getJoinGamePanel().getTextFieldOppControls();

                    if (gameID != 0 && !oppControls.equals("")) {

                        method.joinGame(gameID, oppControls);


                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(myFrame, "ID Must consist of numbers",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (event.getSource() == myFrame.getJoinGamePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);

            }
        }
    }


        private class CreateGamePanelActionListener implements ActionListener {


            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == myFrame.getCreateGamePanel().getBtnCreate()) {


                        int mapSize = myFrame.getCreateGamePanel().getTextMapSize();
                        String controls = myFrame.getCreateGamePanel().getTextGameControls();
                        String GameName = myFrame.getCreateGamePanel().getTextName();


                        if (mapSize != 0 && !controls.equals("")) {


                            method.createGame(controls, GameName, mapSize);


                            JOptionPane.showMessageDialog(myFrame, "Game Created! Your game ID is :");
                            myFrame.show(myFrame.MENU);

                        } else {
                            JOptionPane.showMessageDialog(myFrame, "Game was not created");
                        }


                    }else if (event.getSource() == myFrame.getCreateGamePanel().getBtnBack()) {

                        myFrame.show(myFrame.MENU);
                    }

                }
            }


        }





















