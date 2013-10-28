package N3;

public class Variable extends Expression{
	public Variable(char one) {
		super.setVar(new int[]{0,1},one);//1 переменная первой степени
	}
	
}
