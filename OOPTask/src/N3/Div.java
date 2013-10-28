package N3;

public class Div extends Expression{
	
	public Div(Expression e1, Expression e2) {
		int max = e1.getVar().length + e2.getVar().length; 
		int[] a = new int[max];
		for(int i = 0; i < e1.getVar().length; i++){
			for(int j = 0; j < e2.getVar().length; j++){
				if(e2.getVar()[j] != 0){
					a[Math.abs(i - j)] = e1.getVar()[i] / e2.getVar()[j] + a[i + j];
				}
			}
		}
		char m = e1.getVarX()==' ' ? e2.getVarX() : e1.getVarX();
		super.setVar(a, m);
	}

	public Div() {
		// TODO Auto-generated constructor stub
	}
	
}
