package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import model.Town;

/**
 * Test class for RailroadManager
 * 
 * @author alejandro perez
 *
 */
public class RailroadManagerTest {

	
	private static final Town TOWN_A = Town.valueOf("A");
	private static final Town TOWN_B = Town.valueOf("B");
	private static final Town TOWN_C = Town.valueOf("C");
	private static final Town TOWN_D = Town.valueOf("D");
	private static final Town TOWN_E = Town.valueOf("E");
	
	private Random rnd = new Random();
	
	
	@Test (expected = IllegalArgumentException.class)
	public void getDistanceRoute_nullParameter_IllegalArgumentExceptionThrown() {
		RailroadManager.getDistanceRoute(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getDistanceRoute_emptyList_IllegalArgumentExceptionThrown() {
		RailroadManager.getDistanceRoute(new ArrayList<>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getDistanceRoute_oneTown_IllegalArgumentExceptionThrown() {
		List<String> strList = new ArrayList<>();
		strList.add(TOWN_A.getName());
		RailroadManager.getDistanceRoute(strList);
	}
	
	@Test
	public void getDistanceRoute_example1_return9() {
		int expected = 9;
		List<String> strList = new ArrayList<>();
		strList.add(TOWN_A.getName());
		strList.add(TOWN_B.getName());
		strList.add(TOWN_C.getName());
		Assert.assertEquals(expected, RailroadManager.getDistanceRoute(strList));
	}
	
	@Test
	public void getDistanceRoute_example2_return5() {
		int expected = 5;
		List<String> strList = new ArrayList<>();
		strList.add(TOWN_A.getName());
		strList.add(TOWN_D.getName());
		Assert.assertEquals(expected, RailroadManager.getDistanceRoute(strList));
	}
	
	@Test
	public void getDistanceRoute_example3_return13() {
		int expected = 13;
		List<String> strList = new ArrayList<>();
		strList.add(TOWN_A.getName());
		strList.add(TOWN_D.getName());
		strList.add(TOWN_C.getName());
		Assert.assertEquals(expected, RailroadManager.getDistanceRoute(strList));
	}
	
	@Test
	public void getDistanceRoute_example4_return22() {
		int expected = 22;
		List<String> strList = new ArrayList<>();
		strList.add(TOWN_A.getName());
		strList.add(TOWN_E.getName());
		strList.add(TOWN_B.getName());
		strList.add(TOWN_C.getName());
		strList.add(TOWN_D.getName());
		Assert.assertEquals(expected, RailroadManager.getDistanceRoute(strList));
	}
	
	@Test
	public void getDistanceRoute_example5_noSuchRoute() {
		String expected = "NO SUCH ROUTE";
		List<String> strList = new ArrayList<>();
		strList.add(TOWN_A.getName());
		strList.add(TOWN_E.getName());
		strList.add(TOWN_D.getName());
		try{
			RailroadManager.getDistanceRoute(strList);
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(expected, ex.getMessage());
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getTotalRoutesFromTwoTowns_nullOrigin_IllegalArgumentExceptionThrown() {
		RailroadManager.getTotalRoutesFromTwoTowns(null, TOWN_B.getName());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getTotalRoutesFromTwoTowns_nullDestiny_IllegalArgumentExceptionThrown() {
		RailroadManager.getTotalRoutesFromTwoTowns(TOWN_A.getName(), null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getTotalRoutesFromTwoTowns_originEqualsDestiny_IllegalArgumentExceptionThrown() {
		RailroadManager.getTotalRoutesFromTwoTowns(TOWN_A.getName(), TOWN_A.getName());
	}
	
	@Test
	public void getTotalRoutesFromTwoTowns_fromAtoB_return4() {
		int expected = 4;
		Assert.assertEquals(expected,RailroadManager.getTotalRoutesFromTwoTowns(TOWN_A.getName(), TOWN_B.getName()));
	}
	
	@Test
	public void getTotalRoutesFromTwoTowns_fromBtoA_return0() {
		int expected = 0;
		Assert.assertEquals(expected,RailroadManager.getTotalRoutesFromTwoTowns(TOWN_B.getName(), TOWN_A.getName()));
	}
	
	@Test
	public void getTotalRoutesFromTwoTowns_random_returnValue() {
		String chars = "ABCDE";
		String originTown = "";
		String destinyTown = "";
		while (originTown.equals(destinyTown)) {
			originTown = String.valueOf(chars.charAt(rnd.nextInt(chars.length())));
			destinyTown = String.valueOf(chars.charAt(rnd.nextInt(chars.length())));
		}
		Assert.assertNotNull(RailroadManager.getTotalRoutesFromTwoTowns(originTown,destinyTown));
	}

	@Test (expected = IllegalArgumentException.class)
	public void getMinDistanceFromTwoTowns_nullOrigin_IllegalArgumentExceptionThrown() {
		RailroadManager.getShortestRouteFromTwoTowns(null, TOWN_B.getName());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getMinDistanceFromTwoTowns_nullDestiny_IllegalArgumentExceptionThrown() {
		RailroadManager.getShortestRouteFromTwoTowns(TOWN_A.getName(), null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getMinDistanceFromTwoTowns_originEqualsDestiny_IllegalArgumentExceptionThrown() {
		RailroadManager.getShortestRouteFromTwoTowns(TOWN_A.getName(), TOWN_A.getName());
	}

	@Test
	public void getMinDistanceFromTwoTowns_fromAtoB_returnAB() {
		String expected = "AB";
		Assert.assertEquals(expected,RailroadManager.getShortestRouteFromTwoTowns(TOWN_A.getName(), TOWN_B.getName()));
	}
	
	@Test
	public void getMinDistanceFromTwoTowns_fromBtoA_noSuchRoute() {
		String expected = "NO SUCH ROUTE";
		try{
			RailroadManager.getShortestRouteFromTwoTowns(TOWN_B.getName(), TOWN_A.getName());
		} catch (IllegalArgumentException ex) {
			Assert.assertEquals(expected, ex.getMessage());
		}
	}
	
	@Test
	public void getMinDistanceFromTwoTowns_fromAtoC_returnABC() {
		String expected = "ABC";
		Assert.assertEquals(expected,RailroadManager.getShortestRouteFromTwoTowns(TOWN_A.getName(), TOWN_C.getName()));
	}
	
	
	
}
