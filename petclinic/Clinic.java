package petclinic;
/**
 * Класс описывает клинику
 */
public class Clinic {
    /**
     * Список клиентов
     */
    private final Client[] clients;
    private static int clientId;
    /**
     * @param size Количество клиентов (размер массива)
     */
    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /**
     * Добавить клиента
     * @param client Клиент
     */
    public void addClient (final Client client) {
        this.clients[clientId] = client;
        clientId++;
    }

    public Client[] getClientsByPetName(final String name) {
        // TODO реализовать
        return new Client[]{};
    }
}
