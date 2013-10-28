import static org.junit.Assert.*;

import org.junit.Assert.*;
import org.junit.Test;

public class ScannerTest {

	@Test
	public void testParserRow() {
		String row = "first,second,third";
		String[] expected = { "first,second,third" };
		String[] str = { "first,second,third" };
		assertArrayEquals(expected, str);
		

	}

}
