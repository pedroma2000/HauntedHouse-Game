package HauntedHouse.Menu;

import HauntedHouse.Generated;

/**
 *  Result class
 *
 * @author Pedro Machado "pedroma2000"
 */
public class Result implements Comparable {

    /**
     * The Player name
     */
    String playerName;

    /**
     * The Player points
     */
    int playerPoints;

    /**
     * Constructor
     * @param playerName the player name
     * @param playerPoints the player points
     */
    @Generated
    public Result(String playerName, int playerPoints) {
        this.playerName = playerName;
        this.playerPoints = playerPoints;
    }

    @Override
    public int compareTo(Object o) {
        try{
            Result tmp = (Result) o;
            if(this.playerPoints > tmp.playerPoints){
                return -1;
            } else if(this.playerPoints < tmp.playerPoints){
                return 1;
            }
           return 0;
        } catch (Exception e){
            throw new ClassCastException();
        }
    }
}
