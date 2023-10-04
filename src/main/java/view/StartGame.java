package view;

import controller.GameEngine;
import model.GameModelNew;

/**
 * @author Abhishek Mavani
 * @version 1.0.1
 * @since 09/18/2023
 * Driver class for the game. It consist a single method main which
 *              is an entry point to the game.
 */
public class StartGame {

    /**
     * This main method is an entry point for the game.
     * It initialize the GameModel, GameView (i.e. CommandPrompt) and GameEngine.
     * Passes view and model in controller.
     * 
     *@param args default parameter for the main method which is not used
     *               anywhere in the game.
     */
    public static void main(String[] args) {
        GameModelNew l_GameModel = new GameModelNew();
        CommandPrompt l_CpView = new CommandPrompt();
        new GameEngine(l_CpView, l_GameModel);
    }

}
