package petclinic;
/**
 * Базовый класс для домашних животных
 */
public class Pet {
    private final String name;

    public Pet(String name) {
        this.name = name;
    }

    /**
     * Издать звук
     */
    public void makeSound() {
        System.out.println("");
    }

    /**
     * Получить имя
     */
    public String getName() {
        return name;
    }
}
