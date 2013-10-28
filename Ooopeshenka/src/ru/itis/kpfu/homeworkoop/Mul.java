package ru.itis.kpfu.homeworkoop;

public class Mul extends Expression {

	public Mul(Expression e1, Expression e2) {
		int max = e1.getVariable().length + e2.getVariable().length - 1;
		int[] array = new int[max];
		for (int i = 0; i < e1.getVariable().length; i++) {
			for (int j = 0; j < e2.getVariable().length; j++) {
				array[i + j] = e1.getVariable()[i] * e2.getVariable()[j] + array[i + j];
			}
		}
		char ch;
		if (e1.getVariablesymbol() == ' ') {
			ch = e2.getVariablesymbol();
		} else {
			ch = e1.getVariablesymbol();
		}
		super.setVariable(ch, array);
	}

	public Mul() {
		// TODO Auto-generated constructor stub
	}
}
