package my.home.string.part02;

//Подсчитать скалько раз среди символов заданной строки встречается буква 'a'

public class Task05 {

	public static void main(String[] args) {

		String text = "Dean had already left. Carlo and I saw him off at the 34th Street Greyhound station. Upstairs they\r\n"
				+ "had a place where you could make pictures for a quarter. Carlo took off his glasses and looked\r\n"
				+ "sinister. Dean made a profile shot and looked coyly around. ";

		char c = 'a';
		int counter = count(c, text);

		System.out.println("Буква " + c + " встречается в тексте:  " + counter + " раз");

	}

	public static int count(char c, String text) {
		int counter = 0;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == c) {
				counter++;
			}
		}

		return counter;

	}
}