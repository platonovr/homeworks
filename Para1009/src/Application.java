import java.io.*;
import java.util.*;

public class Application {
	public void init() {
	}

	public void run() {
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.init();
		application.run();
		Scanner sc = new Scanner(System.in);
		int temperatureincelsi = sc.nextInt();
		double temperatureinfarengheit = temperatureincelsi * 1.8 + 32;

	}
}
