/**
 * dir1 dir2
 * до нажатия enter 
 * 		следить за dir1
 * 	если создастя файл - скопировать в dir2
 * 						- сделать в dir2 read-only
 * 						-удалить dir1
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;

public class Task {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 
		 * Path source = Paths.get("C:\\Test\\Stuff.txt"); Path target =
		 * Paths.get("C:\\Test1\\MyStuff.txt"); Files.move(source, target);
		 * 
		 * 
		 * File f1 = new File("C:\\Test"); File f2 = new File("C:\\Test1");
		 * 
		 * Path dir = Paths.get("C:\\Test\\"); WatchService watcher = null; try
		 * { WatchKey key = dir.register(watcher, ENTRY_CREATE); i } catch
		 * (IOException x) { System.out.println(x); }
		 */
		
	}
}
