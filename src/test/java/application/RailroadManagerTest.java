package application;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import model.Town;

/**
 * Test class for RailroadManager
 * 
 * @author alexb
 *
 */
public class RailroadManagerTest {

	
	private static final Town TOWN_A = Town.valueOf("A");
	private static final Town TOWN_B = Town.valueOf("B");
	private static final Town TOWN_C = Town.valueOf("C");
	private static final Town TOWN_D = Town.valueOf("D");
	private static final Town TOWN_E = Town.valueOf("E");
	
	
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
	
}
