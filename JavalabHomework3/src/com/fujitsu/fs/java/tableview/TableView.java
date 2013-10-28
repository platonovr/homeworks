package com.fujitsu.fs.java.tableview;

import java.util.Scanner;

/**
 * 
 * @author rom16rus
 * 
 */
public class TableView {

	/**
	 * The default column width for a table printed.
	 */
	public static int COLUMN_WIDHT = 32;

	public static void main(String[] args) {
		String path;
		TableParser tp;
		if (args.length == 0) {
			System.out.println("Please,input path to file");
			Scanner sc = new Scanner(System.in);
			path = sc.nextLine();
		} else {
			path = args[0];
		}

		if (path.substring(path.lastIndexOf('.') + 1).equals("csv")) {
			tp = new CSVTableParser();
		} else if (path.substring(path.lastIndexOf('.') + 1).equals("tsv")) {
			tp = new TSVParser();
		} else {
			System.out.println("not correct file");
			return;
		}
		String[][] table;
		try {
			table = tp.parse(path);
		} catch (NotCorrectFormException e) {
			System.err.println("Error of parsing");
			e.printStackTrace();
			return;
		}

		for (int row = 0; row < table.length; row++) {
			System.out.print("|");
			for (int column = 0; column < table[row].length; column++) {
				String cell = table[row][column];
				System.out.print(cell);
				for (int pos = cell.length(); pos < COLUMN_WIDHT; pos++) {
					System.out.print(" ");
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
}
