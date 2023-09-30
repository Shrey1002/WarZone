package model;

/**
 * 
 * Class for Order of the players
 *
 */
public class Order {
    
    private String d_Order;
    private String d_CountryName;
    private int d_NoOfArmies;
    private GameModelNew d_GameModelNew;
    private String d_ExecuteResult = "";

    public Order(String p_Order, GameModelNew p_GameModelNew) {
        this.d_Order = p_Order;
        this.d_GameModelNew = p_GameModelNew;
    }

}
