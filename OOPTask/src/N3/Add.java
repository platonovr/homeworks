package N3;

public class Add extends Expression{
	

	public Add(Expression e1, Expression e2) {
		int indMax = 2;
		if(e1.getVar().length > e2.getVar().length){//находим Expression с наиб-й степенью
			indMax = 1;
		}
		int min, max;
		int[] a;
		if(indMax == 1){
			max = e1.getVar().length;
			min = e2.getVar().length;
			a = new int[max];
			for(int i = 0; i < min; i++){
				a[i] = e1.getVar()[i] + e2.getVar()[i];
			}
			for(int i = min; i < max; i++){
				a[i] = e1.getVar()[i];
			}
		} else {
			max = e2.getVar().length;
			min = e1.getVar().length;
			a = new int[max];
			for(int i = 0; i < min; i++){
				a[i] = e1.getVar()[i] + e2.getVar()[i];
			}
			for(int i = min; i < max; i++){
				a[i] = e2.getVar()[i];
			}
		}
		char m = e1.getVarX()==' ' ? e2.getVarX() : e1.getVarX();
		super.setVar(a, m);
	}

	public Add() {
		// TODO Auto-generated constructor stub
	}
	
	
}
