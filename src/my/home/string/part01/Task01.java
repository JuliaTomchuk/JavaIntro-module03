package my.home.string.part01;

//Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.

public class Task01 {

	public static void main(String[] args) {

		String[] array = { "somethingInTheWay", "comeAsYouAre", "inBloom", "allApologies" };

		for (String string : array) {

			System.out.println(changeTosnakeCase(string));
		}

	}

	public static String changeTosnakeCase(String string) {
		String result = "";

		char[] array = string.toCharArray();

		for (int i = 0; i < array.length; i++) {

			if (Character.isLowerCase(array[i])) {
				result += array[i];
			} else {
				result = result + "_" + Character.toLowerCase(array[i]);
			}
		}

		return result;
	}

}
