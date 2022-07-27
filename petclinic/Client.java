package petclinic;
/**
 * Класс описывает клиента
 */
public class Client {
    private static int count;
    private final int id = count++;
    private final String name;
    private final Pet pet;

    public Client(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }
}
