package my.home.string.part02;

import java.util.Scanner;

//Вводится строка. Требуется удалить из неё повторяющиеся символы и пробелы.
public class Task07 {

	public static void main(String[] args) {

		System.out.println("Введите строку: ");

		String line = readLine();

		String result = removeSpace(removeDuplicate(line));

		System.out.println(result);

	}

	public static String readLine() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}

	public static String removeDuplicate(String line) {
		String result = "";

		for (int i = 0; i < line.length(); i++) {
			if (!result.contains(String.valueOf(line.charAt(i)))) {
				result += line.charAt(i);
			}
		}

		return result;
	}

	public static String removeSpace(String line) {
		return line.replaceAll("\\s*", "");

	}
}