package petclinic;
/**
 * Базовый класс для домашних животных
 */
public class Pet {
    private String name;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
