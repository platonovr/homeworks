/**
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Task {
	private Scanner in;
	private ArrayList<String> list;
	private String[][] str;

	// Constructor
	// Reads the file and writes strings into the ArrayList<String>
	// Defines what size the array should have
	// Creates the array
	Task(File file) throws FileNotFoundException {
		in = new Scanner(file);
		list = new ArrayList<>();
		int max = 0;
		int b = 0;
		while (in.hasNext()) {
			String s = in.nextLine();
			list.add(s);
			int a = 0;
			boolean f = true;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '"')
					f = !f;
				if ((s.charAt(i) == ',') && f)
					a++;
			}
			if (a > max)
				max = a;
			b++;
		}
		str = new String[b][max + 1];
	}

	// transfers strings from the list into the array
	// uses iterator to parse the list
	// uses split method to divide every string into parts
	private void toArray() {
		Iterator<String> it = list.iterator();
		int i = 0;
		while (it.hasNext()) {
			String s = it.next();
			split(s, i);
			i++;
		}
	}

	// divides the string into parts
	// and puts them into array
	private void split(String s, int i) {
		s = s + " ";
		int j = 0;
		int last = 0;
		boolean f = true;
		for (int k = 0; k < s.length(); k++) {
			if (s.charAt(k) == '"')
				f = !f;
			if (f && (s.charAt(k) == ',')) {
				str[i][j] = s.substring(last, k);
				j++;
				last = k + 1;
			}
		}
		str[i][j] = s.substring(last, s.length() - 1);
	}

	// removes quotes int the beginning and ending of the string
	private void cut() {
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				if (str[i][j] == null)
					str[i][j] = "";
				else {
					if (str[i][j].charAt(0) == '"') {
						str[i][j] = str[i][j].substring(1,
								str[i][j].length() - 1);
					}
				}
			}
		}
	}

	// adds spaces to the elements
	// so every element in the column has
	// the same amount of characters
	private void format() {
		int n = str[0].length;
		int[] max = new int[n];
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < str.length; i++) {
				int a = 0;
				if (str[i][j] != null)
					a = str[i][j].length();
				else
					str[i][j] = "";
				if (a > max[j])
					max[j] = a;
			}
		}
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				for (int k = str[i][j].length(); k < max[j]; k++) {
					str[i][j] += " ";
				}
			}
		}
	}

	// prints the array using methods toArray, cut, format
	public void print() {
		toArray();
		cut();
		format();
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				System.out.print(str[i][j] + "|");
			}
			System.out.println();
		}
	}

}
