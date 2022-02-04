package my.home.string.part02;

//В строке после каждого символа 'a' вставить 'b'
public class Task02 {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder(
				"I went to the cold-water flat with the boys, and Dean came to the door in his shorts. Marylou was\r\n"
						+ "jumping off the couch; Dean had dispatched the occupant of the apartment to the kitchen, probably\r\n"
						+ "to make coffee, while he proceeded with his loveproblems, for to him sex was the one and only\r\n"
						+ "holy and important thing in life, although he had to sweat and curse to make a living and so ona.a");

		replace(builder);

		System.out.println(builder);

	}

	public static void replace(StringBuilder builder) {
		for (int i = 0; i < builder.length(); i++) {

			if (builder.charAt(i) == 'a') {
				builder.insert(i + 1, 'b');
			}
		}

	}

}
