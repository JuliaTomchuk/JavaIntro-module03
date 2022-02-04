package my.home.string.part02;

//�?з заданной строки получить новую, повторив каждый символ дважды

public class Task06 {

	public static void main(String[] args) {
		String text = "Be slow to promise and quick to perform";

		StringBuilder builder = repeat(text);

		System.out.println(builder);

	}

	public static StringBuilder repeat(String text) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {

			builder.append(text.charAt(i)).append(text.charAt(i));
		}

		return builder;
	}

}
