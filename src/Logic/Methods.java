package Logic;

import GUI.MyFrame;
import SDK.*;
import com.google.gson.Gson;
import javax.swing.*;



/**
 * Created by Greenmeister on 04/12/15.
 */



    public class Methods {
        private ServerConnection con = new ServerConnection();
        private User LoggedInUser;
        private Gamer gamer;
        private MyFrame myFrame;


            public Methods() {}


    public void login(String username, String password) {


        LoggedInUser = new User();
        LoggedInUser.setPassword(password);
        LoggedInUser.setUsername(username);


        String json = new Gson().toJson(LoggedInUser);

        try {
            String response = con.post(json, "login/");
            LoggedInUser.setId(new Gson().fromJson(response.toString(), User.class).getUserid());


        } catch (Exception ex){

        }
    }




    public void joinGame(int gameID, String oppControls) {


        Gamer opponent = new Gamer();
        opponent.setId(LoggedInUser.getId());
        opponent.setControls(oppControls);

        Game game = new Game();
        game.setOpponent(opponent);
        game.setGameId(gameID);

        boolean joinGame = joinGame(game);

        if (joinGame) {


            startGame(game);
            //TODO : Start the game





        }
    }

    public boolean joinGame(Game game) {

        String json = new Gson().toJson(game, Game.class);

        try {

            con.put(json, "games/join/");
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(myFrame, "Game " + game.getGameId() + "not found",
                    "Error", JOptionPane.ERROR_MESSAGE);

            return false;

        }
        JOptionPane.showMessageDialog(myFrame, "Game " + game.getGameId() + " was joined");

             return true;

    }








    public  void createGame(String controls, String GameName, int mapSize) {


        Gamer host = new Gamer();
        host.setId(LoggedInUser.getId());
        host.setControls(controls);

        Game game = new Game();
        game.setName(GameName);
        game.setMapSize(mapSize);
        game.setHost(host);


        String json = new Gson().toJson(game);
        try {
            con.post(json, "games");


        } catch (Exception ex) {

        }

    }


    public boolean deleteGame(int gameId) {

        try {
            con.Delete("games/" + gameId);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(myFrame, "Game " + gameId + "not found",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(myFrame, "Game " + gameId + " was deleted");
        return true;
    }





}

