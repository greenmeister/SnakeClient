package Logic;

import GUI.MyFrame;
import SDK.*;
import com.google.gson.Gson;
import javax.swing.*;



/**
 * Created by Greenmeister on 04/12/15.
 */

/**Creating instances of the classes needed in the Class**/
    public class Methods {
    private ServerConnection con;
    private MyFrame myFrame;

    /**Creating instances of the objects*/
    public Methods() {
        con = new ServerConnection();
        myFrame = new MyFrame();

    }

    /**Method which gets the highscores from the server. Returns array of result. Sending the request to server via GET method**/
    public Score[] Highscore() {
        String response;
        try {
            response = con.get("scores/");
        } catch (Exception ex) {
            return null;
        }
        Score[] scores = new Gson().fromJson(response, Score[].class);
        return scores;
    }

    /**Deletes a game from server. Takes gameId as parameter which user has typed. That is handled in controller class
     * The game that corresponds to the ID will be deleted if found. Sending the request to server via DELETE method
     * @param gameId
     * @return true if deleted, false if not
     */
    public boolean deleteGame(int gameId) {

        try {
            con.delete("games/" + gameId);
        } catch (Exception ex) {

            /** Message dialog telling if game was not found**/
            JOptionPane.showMessageDialog(myFrame, "Game " + gameId + " not found",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        /**  message dialog telling if the game was deleted**/
        JOptionPane.showMessageDialog(myFrame, "Game " + gameId + " was deleted");
        return true;
    }

    /**Method that takes game object as parameter. Method tries to play a game. Sending the request to server via PUT method
     *
     * @param game
     * @return game if game was played, else null if not
     */
    public Game startGame(Game game) {

        String json = new Gson().toJson(game, Game.class);
        try {
            con.put(json, "games/start/");

            return game;

        } catch (Exception ex) {
            return null;
        }


    }

    /**Method that takes game object as parameter. Method tries to join the game of the ID that user has typed in and which is stored in game object
     *PUT method used for sending request to server
     * @param game
     * @return false if came could not be joined, returns true if game is joined
     */

    public boolean joinGame(Game game) {
        String json = new Gson().toJson(game, Game.class);

        try {
            con.put(json, "games/join/");
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /** Method that takes userId as parameter. Method gets a specific users games from the server. Sending the reqeust to server via GET method
     *
     * @param userId
     * @return null if there is an exception, else it returns game as an array. GameID, Created and Status of the game in teh array
     * is then extracted in CreatedGamesPanel to a table.
     */
    public Game[] myGames(int userId) {
        String response;
        try {
            response = con.get("games/" + userId);
        } catch (Exception ex) {
            return null;
        }
        Game[] game = new Gson().fromJson(response, Game[].class);
        return game;

    }

    /**Method that takes userId as parameter. Method gets a specific users scores from the server
     *sending the request to server via GET method
     * @param userId
     * @return null if there is an exception, else it returns gamer as an array. Winner and Score of the gamer array is then extracted. This is placed in a table in UserScoresPanel
     */

    public Score[] myScores(int userId) {
        String response;
        try {
            response = con.get("scores/" + userId);
        } catch (Exception ex) {
            return null;
        }
        Score[] scores = new Gson().fromJson(response, Score[].class);
        return scores;
    }

    /** Method that take game object as parameter. Method will try to create a game with the object. Sending the request to server via POST method
     *
     * @param game
     * @return false if game was not created. True if game was created.
     */
    public boolean CreateGame(Game game) {
        String json = new Gson().toJson(game, Game.class);

        try {
            con.post(json, "games/");
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}