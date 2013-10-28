package N3;

public class Mul extends Expression{
	
	public Mul(Expression e1, Expression e2) {
		int max = e1.getVar().length + e2.getVar().length - 1; 
		int[] a = new int[max];
		for(int i = 0; i < e1.getVar().length; i++){
			for(int j = 0; j < e2.getVar().length; j++){
				a[i + j] = e1.getVar()[i] * e2.getVar()[j] + a[i + j];
			}
		}
		char m = e1.getVarX()==' ' ? e2.getVarX() : e1.getVarX();
		super.setVar(a, m);
	}

	public Mul() {
		// TODO Auto-generated constructor stub
	}
	
}
