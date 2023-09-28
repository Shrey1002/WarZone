package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player {
    private String d_PlayerName="";
    private GameModelNew d_GameModelNew;
    private int d_PlayerId;
	private String d_PlayerColor = "";
	private ArrayList<Country> d_Countries = new ArrayList<Country>();
	private int d_Armies;
	private int d_TempArmies;
	private ArrayList<Continent> d_Continents = new ArrayList<Continent>();
	private String d_Result="";
	
	
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

	/**
	 * get method for player color
	 * @return returns player color
	 */
	public String getPlayerColor() {
		return this.d_PlayerColor;
	}

	/**
	 * set method for player id 
	 * @param p_PlayerId player id of player
	 */
	public void setPlayerId(int p_PlayerId) {
		this.d_PlayerId = p_PlayerId;
	}
	/**
	 * set method for player color
	 * @param p_PlayerColor Player Color of the player
	 */
	public void setPlayerColor(String p_PlayerColor) {
		this.d_PlayerColor = p_PlayerColor;
	}
	/**
	 * set method for allocating armies to player
	 * @param p_Armies Armies off the player
	 */
	public void setPlayerArmies(int p_Armies) {
		this.d_Armies = p_Armies;
		this.d_TempArmies = p_Armies;
	}
	/**
	 * get method for armies of player
	 * @return returns armies of players
	 */
	public int getPlayerArmies() {
		return this.d_Armies;
	}
	/**
	 * set Continent list for the player. It consists of only those continent objects whose all countries belong to this player.
	 */
	public void setContinentsList() {
		ArrayList <Continent> l_MapContinents = d_GameModelNew.getSelectedMap().getContinentList();
		for(Continent l_MapContinent : l_MapContinents) {
			int l_Flag=0;
			outerloop:
				for(Country l_CountryOfContinent : l_MapContinent.getCountryList()) {
					for(Country l_CountryOfPlayer: d_Countries) {
						if(!(l_CountryOfPlayer==l_CountryOfContinent)) {
							l_Flag =1;break outerloop;
						}
					}
				}
			if(l_Flag==0) {
				d_Continents.add(l_MapContinent);
			}
		}
	}
	/**
	 * get method for continent list of the player
	 * @return returns the list of continents
	 */
	public ArrayList<Continent> getContinentList() {
		return d_Continents;
	}

	/**
	 * The getResult return the result whether the order was added to the order list or not to the Player controller.
	 * @return returns the result of issue order
	 */
	public String getResult() {
		return this.d_Result;
	}
	/**
	 * set method for result of issue order
	 * @param p_Result the result after issuing an order
	 */
	public void setResult(String p_Result) {
		this.d_Result = p_Result;
	}

}
