package my.home.string.part02;

/*Строка Х состоит из нескольких предложений,
каждое из которых  кончается точкой, восклиательным или вопросительным знаком.Определить количество предложений в строке Х*/
public class Task10 {

	public static void main(String[] args) {

		String text = "Where you going? Denver!? Well, I can take you a hundred miles up the line. ";

		int counter = countSentences(text);

		System.out.println("Number of sentences in the text: " + counter);
	}

	public static int countSentences(String text) {

		String[] array = text.split("[\\.\\...\\?\\?!\\!?\\!]\\s+");
		return array.length;
	}
}
