/**
 * Thread Runnable метод Run в котором реализуетсяя, что надо сделать метод Join
 * - подключаем еще один поток interrupt() - прерывем другой поток sleep(n) -
 * ожидает n секунд yield() - можно передать другим потокам wait notify
 * notifyAll
 * 
 * 
 * 
 * 
 * 
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class MyTh implements Runnable {
	int number;
	int array[][];

	MyTh(int num, int[][] a) {
		number = num;
		array = a;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rd = new Random();
		for (int i = 250 * (number); i < 250 * (number + 1); i++) {
			for (int j = 0; j < 1000; j++) {
				array[i][j] = rd.nextInt();
			}
		}
	}
}

class Task {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		PrintWriter pw = new PrintWriter("output.txt");

		int[][] arA = new int[1000][1000];
		Thread[] t = new Thread[4];
		for (int i = 0; i < 4; i++) {
			t[i] = new Thread(new MyTh(i, arA));
		}
		for (int i = 0; i < 4; i++) {
			t[i].start();
		}
		for (int i = 0; i < 4; i++) {
			t[i].join();
		}
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				pw.println("A[" + (i + 1) + "," + (j + 1) + "]:" + arA[i][j]);

			}
		}
		int[][] arB = new int[1000][1000];
		for (int i = 0; i < 4; i++) {
			t[i] = new Thread(new MyTh(i, arB));
		}
		for (int i = 0; i < 4; i++) {
			t[i].start();
		}
		for (int i = 0; i < 4; i++) {
			t[i].join();
		}
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				pw.println("B[" + (i + 1) + "," + (j + 1) + "]:" + arA[i][j]);

			}
		}
		pw.close();

	}
}