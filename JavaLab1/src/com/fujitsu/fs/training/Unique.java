package com.fujitsu.fs.training;

import java.util.TreeSet;

public final class Unique {

	private Unique() {

	}

	public static TreeSet<String> parseString(String[] s) {
		TreeSet<String> ts = new TreeSet<String>();
		for (String e : s) {
			ts.add(e);
		}

		return ts;
	}

}
