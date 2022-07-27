package petclinic;
/**
 * Класс описывает домашнее животное: кот
 */
public class Cat extends Pet{

    public Cat(String name) {
        super(name);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}
