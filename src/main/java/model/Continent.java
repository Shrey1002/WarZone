package model;
import java.util.ArrayList;

/**
 * This Class is for all the Continents  of the Map
 */
public class Continent {
    private static int D_Count=0;
	private int d_ID;
	private String d_Name;
	private int d_ContinentControlValue;
	private ArrayList<Country> d_CountryList;


    /**
	 * This is the Constructor of the class which stores the ID  Name and ContinentControl Value to that Continent Object
	 * It also initializes the CountryList which later stores all the countries belonging to that particular continent
	 * @param p_Name Name of the Continent
	 * @param p_ContinentControlValue Integer representing the ContinentControl Value
	 */

	public Continent(String p_Name, int p_ContinentControlValue) {
		setContinentID(++D_Count);
		this.d_Name=p_Name;
		this.d_ContinentControlValue=p_ContinentControlValue;
		d_CountryList = new ArrayList<Country>();
	}

    /**
	 * Method to set Continent ID
	 * @param p_ContinentID ID of the continent
	 */
	public void setContinentID(int p_ContinentID) {
		d_ID = p_ContinentID;
	}
    
}
