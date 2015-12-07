package SDK;

import java.sql.Date;

/**
 * Created by Greenmeister on 01/12/15.
 */


/**Creating class Game**/

public class Game {

    /**creating variables**/

    private int gameId;
    private String name;
    private Gamer host;
    private Gamer opponent;
    private Date created;
    private int mapSize;

    public Game(){}

    /**creating get and set method to be used by controller **/

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }



    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getGameId(){
        return gameId;
    }

    public void setGameId(int gameId){
        this.gameId = gameId;
    }


    public void setHost(Gamer host){
        this.host = host;
    }



    public void setOpponent(Gamer opponent){
        this.opponent = opponent;
    }


}
