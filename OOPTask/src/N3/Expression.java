package N3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Expression implements IExpression {
	private char varX;// символ переменной
	private int[] var;// i яч - кол-во переменных(2*х) i-й степени

	public int getNum() {
		return var[0];
	}

	public int[] getVar() {
		return var;
	}

	public char getVarX() {
		return varX;
	}

	public void setVar(int[] var, char varX) {
		int count = var.length;
		this.var = new int[count];
		for (int i = 0; i < count; i++) {
			this.var[i] = var[i];
		}
		this.varX = varX;
	}

	@Override
	public IExpression diff() {
		for (int i = 1; i < this.var.length; i++) {
			this.var[i - 1] = this.var[i] * i;
		}
		return this;
	}

	@Override
	public String show() {
		String s = "";
		s += this.var[0] != 0 ? this.var[0] : "";
		for (int i = 1; i < this.var.length; i++) {
			if (this.var[i] != 0) {
				if (this.var[i] > 0) {
					s += "+";
					//s += (this.var[i] == 1 || this.var[i] == -1) ? ""
					//		: this.var[i];

					if(this.var[i]==1 || this.var[i]==-1){
						s=s+"";
					}
					else{
						s=s+this.var[i];
					}
				} else {
					//s += this.var[i] < -1 ? "" : "-";
					if(this.variable[i]<-1){
						s=s+"";
					}else{
						s=s+"-";
					}

					 s+= (this.var[i] == 1 || this.var[i] == -1) ? ""
							: this.var[i];
				}
				s += this.varX;
				s += i != 1 ? "^" + i : "";
			}
		}
		return s;
	}

	private boolean isOper(char c) {
		switch (c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
			return true;
		default:
			return false;
		}
	}

	private char inParse(String s) {
		char last = 0;

		Deque<Character> d = new ArrayDeque<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				i++;// переходим к след за ( символу
				String k = "";
				while (s.charAt(i) != ')') {
					k += s.charAt(i++);
				}
				last = inParse(k);
				i++;// переходим к след за ) символу
			}
			if (i == s.length()) {
				break;
			}
			if (s.charAt(i) == '*' || s.charAt(i) == '/') {
				d.addFirst(s.charAt(i));
			} else {
				d.addLast(s.charAt(i));
			}
		}
		if (d.isEmpty()) {
			return last;
		} else {
			return d.getLast();
		}
	}

	public IExpression Parse(String input) {
		char c;
		char last;
		String s = "";
		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i);
			if (isOper(c)) {
				s += c;
			}
		}
		last = inParse(s);
		switch (last) {
		case '+':
			System.out.println("add");
			return new Add();
		case '-':
			System.out.println("sub");
			return new Sub();
		case '*':
			System.out.println("mul");
			return new Mul();
		case '/':
			System.out.println("div");
			return new Div();
		}
		return null;
	}
}
