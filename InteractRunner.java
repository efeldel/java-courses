/**
 * Класс для использования калькулятора из консоли
 */
import java.util.Scanner;
public class InteractRunner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Calculator calc = new Calculator();
            while (true) {
                calc.cleanResult();
                try {
                    System.out.println("Введите первое число:");
                    int first = Integer.parseInt(sc.next());
                    System.out.println("Введите второе число:");
                    int second = Integer.parseInt(sc.next());
                    System.out.println("Выберите действие:");
                    System.out.println("1. Сложить");
                    System.out.println("2. Вычесть");
                    System.out.println("3. Умножить");
                    System.out.println("4. Разделить");
                    System.out.println("0. Выход");
                    switch (Integer.parseInt(sc.next())) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> calc.add(first, second);
                        case 2 -> calc.sub(first, second);
                        case 3 -> calc.mul(first, second);
                        case 4 -> calc.div(first, second);
                        }
                    System.out.println("Результат: " + calc.getResult());
                } catch (NumberFormatException e) {
                    System.out.println("Недопустимый ввод, разрешены только числа.");
                }
            }
        }
    }
}
