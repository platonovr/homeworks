package com.fujitsu.fs.java.tableview;

import java.io.File;

import org.junit.Test;

public class AbstractTableParserTest {
	@Test
	public void testReadFile() throws Exception {
		AbstractTableParser parser = new AbstractTableParser() {
			@Override
			protected String[] parseRow(String row) {
				return null;
			}
		};

		File lessonFile =
		// looks for lesson.csv in the same package
		new File(getClass().getResource("lesson.csv").toURI());
		// looks in a root
		// new File(getClass().getResource("/lesson.csv").toURI());
		// looks relative to root
		// new File(getClass().getResource("/com/fujitsu/lesson.csv").toURI());
		String content = parser.readFile(lessonFile);
		System.out.println(content);
	}

}
