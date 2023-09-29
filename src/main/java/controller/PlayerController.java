package controller;

import model.GameModelNew;
import view.CommandPrompt;

public class PlayerController {
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
    
}
