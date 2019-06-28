package application;

import java.util.List;

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
	 * @return the distance between two towns
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

}
