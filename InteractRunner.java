import java.util.Scanner;

public class InteractRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Calculator calc = new Calculator();
            while (true) {
                calc.cleanResult();
                System.out.println("Введите первое число:");
                int first = sc.nextInt();
                System.out.println("Введите второе число:");
                int second = sc.nextInt();
                System.out.println("Выберите действие:");
                System.out.println("1. Сложить");
                System.out.println("2. Вычесть");
                System.out.println("3. Умножить");
                System.out.println("4. Разделить");
                System.out.println("0. Выход");
                switch (sc.nextInt()) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> calc.add(first, second);
                    case 2 -> calc.sub(first, second);
                    case 3 -> calc.mul(first, second);
                    case 4 -> calc.div(first, second);
                }
                System.out.println("Результат: " + calc.getResult());
            }
        } finally {
            sc.close();
        }
    }
}
