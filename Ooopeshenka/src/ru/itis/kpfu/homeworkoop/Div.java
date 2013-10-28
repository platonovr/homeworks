package ru.itis.kpfu.homeworkoop;

public class Div extends Expression {

	public Div(Expression e1, Expression e2) {
		int max = e1.getVariable().length + e2.getVariable().length;
		int[] array = new int[max];
		for (int i = 0; i < e1.getVariable().length; i++) {
			for (int j = 0; j < e2.getVariable().length; j++) {
				if (e2.getVariable()[j] != 0) {
					array[Math.abs(i - j)] = e1.getVariable()[i]
							/ e2.getVariable()[j] - array[i - j + 1];
				}
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

	public Div() {
		// TODO Auto-generated constructor stub
	}
}
