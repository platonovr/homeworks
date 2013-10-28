/*
 * задание - справочник
 * поиск по файловой системе, в интернете
 * веб - сервис пример - imdn(фильмы)
 * 
 * 
 * файловая система
 * 
 * 1) при страрте приложение проверяет, есть ли папка (каталог) в корне приложения
 * 2)если каталога нет, создаем
 * 3) все файлы, наход. внутри , используем
 * 4) deanclatworthy
 * 
 * каждый файл долен содержать
 * ссылку на фильм
 * жанр
 * язык фильма
 * страна
 * название
 * дата
 * cacheExpriry
 * 
 * вводим текстовое слово - информацию вывести всю
 */
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File file1 = new File("input.txt");
		File directory = new File(
				"C:/Users/rom16rus/workspace/Javalab1010/movies");
		System.out.println(directory.isDirectory());

		String[] names = directory.list();
		String s = sc.nextLine() + ".txt";
		System.out.println(s);
		File file;
		for (int i = 0; i < names.length; i++) {
			String name = "./movies/" + names[i];
			System.out.println(name);
			file = new File(name);
			if (s.equals(file.getName())) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String info;
				while ((info = br.readLine()) != null) {
					System.out.println(info);

				}
				br.close();

			}
		}

	}
}
