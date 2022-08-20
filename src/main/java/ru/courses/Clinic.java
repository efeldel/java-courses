package ru.courses;

import java.util.ArrayList;

/**
 * Класс описывает клинику
 */
public class Clinic {
    /**
     * Список клиентов
     */
    private final ArrayList<Client> clients;
    /**
     *
     */
    public Clinic() {
        clients = new ArrayList<>();
    }

    /**
     * Добавить клиента
     * @param client Клиент
     */
    public void addClient (final Client client) {
        this.clients.add(client);
    }

    /**
     * Искать клиентов по имени питомца
     * @param name Имя питомца
     * @return ArrayList клиентов или null
     */
    public ArrayList<Client> getClientsByPetName(final String name) {
        ArrayList<Client> result = new ArrayList<>();
        for (Client c : clients)
            if (c.getPet().getName().equalsIgnoreCase(name)) result.add(c);
        return result;
    }

    /**
     * Искать клиентов по имени
     * @param name Имя клиента
     * @return ArrayList клиентов или null
     */
    public ArrayList<Client> getClientsByName(final String name) {
        ArrayList<Client> result = new ArrayList<>();
        for (Client c : clients)
            if (c.getName().equalsIgnoreCase(name)) result.add(c);
        return result;
    }

    /**
     * Искать клиентов по ID
     * @param id  ID клиента
     * @return клиент или null
     */
    public Client getClientsById(final int id) {
        Client result = null;
        for (Client c : clients)
            if (c.getId() == id) result = c;
        return result;
    }

    /**
     * Удалить клиента по имени
     * @param name Имя клиента
     */
    public void removeClient(final String name) {
        clients.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    /**
     * Удалить клиента по ID
     * @param id ID клиента
     */
    public void removeClient(final int id) {
        clients.removeIf(c -> c.getId() == id);
    }
    /**
     * Получить список клиентов
     * @return ArrayList всех клиентов или null
     */
    public ArrayList<Client> getAllClients() {
        return clients;
    }
}
