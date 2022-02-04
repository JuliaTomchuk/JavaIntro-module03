package my.home.string.part02;

//Дан текст (строка) найдите гаибольшее количество подряд идущих пробелов в нём
public class Task01 {
	public static void main(String args[]) {

		String text = "The                          greatest ride in my life was about to come up, a truck, with a flatboard at the back, with about\r\n"
				+ "six or seven boys sprawled out on it, and the drivers, two young blond farmers from Minnesota,\r\n"
				+ "were picking up every single soul they found on that road-the most smiling, cheerful couple of\r\n"
				+ "handsome bumpkins you could ever wish to see, both wearing cotton shirts and overalls, nothing\r\n"
				+ "else; both thick-wristed and earnest, with broad howareyou smiles for anybody and anything that\r\n"
				+ "came across their path. I ran up, said \"Is there room?\" They said, \"Sure, hop on, 'sroom for\r\n"
				+ "everybody.";

		int maxCountOfSpaces = findSpace(text);

		System.out.println("Максимальное количество пробелов идущих подряд: " + maxCountOfSpaces);

	}

	public static int findSpace(String text) {
		int counter = 0;
		int max = 0;
		for (int i = 0; i < text.length(); i++) {

			if (isSpace(text.charAt(i)) && isSpace(text.charAt(i + 1))) {
				counter += 2;
				while (isSpace(text.charAt(i + 2))) {
					counter++;
					i++;
				}
				if (counter > max) {
					max = counter;
				}
				counter = 0;
			}

		}
		return max;

	}

	public static boolean isSpace(char c) {
		return c == ' ';
	}
}
