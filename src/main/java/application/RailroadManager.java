package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Route;
import model.Town;

/**
 * The railroad manager class
 * 
 * @author alejandro perez
 */
public final class RailroadManager {

	/**
	 * Exception messages
	 */
	private static final String TOWNS_NUMBER_EXCEPTION = "A route must be defined by at least two towns!";
	private static final String INVALID_ROUTE_EXCEPTION= "NO SUCH ROUTE";
	
	/**
	 * Private constructor, no need to be instantiated
	 */
	private RailroadManager() {
		
	}
	
	/**
	 * Method to get the total distance of a route through many towns (at least 2)
	 * 
	 * @param towns expected 2...n
	 * @return the totalDistance
	 */
	public static int getDistanceRoute(List<String> townsList) {
		int totalDistance = 0;
		
		if (townsList!=null && !townsList.isEmpty() && townsList.size()>1) {
			for (int i=1; i<townsList.size(); i++) {
				totalDistance += getDistance(townsList.get(i-1), townsList.get(i));
			}
			return totalDistance;
		} else {
			throw new IllegalArgumentException(TOWNS_NUMBER_EXCEPTION);
		}
		
	}
	
	/**
	 * @param origin Town
	 * @param destiny Town
	 * @return the distance between two towns directly connected
	 * @throws RailroadException 
	 */
	private static int getDistance(String origin, String destiny) {
		
		for (Route route:Town.valueOf(origin).getRoutesList()) {
			if (route.getDestiny().equals(destiny)) {
				return route.getDistance();
			}
		}
		
		throw new IllegalArgumentException(INVALID_ROUTE_EXCEPTION);
	}

	/**
	 * Method to get the total number of possible routes between 2 towns
	 * 
	 * @param towns expected 2...n
	 * @return the totalDistance
	 */
	public static int getTotalRoutesFromTwoTowns(String origin, String destiny) {
		int totalRoutes = 0;
		String travel = "";
		
		if (origin!=null && destiny!=null && !origin.equals(destiny)) {
			totalRoutes = countTotalRoutes(origin,destiny,travel,totalRoutes);
		} else {
			throw new IllegalArgumentException(TOWNS_NUMBER_EXCEPTION);
		}
		
		return totalRoutes;
	}
	
	/**
	 * Method to get the shortest route (travel) between 2 towns
	 * 
	 * @param towns expected 2...n
	 * @return the totalDistance
	 */
	public static String getShortestRouteFromTwoTowns(String origin, String destiny) {
		Map<String, Integer> travels = new HashMap<>();
		String travel = origin;
		
		if (origin!=null && destiny!=null && !origin.equals(destiny)) {
			getTravelsMap(origin,destiny,travel,travels);
		} else {
			throw new IllegalArgumentException(TOWNS_NUMBER_EXCEPTION);
		}
		if (travels.isEmpty()) {
			throw new IllegalArgumentException(INVALID_ROUTE_EXCEPTION);
		}
		Set<Entry<String,Integer>> entries = travels.entrySet();
		List<Entry<String,Integer>> sortedEntries = new ArrayList<>(entries);
		Collections.sort(sortedEntries, Comparator.comparing(Entry<String, Integer>::getValue));
		return sortedEntries.get(0).getKey();
	}
	
	/**
	 * Aimed to get the number of different routes
	 * Recursive method to guarantee that all possible routes are checked without enter in a infinite loop. 
	 * 
	 * @param origin
	 * @param destiny
	 * @param travel all the towns that the train has stopped at the moment
	 * @param totalRoutes the counter of total possible routes
	 * @return totalRoutes the counter of total possible routes
	 */
	private static int countTotalRoutes(String origin, String destiny, String travel, int totalRoutes) {
		for (Route route:Town.valueOf(origin).getRoutesList()) {
			if (route.getDestiny().equals(destiny)) {
				totalRoutes++;
			} else if (!travel.contains(route.getDestiny())) {  // we dont want to stop two times at the same town
				totalRoutes = countTotalRoutes(route.getDestiny(), destiny, travel+route.getDestiny(), totalRoutes);
			}
		}
		return totalRoutes;
	}
	
	/**
	 * Aimed to get all the possible routes with each distances
	 * Recursive method to guarantee that all possible routes are checked without enter in a infinite loop. 
	 * 
	 * @param origin
	 * @param destiny
	 * @param travel all the towns that the train has stopped at the moment
	 * @param travels the map of possible routes with its distance
	 * @return travels the map of possible routes with its distance
	 */
	private static Map<String, Integer> getTravelsMap(String origin, String destiny, String travel, Map<String, Integer> travels) {
		int distance = travels.get(travel)!=null?travels.get(travel):0;
		travels.remove(travel);
		for (Route route:Town.valueOf(origin).getRoutesList()) {
			if (!travel.contains(route.getDestiny())) { // we dont want to stop two times at the same town
				travels.put(travel + route.getDestiny(), distance + route.getDistance());
				if (!route.getDestiny().equals(destiny)) {
					getTravelsMap(route.getDestiny(), destiny, travel+route.getDestiny(), travels);
				}
			}
		}
		return travels;
	}
	
}
