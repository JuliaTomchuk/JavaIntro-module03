package my.home.string.part02;

//Проверить, является ли заданное слово палиндромом

public class Task03 {
	public static void main(String[] args) {
		String word = "level";

		boolean palindrom = isPalindrom(word);

		System.out.println("Is " + "\"" + word + "\" " + "a palindrom? " + palindrom);

	}

	public static boolean isPalindrom(String word) {

		StringBuilder reverseWord = reverse(word);

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != reverseWord.charAt(i)) {

				return false;

			}

		}
		return true;
	}

	public static StringBuilder reverse(String word) {

		StringBuilder reverseWord = new StringBuilder(word);

		return reverseWord.reverse();

	}

}