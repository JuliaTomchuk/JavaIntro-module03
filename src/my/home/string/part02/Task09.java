package my.home.string.part02;

import java.util.Scanner;

//Посчитать количество строчных и прописных букв в ведённой строке.Учитывать только английские буквы

public class Task09 {

	public static void main(String[] args) {

		String text = readText();
		int counterOfLowercaseLetter = countLowercaseLetter(text);

		int counterOfUppercaseLetter = countUppercaseLetter(text);

		System.out.println("Number of lowercase letter:" + counterOfLowercaseLetter);

		System.out.println("Number of uppercase letter:" + counterOfUppercaseLetter);

	}

	public static String readText() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter text...");

		return scanner.nextLine();
	}

	public static int countLowercaseLetter(String text) {

		int counter = 0;

		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
				counter++;
			}

		}

		return counter;

	}

	public static int countUppercaseLetter(String text) {

		int counter = 0;

		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
				counter++;
			}

		}

		return counter;

	}

}