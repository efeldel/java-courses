package petclinic;
/**
 * Класс описывает работу клиники
 */
public class ClinicRunner {
    public static void main(String[] args) {
        final Clinic clinic = new Clinic(10);

        clinic.addClient(new Client("Антон", new Cat("Анфиса")));
        clinic.addClient(new Client("Инна", new Dog("Трезор")));
        clinic.addClient(new Client("Алена", new Dog("Мумука")));
        clinic.addClient(new Client("Аня", new Cat("Кокс")));
        clinic.addClient(new Client("Олег", new Dog("Рекс")));
        clinic.addClient(new Client("Олег", new Cat("Персик")));
        clinic.addClient(new Client("Алла", new Dog("Фунтик")));
        clinic.addClient(new Client("Макс", new Dog("Хрюк")));
        clinic.addClient(new Client("Егор", new Cat("Мышь")));
        clinic.addClient(new Client("Женя", new Cat("Шпик")));
        System.out.println("Все клиенты: ");
        for (Client c: clinic.getAllClients()) {
            System.out.println(c);
        }

        System.out.println("Удаляем клиента с ID = 1");
        clinic.removeClient(1);

        System.out.println("Удаляем клиента с именем Алла");
        clinic.removeClient("Алла");

        System.out.println("Удаляем питомца клиенту с именем Макс");
        for (Client c : clinic.getClientsByName("макс"))
            c.removePet();
        System.out.println("Меняем питомца клиенту с именем Женя");
        for (Client c : clinic.getClientsByName("женя"))
            c.setPet(new Dog("Сало"));

        System.out.println("Все клиенты: ");
        for (Client c: clinic.getAllClients()) {
            System.out.println(c);
        }

        System.out.println("Все клиенты с именем Олег: ");
        for (Client c : clinic.getClientsByName("Олег"))
            System.out.println(c);

        System.out.println("Все клиенты с питомцем по имени Кокс");
        for (Client c : clinic.getClientsByPetName("Кокс"))
            System.out.println(c);
    }
}
