package ru.courses;

import java.util.ArrayList;

/**
 * ����� ��������� �������
 */
public class Clinic {
    /**
     * ������ ��������
     */
    private final ArrayList<Client> clients;
    /**
     *
     */
    public Clinic() {
        clients = new ArrayList<>();
    }

    /**
     * �������� �������
     * @param client ������
     */
    public void addClient (final Client client) {
        this.clients.add(client);
    }

    /**
     * ������ �������� �� ����� �������
     * @param name ��� �������
     * @return ArrayList �������� ��� null
     */
    public ArrayList<Client> getClientsByPetName(final String name) {
        ArrayList<Client> result = new ArrayList<>();
        for (Client c : clients)
            if (c.getPet().getName().equalsIgnoreCase(name)) result.add(c);
        return result;
    }

    /**
     * ������ �������� �� �����
     * @param name ��� �������
     * @return ArrayList �������� ��� null
     */
    public ArrayList<Client> getClientsByName(final String name) {
        ArrayList<Client> result = new ArrayList<>();
        for (Client c : clients)
            if (c.getName().equalsIgnoreCase(name)) result.add(c);
        return result;
    }

    /**
     * ������ �������� �� ID
     * @param id  ID �������
     * @return ������ ��� null
     */
    public Client getClientsById(final int id) {
        Client result = null;
        for (Client c : clients)
            if (c.getId() == id) result = c;
        return result;
    }

    /**
     * ������� ������� �� �����
     * @param name ��� �������
     */
    public void removeClient(final String name) {
        clients.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    /**
     * ������� ������� �� ID
     * @param id ID �������
     */
    public void removeClient(final int id) {
        clients.removeIf(c -> c.getId() == id);
    }
    /**
     * �������� ������ ��������
     * @return ArrayList ���� �������� ��� null
     */
    public ArrayList<Client> getAllClients() {
        return clients;
    }
}
