package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * This is the GameModelNew class of MVC model.
 * This class has a references of Models.
 * This class acts as an Data info for other controllers.
 */
public class GameModelNew {
    private Map d_Map;
	private Player d_PlayerID;
	private ArrayList<Player> d_PlayerList;
	private Queue<Player> d_PlayerQueue = new LinkedList<Player>();

    /**
     * Default constructor which initializes map and player List
     */
    public GameModelNew() {
        this.d_Map = new Map();
        this.d_PlayerList = new ArrayList<Player>();
    }

    /**
	 * This is parameterized constructor which takes Map parameter
	 * 
	 * @param p_Map parameter of map
	 */
	public GameModelNew(Map p_Map) {
		this.d_Map = p_Map;
		this.d_PlayerList = new ArrayList<Player>();
	}

    /**
     * get Method for map
     * 
     * @return returns map
     */
    public Map getMap() {
        return this.d_Map;
    }

    public void setMap(Map p_Map) {
		this.d_Map = p_Map;
	}

    /**
	 * get Method for PlayerID
	 * 
	 * @return returns PlayerID
	 */
	public Player getPlayerId1() {
		return this.d_PlayerID;
	}

	/**
	 * set method for player id
	 * 
	 * @param d_PlayerID player id of player
	 */
	public void setPlayerId(Player d_PlayerID) {
		this.d_PlayerID = d_PlayerID;
	}

    /**
     * this method will get all the players from the ArrayList
     * 
     * @return d_PlayerList, ArrayList of all the available players from player
     *         class
     */
    public ArrayList<Player> getAllPlayers() {
        return this.d_PlayerList;
    }

    /**
     * This method gets selected map.
     *
     * @return the selected map
     */
    public Map getSelectedMap() {
        return this.d_Map;
    }

    /**
     * This Method Adds the player based on user input from the command prompt.
     * 
     * @param p_PlayerName player name of player
     * @throws Exception if player size is more that country size or if player
     *                   already exists
     */
    public void addPlayer(String p_PlayerName) throws Exception {
        if ((d_PlayerList.size() >= getSelectedMap().getCountryList().size())) {
            throw new Exception("Reached Max Number of Players can be added to the game");
        }
        if (existDuplicatePlayer(p_PlayerName)) {
            throw new Exception("Please enter a differnt Player name as this name already exists");
        } else {
            Player l_PlayerObject = new Player(p_PlayerName, this);
            d_PlayerList.add(l_PlayerObject);
        }
    }

    /**
     * This method checks for duplicate players
     *
     * @param p_PlayerName Name of the player
     * @return boolean this returns boolean value based if player already exists or
     *         not
     */
    public boolean existDuplicatePlayer(String p_PlayerName) {
        for (Player l_Player : d_PlayerList)
            if (l_Player.getPlayerName().equalsIgnoreCase(p_PlayerName))
                return true;
        return false;
    }

    /**
     * This Method removes players
     * 
     * @param p_PlayerName Name of the player
     * @throws Exception if player is not found
     */
    public void removePlayer(String p_PlayerName) throws Exception {
        Player l_CurrentPlayer;
        boolean l_PlayerFound = false;
        for (Player l_Player : d_PlayerList) {
            l_CurrentPlayer = l_Player;
            if (l_CurrentPlayer.getPlayerName().equalsIgnoreCase(p_PlayerName)) {
                l_PlayerFound = true;
                d_PlayerList.remove(d_PlayerList.indexOf(l_Player));
            }
        }
        if (l_PlayerFound == false) {
            throw new Exception("This Player does not exists");
        }
    }
}
