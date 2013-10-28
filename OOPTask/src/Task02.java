/**
 * 
 * @author Platonov Roman 
 * @group 11-2101
 * Task 2
 * Geometry
 * 
 */
import java.util.Arrays;

class Point {
	int x, y, z;

	public Point(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String toString() {
		return "Tочка с координатами " + " x:" + x + ";" + "y:" + y + ";"
				+ "z:" + z;

	}

}

class Segment {
	Point p1;
	Point p2;

	public Segment(Point p12, Point p22) {
		p1 = p12;
		p2 = p22;
	}

	public double length() {
		return Math.sqrt((p2.getX() - p1.getX()) * (p2.getX() - p1.getX())
				+ (p2.getY() - p1.getY()) * (p2.getY() - p1.getY())
				+ (p2.getZ() - p1.getZ()) * (p2.getZ() - p1.getZ()));
	}

	public String toString() {
		return ("Прямая с точками , координаты которых: " + "(" + p1.getX()
				+ "," + p1.getY() + "," + p1.getZ() + ")" + "&& " + "("
				+ p2.getX() + "," + p2.getY() + "," + p2.getZ() + ")");
	}

}

class Triangle {
	Segment[] t;

	public Triangle(Segment s11, Segment s22, Segment s33) {
		t = new Segment[3];
		t[0] = s11;
		t[1] = s22;
		t[2] = s33;
	}

	public double perimetr() {
		return t[0].length() + t[1].length() + t[2].length();
	}

	public boolean isTriangle() {
		if (((t[0].length() + t[1].length()) > t[2].length())
				&& ((t[0].length() + t[2].length()) > t[1].length())
				&& ((t[1].length() + t[2].length()) > t[0].length())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Треугольник со сторонами: " + t[0].length() + " "
				+ t[1].length() + " " + t[2].length();
	}

}

class Tetrahedron {
	Triangle[] tet;

	public Tetrahedron(Triangle t1, Triangle t2, Triangle t3, Triangle t4) {
		tet = new Triangle[4];
		tet[0] = t1;
		tet[1] = t2;
		tet[2] = t3;
		tet[3] = t4;
	}

	public String toString() {
		return "Тетраэдр с треугольниками периметров:" + tet[0].perimetr()
				+ " " + tet[1].perimetr() + " " + tet[2].perimetr() + " "
				+ tet[3].perimetr();
	}

}

public class Task02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point(1, 1, 1);
		Point point2 = new Point(-1, -1, 1);
		Point point3 = new Point(-1, 1, -1);
		Point point4 = new Point(1, -1, -1);
		System.out.println(point1.toString());
		Segment segment1 = new Segment(point1, point2);
		Segment segment2 = new Segment(point2, point3);
		Segment segment3 = new Segment(point3, point4);
		Segment segment4 = new Segment(point4, point1);
		Segment segment5 = new Segment(point2, point4);
		Segment segment6 = new Segment(point1, point3);
		System.out.println(segment2.toString());
		Triangle t1 = new Triangle(segment1, segment2, segment3);
		Triangle t2 = new Triangle(segment2, segment3, segment4);
		Triangle t3 = new Triangle(segment1, segment4, segment2);
		Triangle t4 = new Triangle(segment1, segment4, segment3);
		System.out.println(t1.toString());
		if (t1.isTriangle() && t2.isTriangle() && t3.isTriangle()
				&& t4.isTriangle()) {
			Tetrahedron tetrahedron1 = new Tetrahedron(t1, t2, t3, t4);
			System.out.println(tetrahedron1.toString());
		} else
			System.out.println("Неправильные данные");
	}
}
