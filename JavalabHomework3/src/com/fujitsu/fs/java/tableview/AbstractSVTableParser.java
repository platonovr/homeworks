package com.fujitsu.fs.java.tableview;

import java.util.*;

/**
 * 
 * @author rom16rus
 *
 */
public abstract class AbstractSVTableParser extends AbstractTableParser {

	protected char ch;

	@Override
	protected String[] parseRow(String row) {
		// TODO Auto-generated method stub

		LinkedList<String> list = new LinkedList<String>();
		boolean flag1 = false;
		boolean flag2 = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row.length(); i++) {
			char c = row.charAt(i);
			if (c == ch && !flag1 && !flag2) {
				String s = sb.toString();
				list.add(killingquot(s));
				sb = new StringBuilder();
			} else if (c == '"') {
				if (flag2 == false) {
					flag1 = !flag1;
				}
				sb.append(c);
			} else if (c == '\\' && i != row.length() - 1) {
				i++;
				c = row.charAt(i);
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
		String[] array = new String[list.size()];
		array = list.toArray(array);
		return array;
	}
}
