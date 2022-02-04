package my.home.string.part02;

import java.util.Scanner;

/*Вводится строка слов, разделённых пробелами.
 * Найти самое длинное слово и вывести его на экран.Случай, 
 * когда самых длинных слов может быть несколько, не обрабатывать
 */
public class Task08 {

	public static void main(String[] args) {

		String line = readLine();

		String max = findLongestWord(line);

		if (isTheOnlyOne(max, line)) {
			System.out.println("Самое длинное слово " + max);
		} else {
			System.out.println("Самых длинных слов несколько");
		}

	}

	public static String readLine() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static String findLongestWord(String line) {

		String[] array = line.split("\\s+");
		String max = "";

		for (int i = 0; i < array.length; i++) {

			if (array[i].length() > max.length()) {
				max = array[i];
			}
		}
		return max;
	}

	public static boolean isTheOnlyOne(String max, String line) {

		String[] array = line.split("\\s+");
		int counter = 0;
		for (int i = 0; i < array.length; i++) {

			if (max.length() == array[i].length()) {
				counter++;
			}
		}

		return counter < 2;

	}

}
