package com.fujitsu.fs.java.tableview;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class CSVTableParserTest extends Assert {

	/**
	 * The parser under test.
	 */
	private CSVTableParser parser = new CSVTableParser();

	@Test
	public void testParseRowSimple() {
		String row = "first,second,third";
		String[] expected = new String[] { "first", "second", "third" };
		assertArrayEquals(expected, parser.parseRow(row));
	}

	@Test
	public void testParseRowSpaces() {
		String row = "with spaces,second,third";
		String[] expected = new String[] { "with spaces", "second", "third" };
		assertArrayEquals(expected, parser.parseRow(row));
	}

	@Test
	public void testParseRowQuotedCommas() {
		assertArrayEquals(
				"Error parsing row with quoted cell value contains comma",
				new String[] { "February 19, 1997", "JDK 1.1",
						"JavaBeans, JDBC, RMI" },
				parser.parseRow("\"February 19, 1997\",JDK 1.1,\"JavaBeans, JDBC, RMI\""));
		assertArrayEquals(
				"Error parsing row with quoted cell value contains comma",
				new String[] { "February 19, 1997", "JDK 1.1",
						"JavaBeans, JDBC, RMI" },
				parser.parseRow("'February 19, 1997',JDK 1.1,'JavaBeans, JDBC, RMI'"));
	}

}
