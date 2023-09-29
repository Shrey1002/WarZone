package controller;
import java.util.ArrayList;				
import java.util.HashMap;
import java.util.Iterator;				
import java.util.Map.Entry;
import java.util.Set;					
import javax.swing.JOptionPane;
import model.GameModelNew;	
import model.Order;
import model.Player;		
import view.CommandPrompt;

/**
 * The Player Controller class controls the activities of all the players at once.
 */
public class PlayerController {
    private ArrayList <Player> d_Players;
	private String d_OrderAcknowledgment="";
	private CommandPrompt d_CpView;
	private GameModelNew d_GameModelNew;
	/**
	 * Constructor of Player controller
	 * @param p_Players list of players 
	 * @param p_CpView object of command prompt for communicating with player
	 */
	PlayerController(GameModelNew p_GameModelNew,CommandPrompt p_CpView) {
		d_GameModelNew = p_GameModelNew;
		d_Players = d_GameModelNew.getAllPlayers();
		d_CpView=p_CpView;
	}

	/**
	 * The player_issue_order method asks each player to issue an order in a round robin fashion.
	 * The loop terminates when the armies of all the players are exhausted.
	 * The acknowledgement are passed on to the view.
	 */
	public void playerIssueOrder() {
		ArrayList <Player> l_Players = d_Players;
		HashMap <Player,Boolean> l_CheckArmies = new HashMap<>();
		for(Player l_TempPlayer:l_Players) {
			l_CheckArmies.put(l_TempPlayer,false);
		}
		int l_PlayerListSize = l_Players.size();	
		while(l_PlayerListSize>0)	{
			Iterator<Player>l_It = l_Players.iterator();
			while(l_It.hasNext()) {
				Player l_Player = (Player)l_It.next(); 
				if(l_Player.getPlayerArmies()>0) {
					d_OrderAcknowledgment = "\n"+l_Player.getPlayerName()+" Enter deploy order";
					d_CpView.setCommandAcknowledgement(d_OrderAcknowledgment);
					String l_StringOrder = JOptionPane.showInputDialog(l_Player.getPlayerName()+" : Please Enter Your Deploy Order");
					l_Player.setOrder(l_StringOrder);
					l_Player.issue_order();
					String l_Result = l_Player.getResult();
					int l_ResultInteger = l_Player.getResultInteger();
					d_OrderAcknowledgment=l_Result;
					d_CpView.setCommandAcknowledgement(d_OrderAcknowledgment);
				} else {
					Set<Entry<Player,Boolean>> l_Check = l_CheckArmies.entrySet();
					for(Entry<Player,Boolean> l_E :l_Check){
						if(l_E.getKey().getPlayerArmies()==0 && l_E.getValue()==false){
							--l_PlayerListSize;
							l_E.setValue(true);
						}
					}
				}
			}
		}
	} 
}
