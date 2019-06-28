package model;

import java.util.Arrays;
import java.util.List;


/**
 * Generates the railroad map, using the exercise example: Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
 */
public enum Town {

	A("A",Arrays.asList(new Route(5,"B"), new Route(5,"D"), new Route(7,"E"))),
	B("B",Arrays.asList(new Route(4,"C"))),
	C("C",Arrays.asList(new Route(8,"D"), new Route(2,"E"))),
	D("D",Arrays.asList(new Route(8,"C"), new Route(6,"E"))),
	E("E",Arrays.asList(new Route(3,"B")));
	
	private Town(String name, List<Route> routesList) {
		this.name = name;
		this.routesList = routesList;
	}
	
	private String name;
	private List<Route> routesList;
	
	public String getName() {
		return name;
	}
	public List<Route> getRoutesList() {
		return routesList;
	}
	
}
