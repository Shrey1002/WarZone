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
        deploy();
    }

    /**
	 * This method sends the result after execution of execute method
	 * @return returns if the order is successfully executed or not.
	 */
	public String getExecuteResult() {
		return this.d_ExecuteResult;
	}
	/**
	 * This method is used to set the result after the execution of the execute method.
	 * @param p_ExecuteResult String to set the executed result
	 */
	public void setExecuteResult(String p_ExecuteResult) {
		this.d_ExecuteResult = p_ExecuteResult;
	}

    /**
	 * Method to check if the command issued is correct or not and set country name and the armies
	 */
	public void deploy() {
		String[] l_Splitted = d_Order.split(" ");
		if(l_Splitted[0].equals("deploy")) {
			this.d_CountryName = l_Splitted[1];
			this.d_NoOfArmies = Integer.parseInt(l_Splitted[2]);
		}
		else {
			System.out.println("Invalid command");
		}
	}

    /**
	 * This method returns the order of the player
	 * @return the order issues by the player
	 */
	public String getOrder() {
		return this.d_Order;
	}
}
