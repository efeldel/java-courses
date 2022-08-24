package ru.courses;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Класс описывает работу клиники
 */
public class ClinicRunner {
    public static void main(String[] args) {
        final Clinic clinic = new Clinic();
        System.out.println("Добро пожаловать в клинику \"Ветеринар\".");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("************************************");
                    System.out.println("Выберите действие:");
                    System.out.println("1. Вывести список клиентов");
                    System.out.println("2. Добавить клиента");
                    System.out.println("3. Искать клиента по имени");
                    System.out.println("4. Искать клиента по имени питомца");
                    System.out.println("5. Заменить питомца клиенту");
                    System.out.println("6. Удалить питомца клиенту");
                    System.out.println("7. Удалить клиента");
                    System.out.println("0. Выход");
                    switch (parseInt(sc.next())) {
                        case 0 -> System.exit(1);
                        case 1 -> {
                            System.out.println("Все клиенты: ");
                            for (Client c : clinic.getAllClients()) {
                                System.out.println(c);
                            }
                        }
                        case 2 -> {
                            System.out.println("Введите имя клиента:");
                            String client = sc.next();
                            System.out.println("Введите имя питомца:");
                            String petName = sc.next();
                            System.out.println("Введите тип питомца:");
                            String pet = sc.next().toLowerCase();
                            switch (pet) {
                                case "кот", "кошка" -> clinic.addClient(new Client(client, new Cat(petName)));
                                case "собака" -> clinic.addClient(new Client(client, new Dog(petName)));
                                default -> throw new UserException("Неправильный тип питомца");
                            }
                            System.out.println("Добавлен клиент: " + client + " c питомцем: " + pet + " " + petName);
                        }
                        case 3 -> {
                            System.out.println("Введите имя клиента:");
                            String client = sc.next();
                            if (clinic.getClientsByName(client).size() != 0) {
                                System.out.println("Все клиенты с именем " + client + ":");
                                for (Client c : clinic.getClientsByName(client))
                                    System.out.println(c);
                            } else
                                throw new UserException("Клиент не найден");
                        }
                        case 4 -> {
                            System.out.println("Введите имя питомца:");
                            String petName = sc.next();
                            if (clinic.getClientsByPetName(petName).size() != 0) {
                                System.out.println("Все клиенты с питомцем по имени " + petName);
                                for (Client c : clinic.getClientsByPetName(petName))
                                    System.out.println(c);
                            } else
                                throw new UserException("Клиент не найден");
                        }
                        case 5 -> {
                            System.out.println("Введите имя клиента:");
                            String client = sc.next();
                            if (clinic.getClientsByName(client).size() != 0) {
                                System.out.println("Введите имя нового питомца:");
                                String petName = sc.next();
                                System.out.println("Введите тип нового питомца:");
                                String pet = sc.next().toLowerCase();
                                switch (pet) {
                                    case "кот", "кошка" -> {
                                        System.out.println("Меняем питомца клиенту с именем " + client);
                                        for (Client c : clinic.getClientsByName(client)) {
                                            c.setPet(new Cat(petName));
                                            System.out.println("Новый питомец: " + c.getPet());
                                        }
                                    }
                                    case "собака" -> {
                                        System.out.println("Меняем питомца клиенту с именем " + client);
                                        for (Client c : clinic.getClientsByName(client)) {
                                            c.setPet(new Dog(petName));
                                            System.out.println("Новый питомец: " + c.getPet());
                                        }
                                    }
                                    default -> throw new UserException("Неправильный тип питомца");
                                }
                            } else
                                throw new UserException("Клиент не найден");
                        }
                        case 6 -> {
                            System.out.println("Введите имя клиента:");
                            String client = sc.next();
                            if (clinic.getClientsByName(client).size() != 0) {
                                System.out.println("Удаляем питомца клиенту с именем " + client);
                                for (Client c : clinic.getClientsByName(client))
                                    c.removePet();
                            } else
                                throw new UserException("Клиент не найден");
                        }
                        case 7 -> {
                            System.out.println("Введите имя или ID клиента:");
                            String client = sc.next();
                            int id;
                            if (client.matches("\\d+")) {
                                id = parseInt(client);
                                if (clinic.getClientsById(id) != null) {
                                    System.out.println("Удаляем клиента с ID = " + id);
                                    clinic.removeClient(id);
                                } else
                                    throw new UserException("ID не найден");
                            } else {
                                if (clinic.getClientsByName(client).size() != 0) {
                                    for (Client c : clinic.getClientsByName(client)) {
                                        System.out.println("Удаляем клиента: " + clinic.getClientsByName(client));
                                        clinic.removeClient(client);
                                    }
                                } else
                                    throw new UserException("Клиент не найден");
                            }
                            System.out.println("Клиент удален");
                        }
                    }
                } catch(NumberFormatException e){
                    System.out.println("Недопустимый ввод, разрешены только числа.");
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
