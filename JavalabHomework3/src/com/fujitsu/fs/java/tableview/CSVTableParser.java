package com.fujitsu.fs.java.tableview;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author rom16rus
 * 
 */
public class CSVTableParser extends AbstractSVTableParser {

	/*
	 * protected String[] parseRow(String row) { return row.split(","); }
	 */
	public CSVTableParser() {
		this.ch = ',';
	}

	public static void main(String[] args) {
		String s = "\"September 30, 2004\", J2SE 5.0 ,\"Generics , Enumerators , Varargs\"";
		LinkedList<String> list = new LinkedList<String>();
		boolean flag1 = false;
		boolean flag2 = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ',' && !flag1 && !flag2) {
				String s2 = sb.toString();
				list.add(killingquot(s2));
				sb = new StringBuilder();
			} else if (c == '"') {
				if (flag2 == false) {
					flag1 = !flag1;
				}
				sb.append(c);
			} else if (c == '\\' && i != s.length() - 1) {
				i++;
				c = s.charAt(i);
				sb.append(c);
			} else if (c == '\'') {
				if (flag1 == false) {
					flag2 = !flag2;
				}
				sb.append(c);
			} else {
				sb.append(c);
			}
		}
		list.add(killingquot(sb.toString()));
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
