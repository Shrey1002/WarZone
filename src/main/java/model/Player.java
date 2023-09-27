package model;



public class Player {

    private String d_PlayerName="";
    private GameModelNew d_GameModelNew;
    private int d_PlayerId;
	private String d_PlayerColor = "";

    
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
}
