package ru.courses;

/**
 * ����� ��������� �������� ��������: ������
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
        System.out.println("���!");
    }

    @Override
    public String toString() {
        return "������ " + getName();
    }
}
