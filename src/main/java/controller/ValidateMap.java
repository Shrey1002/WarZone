package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Continent;
import model.Country;

/**
 * This class checks the validity of the map by converting into a graph object. 
 */
public class ValidateMap {
    int d_VertexCount;
	ArrayList<ArrayList<Integer>> d_VertexList;

	/**
	 * This constructor of a class initialize the adjacency list representation of graph. 
	 * 
	 * @param p_VertexCount This is the size of which adjacency list will be created. 
	 */
	public ValidateMap(int p_VertexCount){
		d_VertexCount = p_VertexCount;
		d_VertexList = new ArrayList<>(d_VertexCount);
		for(int l_I=0;l_I<d_VertexCount;l_I++) {
			d_VertexList.add(new ArrayList<Integer>());
		}
	}

    /**
	 * This constructor receives country and continent objects and use them to add into adjacency list of graph. 
	 * 
	 * @param p_CountryObjects List of country objects stored in the map model. 
	 * @param p_ContinentObjects List of continent objects stored in the map model. 
	 * @throws Exception If any continent doesn't have a country, it notifies the user. 
	 */
	public ValidateMap(ArrayList<Country> p_CountryObjects,ArrayList<Continent> p_ContinentObjects) throws Exception{
		if(checkCountryAndContinent(p_CountryObjects,p_ContinentObjects)){
			checkContinentIsConnectedSubgraph(p_ContinentObjects);
			HashMap<Integer,ArrayList<Integer>> l_HMap;
			l_HMap = updateCount(p_CountryObjects);
			d_VertexCount = l_HMap.size();
			d_VertexList = new ArrayList<>(d_VertexCount);
			for(int l_I=0;l_I<d_VertexCount;l_I++) {
				d_VertexList.add(new ArrayList<Integer>());
			}
			assignBorders(l_HMap);
		}
		else{
			throw new Exception("There should be atleast one country for a continent");
		}
	}

    /**
	 * This method calls DFS for original graph and transposed graph. 
	 * 
	 * @return String "Map is Valid" if dfs is passed else "Map is not Valid"
	 */
	public String isValid() {
		boolean l_B1 = runDFS(0);
		ValidateMap l_TempMap = getTranspose(this.d_VertexList);
		boolean l_B2 = l_TempMap.runDFS(0);
		if(l_B1 && l_B2) {
			return "Map is Valid";
		}
		return "Map is not Valid";
	}

    /**
	 * This method returns true if graph is connected. 
	 * DFS starts from one index and try to reach every other index from there. 
	 * This is checked for all the index present in the graph. 
	 * 
	 * @param p_Start starting point of the DFS traversal.
	 * @return returns true if all countries are traversed from the starting point. false otherwise. 
	 */
	public boolean runDFS(int p_Start) {
		boolean[] l_NodeVisited = new boolean[d_VertexCount];
		markVisited(p_Start, l_NodeVisited);
		for(boolean l_B: l_NodeVisited) {
			if(!l_B)
				return false;
		}
		return true;
	}

    /**
	 * This method takes the transpose of the graph. 
	 * For Example : If there is a border between country 1 to 2, it will become 2 to 1 
	 * 
	 * @param p_VertexList list of vertices in the graph. (list of countries and their borders)
	 * @return new validate map object which holds the transposed vertex list. 
	 */
	public ValidateMap getTranspose(ArrayList<ArrayList<Integer>> p_VertexList) {
		ValidateMap l_TempMap = new ValidateMap(p_VertexList.size());
		for(int l_I=0;l_I<p_VertexList.size();l_I++) {
			for(int l_J : p_VertexList.get(l_I)) {
				l_TempMap.addBorder(l_J, l_I);
			}
		}
		return l_TempMap;
	}
}
