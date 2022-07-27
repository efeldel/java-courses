package petclinic;
/**
 * Класс описывает работу клиники
 */
public class ClinicRunner {
    public static void main(String[] args) {
        final Clinic clinic = new Clinic(10);

        clinic.addClient(new Client("Антон", new Cat("Анфиса")));

        clinic.addClient(new Client("Инна", new Dog("Трезор")));

    }
}
