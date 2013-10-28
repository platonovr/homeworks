import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextFixtures {
	@BeforeClass
	public static void initSomething() {
		System.out.println("Initialization...");
	}

	@Before
	public void requestTestCaseStatus() {
		System.out.println("safsa");
	}

	@Test
	public void testSomething() {
		assertTrue("true is false", true);
	}

	@Test
	public void testSomething2() {
		assertTrue("true is false", true);
	}

}
