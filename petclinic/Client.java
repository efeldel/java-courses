package petclinic;
/**
 * Класс описывает клиента
 */
public class Client {
    private static int count;
    private final int id = count++;
    private String name;
    private Pet pet;

    public Client(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void removePet() {
        this.pet = new Pet("нет питомца");
    }

    @Override
    public String toString() {
        return "Клиент: " +
                "id = " + id +
                ", имя: '" + name + '\'' +
                ", питомец: " + pet;
    }
}
