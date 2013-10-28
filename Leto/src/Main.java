import java.io.*;

/**
 * 
 * @author Roman Platonov
 * @group ITIS 11-2101
 * @task - to read and write the text file
 */
public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			File file1 = new File("input.txt");
			FileReader fr = new FileReader(file1);
			br = new BufferedReader(fr);
			pw = new PrintWriter("output.txt");
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				pw.write(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (br != null) {
					pw.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("done");
		}

	}
}
