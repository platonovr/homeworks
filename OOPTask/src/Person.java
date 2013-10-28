/**
 * 
 * @author Platonov Roman 
 * @group 11-2101
 * Task 1
 * L1T2
 * 
 */
public class Person {
	/*
	 * this is variables
	 */
	private String name;
	private String surname;
	private int year;
	/*
	 * this is constructor
	 */
	public Person(String name, String surname, int year) {
		super();
		this.name = name;
		this.surname = surname;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	/*
	 * this is method for display data of object
	 */
	public String toString() {
		return this.name + " " + this.surname + " " + this.year + " ";

	}

	public static void main(String[] args) {
		Person p1 = new Person("Andrew","Woods",1992);
		Person p2 = new Person("Alex","Smith",1983);
		System.out.println(p1);
		System.out.println(p2);

	}

}
