package ru.courses;

/**
 *  ласс описывает домашнее животное: кот
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
        System.out.println("ћ€у!");
    }

    @Override
    public String toString() {
        return "кот/кошка " + getName();
    }
}
