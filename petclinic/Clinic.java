package petclinic;

/**
 * Класс описывает клинику
 */
public class Clinic {
    /**
     * Список клиентов
     */
    private final Client[] clients;
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
        this.clients[client.getId()] = client;
    }

    /**
     * Искать клиентов по имени питомца
     * @param name Имя питомца
     * @return Массив клиентов
     */
    public Client[] getClientsByPetName(final String name) {
        Client[] result = new Client[clients.length];
        int i = 0;
        for (Client client : clients) {
            if (client.getPet().getName().equals(name)) {
                result[i] = client;
                i++;
            }
        }
        return result;
    }

    /**
     * Искать клиентов по имени
     * @param name Имя клиента
     * @return Массив клиентов
     */
    public Client[] getClientsByName(final String name) {
        Client[] result = new Client[clients.length];
        int i = 0;
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                result[i] = client;
                i++;
            }
        }
        return result;
    }
}
