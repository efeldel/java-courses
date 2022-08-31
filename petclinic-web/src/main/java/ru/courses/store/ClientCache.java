package ru.courses.store;

import ru.courses.Client;
import ru.courses.Pet;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class ClientCache {
    private static final ClientCache INSTANCE = new ClientCache();
    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();
    private ClientCache() {}

    public static ClientCache getInstance() {
        return INSTANCE;
    }

    public Collection<Client> values() {
        return this.clients.values();
    }

    public void add(final Client client) {
        this.clients.put(client.getId(), client);
    }

    public void edit(final Client client, String newName, Pet newPet) {
        client.setName(newName);
        client.setPet(newPet);
        this.clients.replace(client.getId(), client);
    }

    public void delete(final int id) {
        this.clients.remove(id);
    }

    public Client get(final int id) {
        return this.clients.get(id);
    }
}
