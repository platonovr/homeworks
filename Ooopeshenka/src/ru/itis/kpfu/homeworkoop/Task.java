package ru.itis.kpfu.homeworkoop;

/**
 * 
 * @author Roman Platonov
 * @group 11-2101
 * @task L3T123
 * 
 */
public class Task {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Expression e = new Add(new Number(1), new Variable('x'));
		System.out.println("e:== " + e.show());
		Expression e1 = new Sub(new Number(3), new Variable('x'));
		System.out.println("e1:===" + e1.show());
		Expression esub = new Sub(e, e1);
		System.out.println("e-e1:===" + esub.show());
		Expression emul = new Mul(e, e1);
		System.out.println("e1*e:==" + emul.show());
		Expression ediv = new Div(e, e1);
		System.out.println("e1/e:===" + ediv.show());

		IExpression ediff = e.diff();
		System.out.println("e'===" + ediff.show());
		String input = "x+x*x+32+3+y*8";
		IExpression test = e1.Parse(input);
		
	}
}
