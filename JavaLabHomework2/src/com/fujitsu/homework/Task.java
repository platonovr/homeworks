package com.fujitsu.homework;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Roman Platonov
 * @group ITIS 11-2101
 * @task - to make a console application
 */
public class Task {

	public static void main(String[] args) throws IOException {
		// user types a name of film
		String question = System.console().readLine(
				"enter the name of the film :");

		// pattern - to find a film by word in name
		Pattern p = Pattern.compile(question);
		System.out.println("Your request:" + question);
		// this is a directory of films
		File f1 = new File("films");
		// if we haven't this directory or it isn't a directory, we create it
		if (!f1.isDirectory() || !f1.exists()) {
			f1.mkdir();
		}
		// we get a list of names of files in directory
		String[] files = f1.list();
		boolean found = false;
		String file;
		for (int i = 0; i < files.length; i++) {
			file = f1.getPath() + "/" + files[i];
			File filmfile = new File(file);
			Scanner nsc = new Scanner(filmfile);
			boolean id = false;
			while (nsc.hasNext()) {
				// we find a request in files
				String info = nsc.nextLine();
				Matcher match = p.matcher(info);
				if (match.find()) {
					id = true;
					found = true;
				}
			}
			if (id) {
				Scanner sc2 = new Scanner(filmfile);
				String imdib = sc2.nextLine();
				String imdurl = sc2.nextLine();
				String genres = sc2.nextLine();
				String languages = sc2.nextLine();
				String country = sc2.nextLine();
				String rating = sc2.nextLine();
				String title = sc2.nextLine();
				String year = sc2.nextLine();
				System.out.println(title + " " + country + " " + year);

				sc2.close();

			}
			nsc.close();
		}
		if (!found) {
			System.out.println("Film not found, sorry");
		}

	}
}
