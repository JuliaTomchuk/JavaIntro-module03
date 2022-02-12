package my.home.string.part03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml- документа и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела)
Пользоваться готовыми парсерами XML для решения данной задачи нельзя*/

public class Task02 {

	public static void main(String[] args) {
		String xml = "<notes>\n" + " <note id = \"1\">\n" + " <to>Вася</to>\n" + " <from>Света</from>\n"
				+ " <heading>Напоминание</heading>\n" + " <body>Позвони мне завтра!</body>\n" + " </note>\n"
				+ " <note id = \"2\">\n" + " <to>Петя</to>\n" + " <from>Маша</from>\n"
				+ " <heading>Важное напоминание</heading>\n" + " <body/>\n" + " </note>\n" + "</notes>";

		String[] array = xml.split("\\n");

		Pattern open = Pattern.compile("<[a-z\\s]*\\=*[\\s\\d\\\\\\\"]*>");
		Pattern close = Pattern.compile("</\\w+>");
		Pattern content = Pattern.compile(">([А-Яа-я\\s]++)<");
		Pattern withoutBody = Pattern.compile("<\\w+/>");

		for (String str : array) {
			Matcher isOpen = open.matcher(str);
			Matcher isClose = close.matcher(str);
			Matcher isContent = content.matcher(str);
			Matcher isWithoutBody = withoutBody.matcher(str);

			if (isOpen.find()) {
				System.out.println("Тег " + isOpen.group() + ": открывающий тег");
			}

			if (isClose.find()) {
				System.out.println("Тег " + isClose.group() + ": закрывающий тег");
			}

			if (isContent.find()) {
				System.out.println("Содержимое тега: " + isContent.group(1));

			}

			if (isWithoutBody.find()) {

				System.out.println("Tег " + isWithoutBody.group() + " без тела");
			}

		}
	}

}
