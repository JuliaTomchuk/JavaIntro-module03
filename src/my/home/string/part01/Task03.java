package my.home.string.part01;

//В строке найти количество цифр

public class Task03 {

	public static void main(String args[]) {

		String myString = "1, 2, 3, 4 Can I have a little more?	5, 6, 7, 8, 9, 10 I love you.";

		char[] array = myString.toCharArray();

		int numOfDigit = countNumber(array);

		System.out.println("В строке " + numOfDigit + " цифр.");

	}

	public static int countNumber(char[] array) {

		int counter = 0;

		for (int i = 0; i < array.length; i++) {

			if (isNumber(array[i])) {
				counter++;

			}
		}
		return counter;

	}

	public static boolean isNumber(char c) {

		char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

		boolean flag = false;
		for (int i = 0; i < numbers.length; i++) {

			if (c == numbers[i]) {
				flag = true;
			}

		}

		return flag;
	}
}