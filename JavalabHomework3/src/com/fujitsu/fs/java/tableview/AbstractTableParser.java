package com.fujitsu.fs.java.tableview;

import java.io.*;
import java.util.*;

/**
 * 
 * @author rom16rus
 * 
 */
public abstract class AbstractTableParser implements TableParser {

	public String[][] parse(String path) throws NotCorrectFormException {
		return parse(new File(path));
	}

	public String[][] parse(File file) throws NotCorrectFormException {
		String content = readFile(file);
		if (content.trim().equals("")) {
			return new String[][] {};
		}

		String[] rows = content.split("\n");

		int columnsCount = parseRow(rows[0]).length;
		// String[] firstTableRow = rows[0].split(",");
		// int columnsCount = firstTableRow.length;

		String[][] table = new String[rows.length][columnsCount];

		for (int i = 0; i < rows.length; i++) {
			String[] columns = parseRow(rows[i]);
			if (columns.length != columnsCount) {
				// TODO: throw format error
			}
			for (int j = 0; j < columns.length; j++) {
				table[i][j] = columns[j];
			}
		}

		return table;
	}

	protected abstract String[] parseRow(String row);

	/**
	 * Reads the specified file and returns it's content as String.
	 * 
	 * Returns an empty String if file does not exist could not be read.
	 * 
	 * @param file
	 *            the file to read
	 * 
	 * @return the content or empty string if error occurs
	 */
	protected String readFile(File file) {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file)));
		} catch (IOException e) {
			System.err.println("Error in reading file");
			e.printStackTrace();
			return "";
		}
		StringBuffer sb = new StringBuffer();
		String s;
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.err.println("Error in reading file");
			e.printStackTrace();
			return "";
		}
		while (s != null) {
			sb.append(s + "\n");
			try {
				s = br.readLine();
			} catch (IOException e) {
				System.err.println("Error in reading file");
				e.printStackTrace();
				return "";
			}
		}
		return sb.toString();

	}

	protected static String killingquot(String s) {
		if (s.length() < 1) {
			return s;
		}
		String s1 = s;

		if (s1.charAt(0) == '\'' && s1.charAt(s.length() - 1) == '\''
				|| s1.charAt(0) == '"' && s1.charAt(s.length() - 1) == '"') {
			s1 = s1.substring(1, s1.length() - 1);
		} else {
			s1 = s1.trim();
		}
		return s1;
	}
}
