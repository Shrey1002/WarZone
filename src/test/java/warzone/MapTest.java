package model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.Continent;
import model.Country;

/**
 * To test the methods of Map.java 
 */
public class MapTest {
	Continent d_C0,d_C1;
	Country d_Country1,d_Country2,d_Country3,d_Country4,d_Country5;
	ArrayList<Country> d_Check;
	ArrayList<Continent> d_CheckContinent;
	Map d_Map;

	/**
	 * To set the context before each test case
	 * @throws Exception relevant for the map creation phase
	 */
	@Before
	public void setTestContext() throws Exception {
		d_C0 = new Continent("asia",0);
		d_C1 =  new Continent("africa",0);
		d_Country1 = new Country("india","asia");
		d_Country2 = new Country("china","asia");
		d_Country3 = new Country("japan","asia");
		d_Country4 = new Country("kenya","africa");
		d_Country5 = new Country("egypt","africa");
		d_Check =  new ArrayList<Country>();
		d_CheckContinent = new ArrayList<Continent>();
		d_Map = new Map();
		d_CheckContinent.add(d_C0);
		d_CheckContinent.add(d_C1);
		d_Check.add(d_Country1);
		d_Check.add(d_Country2);
		d_Check.add(d_Country3);
		d_Check.add(d_Country4);
		d_Check.add(d_Country5);
		d_Map.addContinent(d_C0.getContinentName(), "1");
		d_Map.addContinent(d_C1.getContinentName(), "1");
		d_Map.addCountry("india","asia");
		d_Map.addCountry("china","asia");
		d_Map.addCountry("japan","asia");
		d_Map.addCountry("kenya","africa");
		d_Map.addCountry("egypt","africa");
		d_Map.addBorder("egypt", "kenya");
		d_Map.addBorder("kenya", "japan");
		d_Map.addBorder("japan", "china");
		d_Map.addBorder("china", "india");
	}

    	/**
	 * This test checks the functionality of addCountry()
	 * 
	 */
	@Test 
	public void testAddCountry() {
		assertTrue(d_Map.getCountryList().contains(d_Country5));
	}

	/**
	 * This test checks the functionality of addCountry() to see if it adds a country to the continent that does not exists
	 */
	@Test 
	public void testAddCountryContinentNotExists() {
		String l_ExpectedMessage = "Continent Doesn't Exist to add a Country";
		String l_ActualMessage = "";
		try {
			d_Map.addCountry("brazil", "SA");
		} catch (Exception p_Exception) {
			l_ActualMessage = p_Exception.getMessage();
		}
		assertEquals(l_ExpectedMessage, l_ActualMessage);
	}

	/**
	 * This test checks the functionality of addCountry() to see if it catches exception thrown for country already exists
	 */
	@Test 
	public void testAddCountryCountryExists() {
		String l_ExpectedMessage = "Country Already Exist";
		String l_ActualMessage = "";
		try {
			d_Map.addCountry("egypt", "africa");
		} catch (Exception p_Exception) {
			l_ActualMessage = p_Exception.getMessage();
		}
		assertEquals(l_ExpectedMessage, l_ActualMessage);
	}
	
}