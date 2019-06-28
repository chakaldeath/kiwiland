package model;

public class Route {
	
	private int distance;
	private String destiny;
	
	public Route(int distance, String destiny) {
		super();
		this.distance = distance;
		this.destiny = destiny;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	
}
