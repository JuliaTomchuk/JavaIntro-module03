package my.home.string.part01;

/*Удалить в строке все лишние пробелы, 
 * то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайнее пробелы в строке удалить.*/

public class Task05 {

	public static void main(String args[]) {
		String text = "                  I first met Dean not long               after my wife                 and I split up. I had just gotten over a serious illness that I\r\n"
				+ "won't bother to talk                about, except that it            had something to do with the miserably weary split-up and\r\n"
				+ "my feeling that                    everything was dead.                 ";

		char[] array = text.toCharArray();

		System.out.println(new String("Первоначальный текст: \n" + text));

		char[] arrayNoLeadingSpaces = removeSpacesAtTheBeginning(array);

		System.out.println("Текст без пробелов в начале: \n" + new String(arrayNoLeadingSpaces));

		char[] arrayNoTrailingSpaces = removeSpacesAtTheEnd(arrayNoLeadingSpaces);

		System.out.println("Текст без пробелов в начале и  конце: \n" + new String(arrayNoTrailingSpaces));

		char[] arrayNoExtraSpaces = removeSpaces(arrayNoTrailingSpaces);

		System.out.println("Текст без пробелов в начале,конце и без дублирующихся пробелов в середине: \n"
				+ new String(arrayNoExtraSpaces));
	}

	public static char[] removeSpaces(char[] array) {

		int numberOfSpaces = countExtraSpaces(array);

		char[] result = new char[array.length - numberOfSpaces];

		for (int i = 0, j = 0; i < array.length; i++, j++) {

			if (isSpace(array[i]) && isSpace(array[i + 1])) {
				result[j] = array[i];
				j++;
				i = i + 2;
				while (isSpace(array[i])) {
					i++;
				}
			} else {
				result[j] = array[i];
			}

			result[j] = array[i];
		}

		return result;

	}

	public static int countExtraSpaces(char[] array) {
		int counter = 0;

		for (int i = 0; i < array.length; i++) {

			if (isSpace(array[i]) && isSpace(array[i + 1])) {
				counter++;
				i = i + 2;
				while (isSpace(array[i])) {
					counter++;
					i++;
				}

			}
		}

		return counter;

	}

	public static int countExtraSpacesfromTheBeginning(char[] array) {
		int counter = 0;

		for (int i = 0; i < array.length; i++) {

			if (isSpace(array[i])) {
				counter++;
			} else {
				break;
			}
		}

		return counter;

	}

	public static char[] removeSpacesAtTheBeginning(char[] array) {

		int numberOfSpaces = countExtraSpacesfromTheBeginning(array);
		char[] result = new char[array.length - numberOfSpaces];
		for (int i = numberOfSpaces, j = 0; i < array.length; i++, j++) {
			result[j] = array[i];

		}

		return result;

	}

	public static int countExtraSpacesAtTheEnd(char[] array) {
		int counter = 0;

		for (int i = array.length - 1; i >= 0; i--) {

			if (isSpace(array[i])) {
				counter++;
			} else {
				break;
			}
		}

		return counter;

	}

	public static char[] removeSpacesAtTheEnd(char[] array) {
		int numberOfSpaces = countExtraSpacesAtTheEnd(array);

		char[] result = new char[array.length - numberOfSpaces];

		for (int i = 0; i < result.length; i++) {

			result[i] = array[i];
		}

		return result;

	}

	public static boolean isSpace(char c) {
		if (c == ' ')
			return true;
		return false;
	}
}