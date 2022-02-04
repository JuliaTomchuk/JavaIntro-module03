package my.home.string.part01;

//В строке посчитать все цифры
public class Task04 {

	public static void main(String[] args) {

		String text = "The total number of species include 16000 species of insects (probably 4000 more species yet to be described), "
				+ "20000 species of algae, " + "1800 species of lichen, 1050 species of mosses, "
				+ "2800 species of vascular plants, up to 7000 species of fungi,"
				+ " 450 species of birds (250 species nesting in Norway), "
				+ "90 species of mammals, 45 fresh-water species of fish, "
				+ "150 salt-water species of fish, 1000 species of fresh-water invertebrates, "
				+ "and 3500 species of salt-water invertebrates.";

		char[] array = text.toCharArray();

		int numOfDigits = countDigit(array);

		System.out.println(numOfDigits);

	}

	public static int countDigit(char[] array) {

		int counter = 0;

		for (int i = 0; i < array.length; i++) {

			if (isNumber(array[i]) && isNumber(array[i + 1])) {
				counter++;
				i++;
				while (isNumber(array[i])) {
					i++;
				}
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
