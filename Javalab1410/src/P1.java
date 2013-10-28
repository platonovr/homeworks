//Author: Kuntsevich Alexander

import java.io.File;
import java.io.FileNotFoundException;

public class P1 {
	public static void main(String[] args) throws FileNotFoundException {
		// There must be no spaces between quotes and commas!!!
		File file = new File("file.csv");

		// Creates a new Parser object
		Task parser = new Task(file);

		// Prints the table
		// Shows it in console
		parser.print();
	}
}
