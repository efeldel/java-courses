package ru.courses;

import java.util.Scanner;

/**
 * ����� ��������� ������ �������
 */
public class ClinicRunner {
    public static void main(String[] args) {
        final Clinic clinic = new Clinic();

//        try (Scanner sc = new Scanner(System.in)) {
//            while (true) {
//                try {
//                    System.out.println("������� ������ �����:");
//                    int first = Integer.parseInt(sc.next());
//                    System.out.println("������� ������ �����:");
//                    int second = Integer.parseInt(sc.next());
//                    System.out.println("�������� ��������:");
//                    System.out.println("1. �������");
//                    System.out.println("2. �������");
//                    System.out.println("3. ��������");
//                    System.out.println("4. ���������");
//                    System.out.println("0. �����");
//                    switch (Integer.parseInt(sc.next())) {
        clinic.addClient(new Client("�����", new Cat("������")));
        clinic.addClient(new Client("����", new Dog("������")));
        clinic.addClient(new Client("�����", new Dog("������")));
        clinic.addClient(new Client("���", new Cat("����")));
        clinic.addClient(new Client("����", new Dog("����")));
        clinic.addClient(new Client("����", new Cat("������")));
        clinic.addClient(new Client("����", new Dog("������")));
        clinic.addClient(new Client("����", new Dog("����")));
        clinic.addClient(new Client("����", new Cat("����")));
        clinic.addClient(new Client("����", new Cat("����")));
        System.out.println("��� �������: ");
        for (Client c: clinic.getAllClients()) {
            System.out.println(c);
        }

        System.out.println("������� ������� � ID = 1");
        clinic.removeClient(1);

        System.out.println("������� ������� � ������ ����");
            clinic.removeClient("����");


        System.out.println("������� ������� ������� � ������ ����");
        for (Client c : clinic.getClientsByName("����"))
            c.removePet();
        System.out.println("������ ������� ������� � ������ ����");
        for (Client c : clinic.getClientsByName("����"))
            c.setPet(new Dog("����"));

        System.out.println("��� �������: ");
        for (Client c: clinic.getAllClients()) {
            System.out.println(c);
        }

        System.out.println("��� ������� � ������ ����: ");
        for (Client c : clinic.getClientsByName("����"))
            System.out.println(c);

        System.out.println("��� ������� � �������� �� ����� ����");
        for (Client c : clinic.getClientsByPetName("����"))
            System.out.println(c);
    }
}
