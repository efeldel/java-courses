/**
 * Тест калькулятора
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    /**
     * Проверяем сложение двух чисел
     */
    @Test
    void add() {
        Calculator calc = new Calculator();
        calc.add(1, 1);
        assertEquals(2, calc.getResult());
    }

    /**
     * Проверяем вычитание двух чисел
     */
    @Test
    void sub() {
        Calculator calc = new Calculator();
        calc.add(100, 99);
        assertEquals(1, calc.getResult());
    }

    /**
     * Проверяем умножение двух чисел
     */
    @Test
    void mul() {
        Calculator calc = new Calculator();
        calc.add(25, 4);
        assertEquals(100, calc.getResult());
    }

    /**
     * Проверяем деление двух чисел
     */
    @Test
    void div() {
        Calculator calc = new Calculator();
        calc.add(100, 25);
        assertEquals(4, calc.getResult());
    }


    @Test
    void getResult() {
    }

    /**
     * Проверяем обнуление результата
     */
    @Test
    void cleanResult() {
        Calculator calc = new Calculator();
        calc.cleanResult();
        assertEquals(0, calc.getResult());
    }
}