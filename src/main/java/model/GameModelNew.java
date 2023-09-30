package model;

import java.util.ArrayList;

public class GameModelNew {
    /**
     * Enumerator for all the game phases
     */
    public enum Phases {
        Startup, Reinforcement, IssueOrder, ExecuteOrder
    }

    private Phases d_gamePhase;
    private Map d_Map;
    private ArrayList<Player> d_PlayerList;

    /**
     * Default constructor which initializes map and player List
     */
    public GameModelNew() {
        this.d_Map = new Map();
        this.d_PlayerList = new ArrayList<Player>();
    }

    /**
     * This is a constructor of GameModel class which will initialize the Map and
     * set the gamePhase
     * 
     * @param intializing map parameter ,
     */
    public GameModelNew(Map d_map) {
        super();
        this.d_map = d_map;
        this.setGamePhase(Phases.Startup);
    }

    /**
     * get Method for map
     * 
     * @return returns map
     */
    public Map getMap() {
        return this.d_Map;
    }

    /**
     * This method used to get the game phases from enumuerator
     * 
     * @return d_gamePhase
     */
    public Phases getGamePhase() {
        return d_gamePhase;
    }

    /**
     * This method used to set phase of the game
     * 
     * @param gamePhase we have different phases like startup and reinforcement,
     */
    public void setGamePhase(Phases d_gamePhase) {
        this.d_gamePhase = d_gamePhase;
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
