package model;

import java.io.File;			
import java.io.FileNotFoundException;
import java.io.FileWriter;		
import java.io.PrintWriter;		
import java.util.ArrayList;
import java.util.HashMap;		
import java.util.Iterator;
import java.util.Scanner;	
/**
 * This is the model class for the Map used in the game. 
 * This class consists of all the data members and behavior associated with Map. 
 * This class includes methods to add/remove continents, countries and borders as well as loadmap and savemap functionalities. 
 */
public class Map {

    private ArrayList<Country> d_CountryObjects; 
	private ArrayList<Continent> d_ContinentObjects;
	private HashMap<Integer,ArrayList<Integer>> d_Neighbors;
	private HashMap<Integer,Integer>d_PreviousSave;

	/**
	 * This is the default constructor of the class. 
	 * When the map object is created, this class initializes Continent, Countries and Neighbour containers
	 */
	public Map(){
		d_CountryObjects=new ArrayList<Country>();
		d_ContinentObjects=new ArrayList<Continent>();
		d_Neighbors=new HashMap<Integer,ArrayList<Integer>>();
		d_PreviousSave=new HashMap<Integer,Integer>();
	}

    	/**
	 * This method loads a map file given by the user.
	 * <ul>
	 * 	<li>This method checks for the input and decides if it is a loadmap or editmap functionality.</li>
	 *  <li>It gets the data from file and loads the map object in respective continent, countries and neighbors.</li>
	 *  <li>Before loading or editing any file, it resets the game model so that it doesn't conflict with the existing data in map model.</li>
	 * </ul>
	 * @param p_FileName Name of the file to Load
	 * @return Map is loaded or not
	 * @throws FileNotFoundException File not Found to Load 
	 */
	public String loadMap(String p_FileName) throws Exception {
		reset();
		String l_Path="resource\\",l_Result;
		int l_ControlValue,l_ContinentID=1;
		File l_File =new File(l_Path+p_FileName);
		Scanner l_Sc = new Scanner(l_File);
		while(l_Sc.hasNextLine()){
			String l_Line=l_Sc.nextLine();
			//searching for the continent keyword in file and loading all continents into continent object list
			if(l_Line.contains("continent")){	
				l_Line=l_Sc.nextLine();
				while(!l_Line.equals("") && l_Sc.hasNextLine()){
					String[] l_Arr = l_Line.split(" ", 3);
					l_ControlValue=Integer.parseInt(l_Arr[1]);
					this.d_ContinentObjects.add(new Continent(l_Arr[0],l_ControlValue));
					l_Line=l_Sc.nextLine();
				}
			}
			//searching for countries keyword and loading all countries from file to map's country object list
			if(l_Line.contains("countries")){
				l_Line=l_Sc.nextLine();
				while(!l_Line.equals("") && l_Sc.hasNextLine()){
					String[] l_Arr1=l_Line.split(" ",4);
					l_ContinentID=Integer.parseInt(l_Arr1[2]);
					String l_NeighborName="";
					for(Continent l_Continent : this.d_ContinentObjects) {
						if(l_Continent.getContinentID() == l_ContinentID) {
							l_NeighborName = l_Continent.getContinentName();
						}
					}
					Country l_TempCountry = new Country(l_Arr1[1],l_NeighborName);
					this.d_CountryObjects.add(l_TempCountry);
					for(Continent l_Continent :this. d_ContinentObjects) {
						if(l_Continent.getContinentID() == l_ContinentID) {
							l_Continent.addCountry(l_TempCountry);
						}
					}
					l_Line=l_Sc.nextLine();
				}
			}
			//searching for borders keyword and loading all neighbors from file to map's country object list
			if(l_Line.contains("borders")){
				while(!l_Line.equals("") && l_Sc.hasNextLine()){
					l_Line=l_Sc.nextLine();
					String[] l_Arr2=l_Line.split(" ");
					for(Country l_Tempcountry: this.d_CountryObjects){
						if (l_Tempcountry.d_ID==Integer.parseInt(l_Arr2[0])){
							ArrayList<Integer> l_Borders = new ArrayList<>();
							for(int l_K=1;l_K<l_Arr2.length;l_K++){
								for(Country l_TCountry: this.d_CountryObjects){
									if(l_TCountry.d_ID==Integer.parseInt(l_Arr2[l_K])){
										l_Tempcountry.setBorder(l_TCountry.d_Name);
									}
								}
								l_Borders.add(Integer.parseInt(l_Arr2[l_K]));
							}
							d_Neighbors.put(Integer.parseInt(l_Arr2[0]),l_Borders);
							break;
						}
					}
				}
			}
		}
		l_Sc.close();
		String l_Result1=validateMap();
		if(l_Result1.equals("Map is not Valid")){
			reset();
			return l_Result1;
		}
		l_Result="The Map is loaded with "+this.d_ContinentObjects.size()+" Continents and "+this.d_CountryObjects.size()+" Countries";
		return l_Result;
	}
}
