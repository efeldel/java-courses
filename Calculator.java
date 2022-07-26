/**
 * Класс реализует калькулятор
 */
public class Calculator {
    /**
     Результат вычисления
     */
    private int result;

    /**
     * Суммируем аргументы
     * @param params Аргументы суммирования
     */
    public void add(int... params) {
        for (Integer param : params) this.result += param;
    }

    /**
     * Вычитаем аргументы из первого
     * @param params Аргументы вычитания
     */
    public void sub(int... params) {
        this.result = params[0];
        for (int i = 1; i < params.length; i++) {
            this.result -= params[i];
        }
    }

    /**
     * Умножаем аргументы
     * @param params Аргументы умножения
     */
    public void mul(int... params) {
        this.result = 1;
        for (Integer param : params) this.result *= param;
    }

    /**
     * Делим первый аргумент на последующие
     * @param params Аргументы деления
     * @throws ArithmeticException выпадет, если деление на ноль
     */
    public void div(int... params) {
        this.result = params[0];
        try {
            for (int i = 1; i < params.length; i++) {
                this.result /= params[i];
            }
        } catch (ArithmeticException e) {
            System.out.println("Ошибка деления на ноль!");
            this.result = 0;
        }
    }

    /**
     * Возвращает результат операции
     * @return Результат операции
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Обнуляет результат
     */
    public void cleanResult() {
        this.result = 0;
    }
}
