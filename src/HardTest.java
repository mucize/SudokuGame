import static org.junit.Assert.*;

import org.junit.Test;


public class HardTest {   // Hard zorluk seviyesini test eder.

	@Test
	public void testLevel() {
		assertEquals(55,new Hard().level());
	}

}
