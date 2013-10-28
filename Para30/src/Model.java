public class Model {
	int mid;
	int vid;
	String model;
	int price;

	public Model(int mid, int vid, String model, int price) {
		this.mid = mid;
		this.vid = vid;
		this.model = model;
		this.price = price;
	}

	@Override
	public String toString() {
		return (this.mid + " " + this.vid + " " + this.model + " " + this.price);
	}

}
