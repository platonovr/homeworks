public class Vendor {

	int vid;
	String name;

	public Vendor(int vid, String name) {
		this.vid = vid;
		this.name = name;
	}

	@Override
	public String toString() {
		return (this.vid + " " + this.name);

	}

}
