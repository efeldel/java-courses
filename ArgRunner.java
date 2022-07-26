/**
 * Класс для использования калькулятора из командной строки
 */
public class ArgRunner {
    public static void main(String[] args) {
        String operation = args[0];
        int first = Integer.parseInt(args[1]);
        int second = Integer.parseInt(args[2]);
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
