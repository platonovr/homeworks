import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task {

	public static void main(String[] args) throws IOException {
		BufferedReader brv = new BufferedReader(new FileReader(new File(
				"vendors.txt")));
		BufferedReader brm = new BufferedReader(new FileReader(new File(
				"models.txt")));
		BufferedReader brs = new BufferedReader(new FileReader(new File(
				"shops.txt")));
		BufferedReader brsm = new BufferedReader(new FileReader(new File(
				"shopmodels.txt")));
		ArrayList<Vendor> vendors = new ArrayList<Vendor>();
		ArrayList<Model> models = new ArrayList<Model>();
		ArrayList<Shop> shops = new ArrayList<Shop>();
		ArrayList<ShopModel> shopmodels = new ArrayList<ShopModel>();
		String s;
		while (true) {
			s = brv.readLine();
			if (s == null)
				break;
			vendors.add(new Vendor(Integer.parseInt(s.split(" ")[0]), s
					.split(" ")[1]));
		}
		while (true) {
			s = brm.readLine();
			if (s == null)
				break;
			models.add(new Model(Integer.parseInt(s.split(" ")[0]), Integer
					.parseInt(s.split(" ")[1]), s.split(" ")[2], Integer
					.parseInt(s.split(" ")[3])));
		}
		while (true) {
			s = brs.readLine();
			if (s == null)
				break;
			shops.add(new Shop(Integer.parseInt(s.split(" ")[0]),
					s.split(" ")[1]));
		}
		while (true) {
			s = brsm.readLine();
			if (s == null)
				break;
			shopmodels.add(new ShopModel(Integer.parseInt(s.split(" ")[0]),
					(Integer.parseInt(s.split(" ")[1]))));
		}
		System.out.println(vendors.toString());
		System.out.println("===============");
		System.out.println(models.toString());
		Model[] a = new Model[vendors.size()];
		for (Model e : models) {
			if (a[e.vid - 1] == null || a[e.vid - 1].price < e.price) {
				a[e.vid - 1] = e;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
