package N3;

public class Test {

	public static void main(String[] args) {

		Expression e = new Add(new Number(1), new Variable('x'));
		System.out.println(e.show());

		e = new Sub(new Number(3), new Variable('x'));
		System.out.println(e.show());

		Expression e3 = new Div(e, new Variable('x'));
		System.out.println(e3.show());

	}

}
