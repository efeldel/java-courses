package ru.courses;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * ����� ��������� ������ �������
 */
public class ClinicRunner {
    public static void main(String[] args) {
        final Clinic clinic = new Clinic();
        System.out.println("����� ���������� � ������� \"���������\".");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("************************************");
                    System.out.println("�������� ��������:");
                    System.out.println("1. ������� ������ ��������");
                    System.out.println("2. �������� �������");
                    System.out.println("3. ������ ������� �� �����");
                    System.out.println("4. ������ ������� �� ����� �������");
                    System.out.println("5. �������� ������� �������");
                    System.out.println("6. ������� ������� �������");
                    System.out.println("7. ������� �������");
                    System.out.println("0. �����");
                    switch (parseInt(sc.next())) {
                        case 0 -> System.exit(1);
                        case 1 -> {
                            System.out.println("��� �������: ");
                            for (Client c : clinic.getAllClients()) {
                                System.out.println(c);
                            }
                        }
                        case 2 -> {
                            System.out.println("������� ��� �������:");
                            String client = sc.next();
                            System.out.println("������� ��� �������:");
                            String petName = sc.next();
                            System.out.println("������� ��� �������:");
                            String pet = sc.next().toLowerCase();
                            switch (pet) {
                                case "���", "�����" -> clinic.addClient(new Client(client, new Cat(petName)));
                                case "������" -> clinic.addClient(new Client(client, new Dog(petName)));
                                default -> throw new UserException("������������ ��� �������");
                            }
                            System.out.println("�������� ������: " + client + " c ��������: " + pet + " " + petName);
                        }
                        case 3 -> {
                            System.out.println("������� ��� �������:");
                            String client = sc.next();
                            if (clinic.getClientsByName(client).size() != 0) {
                                System.out.println("��� ������� � ������ " + client + ":");
                                for (Client c : clinic.getClientsByName(client))
                                    System.out.println(c);
                            } else
                                throw new UserException("������ �� ������");
                        }
                        case 4 -> {
                            System.out.println("������� ��� �������:");
                            String petName = sc.next();
                            if (clinic.getClientsByPetName(petName).size() != 0) {
                                System.out.println("��� ������� � �������� �� ����� " + petName);
                                for (Client c : clinic.getClientsByPetName(petName))
                                    System.out.println(c);
                            } else
                                throw new UserException("������ �� ������");
                        }
                        case 5 -> {
                            System.out.println("������� ��� �������:");
                            String client = sc.next();
                            if (clinic.getClientsByName(client).size() != 0) {
                                System.out.println("������� ��� ������ �������:");
                                String petName = sc.next();
                                System.out.println("������� ��� ������ �������:");
                                String pet = sc.next().toLowerCase();
                                switch (pet) {
                                    case "���", "�����" -> {
                                        System.out.println("������ ������� ������� � ������ " + client);
                                        for (Client c : clinic.getClientsByName(client)) {
                                            c.setPet(new Cat(petName));
                                            System.out.println("����� �������: " + c.getPet());
                                        }
                                    }
                                    case "������" -> {
                                        System.out.println("������ ������� ������� � ������ " + client);
                                        for (Client c : clinic.getClientsByName(client)) {
                                            c.setPet(new Dog(petName));
                                            System.out.println("����� �������: " + c.getPet());
                                        }
                                    }
                                    default -> throw new UserException("������������ ��� �������");
                                }
                            } else
                                throw new UserException("������ �� ������");
                        }
                        case 6 -> {
                            System.out.println("������� ��� �������:");
                            String client = sc.next();
                            if (clinic.getClientsByName(client).size() != 0) {
                                System.out.println("������� ������� ������� � ������ " + client);
                                for (Client c : clinic.getClientsByName(client))
                                    c.removePet();
                            } else
                                throw new UserException("������ �� ������");
                        }
                        case 7 -> {
                            System.out.println("������� ��� ��� ID �������:");
                            String client = sc.next();
                            int id;
                            if (client.matches("\\d+")) {
                                id = parseInt(client);
                                if (clinic.getClientsById(id) != null) {
                                    System.out.println("������� ������� � ID = " + id);
                                    clinic.removeClient(id);
                                } else
                                    throw new UserException("ID �� ������");
                            } else {
                                if (clinic.getClientsByName(client).size() != 0) {
                                    for (Client c : clinic.getClientsByName(client)) {
                                        System.out.println("������� �������: " + clinic.getClientsByName(client));
                                        clinic.removeClient(client);
                                    }
                                } else
                                    throw new UserException("������ �� ������");
                            }
                            System.out.println("������ ������");
                        }
                    }
                } catch(NumberFormatException e){
                    System.out.println("������������ ����, ��������� ������ �����.");
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
