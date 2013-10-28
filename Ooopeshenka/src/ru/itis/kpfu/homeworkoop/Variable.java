package ru.itis.kpfu.homeworkoop;

public class Variable extends Expression {
	public Variable(char name) {
		super.setVariable(name, new int[] { 0, 1 });
	}
}
