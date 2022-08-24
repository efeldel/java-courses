package ru.courses;

/**
 * ����� ��������� �������� ��������: ���
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
        System.out.println("���!");
    }

    @Override
    public String toString() {
        return "���/����� " + getName();
    }
}
