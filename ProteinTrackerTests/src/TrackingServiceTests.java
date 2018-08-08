import org.junit.Test;

import com.simpleprogrammer.proteintracker.InvalidGoalException;
import com.simpleprogrammer.proteintracker.TrackingService;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;


public class TrackingServiceTests {

	private TrackingService service;
	@BeforeClass
	public static void before() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After Class");
		
	}
	
	@Before
	public void setUp() {
		System.out.println("Before");
		service = new TrackingService();
	}
	
	@Before
	public void setup() {
		System.out.println("Before");
		service= new TrackingService();
	}
	
	@After
	public void tearDown() {
		System.out.println("After");
	}
	
	@Test
	public void NewTrackingServiceTotalIsZero() {
		TrackingService service= new TrackingService();
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Ignore
	public void WhenAddingProteinTotalIncreasesByThatAmount() {
		TrackingService service = new TrackingService();
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	
	@Test
	public void WhenRemovingProteinTotalRemainZero() {
		service.removeProteint(5);
		assertEquals(0,service.getTotal());
	}
	
	@Test(expected = InvalidGoalException.class)
	public void WhenGoalIsSetToLessThanZeroExeptionIsThrow() throws InvalidGoalException
	{
		service.setGoal(-5);
	}
	
	@Test(timeout = 200)
	public void BadTest() {
		for(int i=0; i<10000000; i++)
			service.addProtein(1);
	}
	
}
