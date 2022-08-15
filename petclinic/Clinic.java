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
     * @return Массив клиентов или null
     */
    public Client[] getClientsByPetName(final String name) {
        Client[] temp = new Client[clients.length];
        int i = 0;
        for (Client client : clients) {
            if (client != null && client.getPet().getName().equalsIgnoreCase(name)) {
                temp[i] = client;
                i++;
            }
        }
        Client[] result;
        if (i > 0) {
            result = new Client[i];
            for (int j = 0; j < i; j++) {
                result[j] = temp[j];
            }
        }
        else result = null;
        return result;
    }

    /**
     * Искать клиентов по имени
     * @param name Имя клиента
     * @return Массив клиентов или null
     */
    public Client[] getClientsByName(final String name) {
        Client[] temp = new Client[clients.length];
        int i = 0;
        for (Client client : clients) {
            if (client != null && client.getName().equalsIgnoreCase(name)) {
                temp[i] = client;
                i++;
            }
        }
        Client[] result;
        if (i > 0) {
            result = new Client[i];
            for (int j = 0; j < i; j++) {
                result[j] = temp[j];
            }
        }
        else result = null;
        return result;
    }

    /**
     * Удалить клиента по имени
     * @param name Имя клиента
     */
    public void removeClient(final String name) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getName().equalsIgnoreCase(name)) clients[i] = null;
        }
    }

    /**
     * Удалить клиента по ID
     * @param id ID клиента
     */
    public void removeClient(final int id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getId() == id) clients[i] = null;
        }
    }
    /**
     * Получить список клиентов
     * @return Массив всех клиентов или null
     */
    public Client[] getAllClients() {
        return clients;
    }
}
