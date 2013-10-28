package com.fujitsu.homework.first;

import java.io.*;

/**
 * 
 * @author Roman Platonov
 * @group ITIS 11-2101
 * @task - to read and write the text file
 */
public class HomeTask {

	public static void main(String[] args) {
		try {
			File file1 = new File("input.txt");
			FileReader fr = new FileReader(file1);
			BufferedReader br = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter("output.txt");
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				pw.write(s);
			}
			br.close();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("done");
		}

	}

}
