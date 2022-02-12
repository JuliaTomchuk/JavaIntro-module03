package my.home.string.part03;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Создать приложение, разбирающее текст(текст хранится в строке) и позволяющее выполнять с текстом
 * три различные операции: отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию вхождения 
 * заданного символа, а в случае равенства - по алфивиту*/
public class Task01 {

	public static void main(String[] args) {

		String text = "Royal Canadian blended. \n"
				+ "The spicy aroma had mended me.  Matured for years and imported. Into my glass you poured it. \r\n"
				+ "And you're the only reason that I remain unfrozen. Suppose it stands to reason that you would turn on me. ";

		System.out.println("Сортируем абзацы по количеству предложений: ");

		String sortedParagraph = sortParagraph(text);

		System.out.println(sortedParagraph);

		System.out.println("Сортируем слова в предложениях по длине: ");

		String sortedWordsByLength = sortWordInSentences(text);

		System.out.println(sortedWordsByLength);

		System.out.println(" Cортируем слова по вхождению символа 'a', при равных вхождениях по алфавиту");

		String sortedWordsByCharacter = sortWordInSentences(text, 'a');

		System.out.println(sortedWordsByCharacter);

	}

	public static String[] breakTextIntoParagraphs(String text) {

		Pattern pattern = Pattern.compile("\\n");

		return pattern.split(text);

	}

	public static String sortParagraph(String text) {

		String[] array = breakTextIntoParagraphs(text);

		boolean flag = false;
		while (!flag) {

			flag = true;

			for (int i = 0; i < array.length - 1; i++) {

				if (countSentences(array[i]) > countSentences(array[i + 1])) {

					swap(i, i + 1, array);
					flag = false;

				}
			}
		}
		return arrayToString(array);

	}

	public static int countSentences(String paragraph) {

		Pattern pattern = Pattern.compile("[\\.\\?\\!\\...\\!?\\?!]\\s+");

		String[] array = pattern.split(paragraph);

		return array.length;
	}

	public static String[] breakTextIntoSentences(String text) {

		Pattern pattern = Pattern.compile("[\\.\\?\\!\\...\\!?\\?!]\\s+");

		return pattern.split(text);
	}

	public static String[][] breakSentenceIntoWord(String[] array) {

		String[][] newArray = new String[array.length][];

		for (int i = 0; i < array.length; i++) {
			Pattern pattern = Pattern.compile("\\s+");
			newArray[i] = pattern.split(array[i]);

		}

		return newArray;
	}

	public static String sortWordInSentences(String text) {

		String[] sentences = breakTextIntoSentences(text);
		String[][] words = breakSentenceIntoWord(sentences);

		for (int i = 0; i < words.length; i++) {

			sortWordByLength(words[i]);

		}

		return multidimensionalArrayToString(words);
	}

	public static String[] sortWordByLength(String[] array) {

		boolean sorted = false;

		while (!sorted) {
			sorted = true;

			for (int i = 0; i < array.length; i++) {

				for (int j = i + 1; j < array.length; j++) {

					if (array[i].length() > array[j].length()) {

						swap(i, j, array);
						sorted = false;
					}
				}

			}
		}

		return array;
	}

	public static void swap(int i, int j, String[] array) {

		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static String sortWordInSentences(String text, char character) {

		String[] sentences = breakTextIntoSentences(text);
		String[][] words = breakSentenceIntoWord(sentences);

		for (int i = 0; i < words.length; i++) {

			sortWordByChar(words[i], character);

		}

		for (int i = 0; i < words.length; i++) {

			sortAlphabetically(words[i], character);
		}
		return multidimensionalArrayToString(words);
	}

	public static void sortAlphabetically(String[] words, char character) {

		boolean flag = false;

		while (!flag) {

			flag = true;

			for (int m = 0; m < words.length - 1; m++) {

				if (countOccurrenceOfCharacter(words[m], character) == countOccurrenceOfCharacter(words[m + 1],
						character) && isGreater(words[m], words[m + 1])) {

					swap(m, m + 1, words);
					flag = false;

				}
			}

		}
	}

	public static String[] sortWordByChar(String[] sentence, char character) {

		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < sentence.length; i++) {

				for (int j = i + 1; j < sentence.length; j++) {

					if (countOccurrenceOfCharacter(sentence[i], character) > countOccurrenceOfCharacter(sentence[j],
							character)) {

						swap(i, j, sentence);
						sorted = false;
					}

				}
			}

		}

		return sentence;
	}

	public static boolean isGreater(String first, String second) {

		if (first.toLowerCase().charAt(0) > second.toLowerCase().charAt(0)) {

			return true;
		} else if (first.toLowerCase().charAt(0) < second.toLowerCase().charAt(0)) {
			return false;
		} else {
			int i = 1;
			while (first.toLowerCase().charAt(i) == second.toLowerCase().charAt(i) && i < first.length() - 1
					&& i < second.length() - 1) {
				i++;
			}

			return first.toLowerCase().charAt(i) > second.toLowerCase().charAt(i);
		}

	}

	public static int countOccurrenceOfCharacter(String word, char character) {

		int counter = 0;

		Pattern pattern = Pattern.compile(String.valueOf(character), Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(word);
		while (matcher.find()) {
			counter++;
		}
		return counter;
	}

	public static String arrayToString(String[] array) {

		String result = "";

		for (int i = 0; i < array.length; i++) {
			result += array[i];
			result += "\n";
		}

		return result;
	}

	public static String multidimensionalArrayToString(String[][] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				result += array[i][j] + " ";
			}
			result = result.stripTrailing();
			result += ". ";
		}
		return result;
	}

}
