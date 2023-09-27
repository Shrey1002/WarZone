package model;
import java.util.ArrayList;

public class Player {
    private String d_PlayerName="";
    private GameModelNew d_GameModelNew;
    private int d_PlayerId;
	private String d_PlayerColor = "";
	private ArrayList<Country> d_Countries = new ArrayList<Country>();
	
    /**
	 * default constructor of Player class	
	 */
	public Player() {}
	/**
	 * constructor of Player class with only player name as the parameters
	 * @param p_PlayerName  Name of the player
	 */
	Player(String p_PlayerName, GameModelNew p_GameModelNew) {
		this.d_PlayerName = p_PlayerName;
		this.d_GameModelNew = p_GameModelNew;
	}
    /**
	 * constructor with player name, player id, and player color as parameters 
	 * @param p_PlayerName Name of the player
	 * @param p_PlayerId Id of the player
	 * @param p_PlayerColor color of the player
	 */
	Player(String p_PlayerName,int p_PlayerId,String p_PlayerColor) {
		d_PlayerName = p_PlayerName;
		d_PlayerId = p_PlayerId;
		d_PlayerColor = p_PlayerColor;
	}
	/**
	 * addCountry method adds the given country to the player's country list.
	 * @param p_Country country object
	 */
	public void addCountry(Country p_Country) {
		d_Countries.add(p_Country);
	}
	/**
	 * removeCountry removes the given country from the player's country list
	 * @param p_Country Name of the country to be removed
	 */
	public void removeCountry(Country p_Country) {
		d_Countries.remove(p_Country);
	}
	/**
	 * get method for player name
	 * @return returns player name
	 */
	public String getPlayerName() {
		return this.d_PlayerName;
	}
	/**
	 * get method for player id 
	 * @return returns player id
	 */
	public int getPlayerId() {
		return this.d_PlayerId;
	}

}
