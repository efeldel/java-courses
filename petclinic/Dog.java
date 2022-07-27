package petclinic;
/**
 * Класс описывает домашнее животное: собака
 */
public class Dog extends Pet{

    public Dog(String name) {
        super(name);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}
