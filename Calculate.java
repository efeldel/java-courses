import java.util.Objects;

public class Calculate {
	public static void main(String[] arg) {
		String operation = arg[0];
		int first = Integer.valueOf(arg[1]);
		int second = Integer.valueOf(arg[2]);
		int result = switch (operation) {
			case "sum" -> first + second;
			case "sub" -> first - second;
			case "mul" -> first * second;
			case "div" -> first / second;
			default -> 0;
		};

		System.out.println("Calculate...");
		System.out.println("Результат " + result);

	}
}