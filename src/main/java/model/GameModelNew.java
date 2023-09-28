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
	 * @return d_PlayerList, ArrayList of all the available players from player class
	 */
	public ArrayList<Player> getAllPlayers() {
		return this.d_PlayerList;
	}

}
