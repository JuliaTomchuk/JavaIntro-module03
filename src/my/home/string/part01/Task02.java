package my.home.string.part01;



//Замените в строке все вхождения word на letter

public class Task02 {

	public static void main(String args[]) {

		String word = "word";
		String letter = "letter";

		String myString = "Read the whole sentence with the word and the sentences before and after. "
				+ "Use the context to understand the meaning of the word";

		char[] arrayFirst = myString.toCharArray();

		int arrayLength = findSecondArrayLength(arrayFirst, word, letter);

		char[] arraySecond = new char[arrayLength];

		for (int i = 0, j = 0; i < arrayFirst.length; i++, j++) {

			if (findWord(arrayFirst, i)) {

				arraySecond[j] = 'l';
				arraySecond[j + 1] = 'e';
				arraySecond[j + 2] = 't';
				arraySecond[j + 3] = 't';
				arraySecond[j + 4] = 'e';
				arraySecond[j + 5] = 'r';

				i += word.length();
				j += letter.length();
			} else {
				arraySecond[j] = arrayFirst[i];
			}
		}

		String result= new String(arraySecond);

		System.out.println(result);

	}

	public static boolean findWord(char[] array, int i) {

		if (array[i] == 'w' && array[i + 1] == 'o' && array[i + 2] == 'r' && array[i + 3] == 'd')
			return true;
		else {
			return false;
		}
	}

	public static int findSecondArrayLength(char[] array, String oldString, String newString) {

		int counter = 0;
		int arrayLength = 0;

		for (int i = 0; i < array.length; i++) {

			if (findWord(array, i)) {
				counter++;
			}
		}

		if (newString.length() >= oldString.length()) {

			arrayLength = (newString.length() - oldString.length()) * counter + array.length;
		} else {
			arrayLength = (oldString.length() - newString.length()) * counter + array.length;
		}

		return arrayLength;
	}

}
