package SDK;

/**
 * Created by Greenmeister on 01/12/15.
 */

/**Creating class Gamer**/
public class Gamer extends User {

    /**creating variables**/
    private int score;
    private int totalScore;
    private int kills;
    private String controls;
    private boolean winner;

    /**creating get and set method to be used by controller **/

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setControls(String controls) {
        this.controls = controls;
    }

    public int getKills() {
        return kills;
    }

    public int getScore() {
        return score;
    }

    public String getControls() {
        return controls;
    }

}

