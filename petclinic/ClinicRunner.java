package petclinic;
/**
 * ����� ��������� ������ �������
 */
public class ClinicRunner {
    public static void main(String[] args) {
        final Clinic clinic = new Clinic(10);

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
