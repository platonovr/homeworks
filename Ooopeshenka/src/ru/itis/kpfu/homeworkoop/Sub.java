package ru.itis.kpfu.homeworkoop;

public class Sub extends Expression {

	public Sub(Expression e1, Expression e2) {
		int maxPower = 2;
		if (e1.getVariable().length > e2.getVariable().length) {
			maxPower = 1;
		}
		int min;
		int max;
		int[] array;
		if (maxPower == 1) {
			max = e1.getVariable().length;
			min = e2.getVariable().length;
			array = new int[max];
			for (int i = 0; i < min; i++) {
				array[i] = e1.getVariable()[i] - e2.getVariable()[i];
			}
			for (int i = min; i < max; i++) {
				array[i] = e1.getVariable()[i];
			}
		} else {
			max = e2.getVariable().length;
			min = e1.getVariable().length;
			array = new int[max];
			for (int i = 0; i < min; i++) {
				array[i] = e1.getVariable()[i] - e2.getVariable()[i];
			}
			for (int i = min; i < max; i++) {
				array[i] = -e2.getVariable()[i];
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

	public Sub() {
		// TODO Auto-generated constructor stub
	}
}
