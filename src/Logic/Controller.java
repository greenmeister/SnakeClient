package Logic;

import GUI.*;
import SDK.*;
import com.google.gson.Gson;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Class Controller - Handles ActionListeners in the client and a few methods
 *  Creating instances of the classes needed in controller and then initialising them in the constructor*
 */

public class Controller {


    private MyFrame myFrame;
    private ServerConnection con;
    private Methods method;
    private User LoggedInUser;


    public Controller() {

        /**Creating instances of the objects*/

        myFrame = new MyFrame();
        method = new Methods();
        con = new ServerConnection();
    }


/** This method injects the action listeners in the class. It is called in Main method when the Client starts*/

    public void run() {

        myFrame.getMenuPanel().addActionListener(new MenuPanelActionListener());
        myFrame.getLoginPanel().addActionListener(new LoginPanelActionListener());
        myFrame.getDeleteGamePanel().addActionListener(new DeleteGamePanelActionListener());
        myFrame.getHighScorePanel().addActionListener(new HighScorePanelActionListener());
        myFrame.getPlaySnakePanel().addActionListener(new PlaySnakePanelActionListener());
        myFrame.getJoinGamePanel().addActionListener(new JoinGamePanelActionListener());
        myFrame.getCreateGamePanel().addActionListener(new CreateGamePanelActionListener());
        myFrame.getCreatedGamesPanel().addActionListener(new CreatedGamesPanelActionListener());
        myFrame.getUserScoresPanel().addActionListener(new UserScoresPanelActionListener());

/**this line of code makes sure that the Login panel is the first that the user is presented too*/
    }


    /**
     * ActionListener for Login Panel. Contains Login method - Private Inner class
     */
    private class LoginPanelActionListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getLoginPanel().getBtnLogin()) {

                /**Reading the input from user */

                String username = myFrame.getLoginPanel().getTxtFieldUser().getText();
                String password = myFrame.getLoginPanel().getTxtFieldPw().getText();

                /**LoggedInUser is an object of the class user. users Password & Username is stored in the object*/
                LoggedInUser = new User();
                LoggedInUser.setPassword(password);
                LoggedInUser.setUsername(username);


                /** Converts LoggedInUser to JSON format */
                String json = new Gson().toJson(LoggedInUser);

                /** the json string + the path is sent to ServerConnection which sends the data to server via the post request*/
                String response = con.post(json, "login/");

                /** This line of code sets the ID ,which is returned from server, to the LoggedInUser object
                 * without it, the Host/opponent ID will not set when you create/join game
                 */
                LoggedInUser.setId(new Gson().fromJson(response.toString(), User.class).getUserid());

                /** Message dialog the pops up if user had succesfully logged in.
                 * Clearing textfields in Login window, then showing MenuPanel
                 */
                JOptionPane.showMessageDialog(myFrame, "Successful Login");
                myFrame.getLoginPanel().getTxtFieldUser().setText("");
                myFrame.getLoginPanel().getTxtFieldPw().setText("");
                myFrame.show(myFrame.MENU);

            }

        }
    }


    /**
     * ActionListener for MenuPanel. - Private inner class
     **/
    private class MenuPanelActionListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            /**Showing Delete panel if user presses the button "Delete Game"**/
            if (event.getSource() == myFrame.getMenuPanel().getBtnDeleteGame()) {
                myFrame.show(myFrame.DELETE);


                /**Showing Highscore panel if user presses the button "Show highscores"**/
            } else if (event.getSource() == myFrame.getMenuPanel().getBtnHighscores()) {

                /**Creates an array of class Score called highScores which initialises HighScore method in Methods class**/

                Score[] highScores = method.Highscore();
                myFrame.getHighScorePanel();
                myFrame.show(MyFrame.HIGHSCORE);
                /**HighScoreTable method from HighScorePanel is then called, takes the highScores array as parameter and the
                 * highScoreTable method will populate the table with results
                 */
                myFrame.getHighScorePanel().highScoreTable(highScores);

                /**Logging out if users presses logout button**/
            } else if (event.getSource() == myFrame.getMenuPanel().getBtnLogout()) {

                myFrame.show(myFrame.LOGIN);
                /**Shows play menu if user presses Play snake button**/

            } else if (event.getSource() == myFrame.getMenuPanel().getBtnPlaySnake()) {

                myFrame.show(myFrame.PLAY);


            }

        }
    }

    /**
     * ActionListener for DeletePanel. - Private inner class
     **/
    private class DeleteGamePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            /** if user presses back button, user will be returned to MenuPanel**/
            if (event.getSource() == myFrame.getDeleteGamePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);

            }
            if (event.getSource() == myFrame.getDeleteGamePanel().getBtnDelete()) {
                try {
                    /**Reading input from user**/

                    int gameID = myFrame.getDeleteGamePanel().getGameID();

                    /**If game id is not 0 , the deleteGame method in Methods class will be initialised with gameID as parameter**/
                    if (gameID != 0) {


                        /**initialising boolean method in Methods class**/
                        method.deleteGame(gameID);
                    }
                    /** Catching exception if user types in something else than numbers for the gameId**/
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(myFrame, "ID Must consist of numbers",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * ActionListener for DeletePanel. - Private inner class
     **/
    private class HighScorePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {


            if (event.getSource() == myFrame.getHighScorePanel().getBtnBack()) {

                /**When user presses back button in HighScorePanel, the ClearHighscore method in highscorepanel is initialised**/

                myFrame.getHighScorePanel().clearHighscore();

                /**User is redirected back to MenuPanel**/

                myFrame.show(myFrame.MENU);
            }
        }
    }

    /**
     * ActionListener for DeletePanel. - Private inner class
     **/
    private class PlaySnakePanelActionListener implements ActionListener {

        /**
         * If user presses the How To Play button a MessageDialog appears telling the user how to play
         **/

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == myFrame.getPlaySnakePanel().getBtnHowToPlay()) {

                JOptionPane.showMessageDialog(myFrame, "Press W,A,S,D buttons to insert your game controls. \n" +
                        "W corresponds to one movement up with your snake \n" +
                        "A corresponds to one movement to the left with your snake.\n" +
                        "S corresponds to one movement down with you snake.\n" +
                        "D corresponds to one movement to the right with your snake \n" +
                        "Mapsize shall be a number");
            }

            /** if user presses Join Game button, JoinGamePanel is displayed**/
            if (event.getSource() == myFrame.getPlaySnakePanel().getBtnJoinGame()) {

                myFrame.show(myFrame.JOIN);

            }
            /** if user presses Create Game button, CreateGamePanel is displayed**/
            if (event.getSource() == myFrame.getPlaySnakePanel().getBtnCreateGame()) {

                myFrame.show(MyFrame.CREATE);

                /**if user presses Play Snake button, PlaySnakePanel is displayed**/
            } else if (event.getSource() == myFrame.getPlaySnakePanel().getBtnBack()) {

                myFrame.show(myFrame.MENU);


            } else if (event.getSource() == myFrame.getPlaySnakePanel().getbtnMyGames()) {

                /**if user presses My games button, Id from LoggedInUser will be extracted.
                 * An
                 */

                int userId = LoggedInUser.getId();

                /**Creates an array of class Game called games which initialises myGames method in Methods class
                 * takes the userId from LoggedInUser as parameter**/

                Game[] games = method.myGames(userId);
                myFrame.getCreatedGamesPanel();
                myFrame.show(MyFrame.MYGAMES);

                /**gamesTable method from CreatedGamesPanel is then called, takes the games array as parameter and the
                 * gamesTable method will populate the table with results
                 */

                myFrame.getCreatedGamesPanel().gamesTable(games);

            } else if (event.getSource() == myFrame.getPlaySnakePanel().getBtnMyScores()) {

                /**Creates an array of class Gamer called gamer which initialises myScores method in Methods class
                 * takes the userId from LoggedInUser as parameter**/

                int userId = LoggedInUser.getId();

                Score[] scores = method.myScores(userId);
                myFrame.getUserScoresPanel();
                myFrame.show(MyFrame.SCORES);

                /**scoresTable method from UserScoresPanel is then called, takes the gamer array as parameter and the
                 * scoresTable method will populate the table with results
                 */
                myFrame.getUserScoresPanel().scoresTable(scores);


            }

        }
    }
    /**
     * ActionListener for JoinGamePanel. - Private inner class
     **/
    private class JoinGamePanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == myFrame.getJoinGamePanel().getBtnJoinGame()) {


                try {
                    /**Reading the input from user */


                    int gameID = myFrame.getJoinGamePanel().getTextFieldGameID();
                    String oppControls = myFrame.getJoinGamePanel().getTextFieldOppControls();

                    if (gameID != 0) {

                    /** Creating object of class Gamer*/
                        Gamer opponent = new Gamer();

                        /** setting Id on the opponent object to the user that is logged in **/
                        opponent.setId(LoggedInUser.getId());
                        /**setting controls in the object from users input**/
                        opponent.setControls(oppControls);

                        /**Creating object of class Game**/
                        Game game = new Game();
                        /** Setting the Gamer object at opponent in game object**/
                        game.setOpponent(opponent);
                        /** Setting the gameId from users input**/
                        game.setGameId(gameID);

                        /** game object is sendt to the method JoinGame in methods class**/
                        boolean GameJoined = method.joinGame(game);

                        if (GameJoined) {

                            /** if GameJoined Returns true , the game object is then sent to startGame method in methods class**/


                            method.startGame(game);
                            /** If game was played a message dialog appears**/
                            JOptionPane.showMessageDialog(myFrame, "Game was played");
                            myFrame.show(MyFrame.MENU);

                        }

                    }
                        /**catching the exception if user types anything else then numbers for id*/
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(myFrame, "ID Must consist of numbers",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                /** if user presses button back user will be redirected back to PlaySnake Panel**/
            } else if (event.getSource() == myFrame.getJoinGamePanel().getBtnBack()) {


                myFrame.show(myFrame.PLAY);

            }
        }

    }
    /**
     * ActionListener for CreateGamePanel. - Private inner class
     **/

    private class CreateGamePanelActionListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getCreateGamePanel().getBtnCreate()) {

                try {

                    /**Reading the input from user */

                    int mapSize = myFrame.getCreateGamePanel().getTextMapSize();
                    String controls = myFrame.getCreateGamePanel().getTextGameControls();
                    String GameName = myFrame.getCreateGamePanel().getTextName();

                    /** if statement that makes sure user has typed a Id number thats not zero and no empty game controls**/
                    if (mapSize != 0 && !controls.equals("")) {

                        /**Creates object of Gamer class**/
                        Gamer host = new Gamer();
                        /**Setting the id in the object to correspond to the ID from that user that is logged in **/
                        host.setId(LoggedInUser.getId());
                        /**Setting controls in the object**/
                        host.setControls(controls);

                        /**Creating object of the class game**/
                        Game game = new Game();
                        /** Setting variables in the object**/
                        game.setName(GameName);
                        game.setMapSize(mapSize);
                        game.setHost(host);
                        /**Game object is then sent to to CreateGame method in Methods class**/

                        boolean GameCreated = method.CreateGame(game);


                        if (GameCreated) {
                            /**If CreateGame returns true a message dialog will be displayed**/

                            JOptionPane.showMessageDialog(myFrame, "Game Created!");
                            myFrame.show(myFrame.PLAY);

                        }

                        /** Catching the exception if user types anything else than number for mapsize**/
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(myFrame, "MapSize Must consist of numbers",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }


            } else if (event.getSource() == myFrame.getCreateGamePanel().getBtnBack()) {
                    /** If button back is pressed user is redirected back to PlaySnake Panel**/

                myFrame.show(myFrame.PLAY);
            }

        }
    }

    /**
     * ActionListener for CreatedGamesPanel - Private inner class
     **/

    private class CreatedGamesPanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getCreatedGamesPanel().getBtnBack()) {

                /**When user presses back button in CreatedGamesPanel, the ClearGamesTable method in CreatedGamesPanel is initialised**/


                myFrame.getCreatedGamesPanel().clearGamesTable();

                /**User is redirected back to PlaySnakePanel**/


                myFrame.show(myFrame.PLAY);
            }

        }
    }

    /**
     * ActionListener for UserScoresPanel - Private inner class
     **/

    private class UserScoresPanelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == myFrame.getUserScoresPanel().getBtnBack()) {

                /**When user presses back button in UserScoresPanel, the ClearScoresTable method in UserScoresPanel is initialised**/


                myFrame.getUserScoresPanel().clearScoresTable();

                /**User is redirected back to PlaySnakePanel**/

                myFrame.show(myFrame.PLAY);
            }

        }
    }

}


















