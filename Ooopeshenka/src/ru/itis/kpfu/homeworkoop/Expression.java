package ru.itis.kpfu.homeworkoop;

import java.util.*;

public class Expression implements IExpression {

	private char variablesymbol;
	private int[] variable;

	public char getVariablesymbol() {
		return variablesymbol;
	}

	public int[] getVariable() {
		return variable;
	}

	public void setVariable(char variablesymbol, int[] variable) {
		int count = variable.length;
		this.variable = new int[count];
		for (int i = 0; i < count; i++) {
			this.variable[i] = variable[i];
		}
		this.variablesymbol = variablesymbol;
	}

	@Override
	public IExpression diff() {
		for (int i = 1; i < this.variable.length; i++) {
			this.variable[i - 1] = this.variable[i] * i;
			this.variable[i] = 0;
		}
		return this;
	}

	@Override
	public String show() {
		String s = "";
		if (this.variable[0] != 0) {
			s = s + this.variable[0];
		} else {
			s = s + "";
		}
		for (int i = 1; i < this.variable.length; i++) {
			if (this.variable[i] != 0) {
				if (this.variable[i] > 0) {
					s = s + "+";
					if (this.variable[i] == 1 || this.variable[i] == -1) {
						s = s + "";
					} else {
						s = s + this.variable[i];
					}
				} else {
					if (this.variable[i] < -1) {
						s = s + "";
					} else {
						s = s + "-";
					}
					if (this.variable[i] == 1 || this.variable[i] == -1) {
						s = s + "";
					} else {
						s = s + this.variable[i];
					}
				}
				s = s + this.variablesymbol;
				if (i != 1) {
					s = s + "^" + i;
				} else {
					s = s + "";
				}
			}
		}
		if (s == "") {
			s = s + 0;
		}
		return s;
	}

	public boolean isAction(char signal) {
		switch (signal) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
			return true;
		}
		return false;
	}

	private char inParse(String s) {
		char right = 0;

		Deque<Character> deque = new ArrayDeque<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				i++;
				String k = "";
				while (s.charAt(i) != ')') {
					k = k + s.charAt(i++);
				}
				right = inParse(k);
				i++;
			}
			if (i == s.length()) {
				break;
			}
			if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				deque.addFirst(s.charAt(i));
			} else {
				deque.addLast(s.charAt(i));
			}
		}
		if (deque.isEmpty()) {
			return right;
		} else {
			return deque.getLast();
		}
	}

	public IExpression Parse(String input) {
		char signal;
		char last;
		String s = "";
		for (int i = 0; i < input.length(); i++) {
			signal = input.charAt(i);
			if (isAction(signal)) {
				s = s + signal;
			}
		}
		last = inParse(s);
		switch (last) {
		case '+':
			System.out.println("Addition");
			return new Add();
		case '-':
			System.out.println("Substraction");
			return new Sub();
		case '*':
			System.out.println("Multiplication");
			return new Mul();
		case '/':
			System.out.println("Division");
			return new Div();
		}
		return null;
	}

}
