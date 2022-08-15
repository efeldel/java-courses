package petclinic;

/**
 * ����� ��������� �������
 */
public class Clinic {
    /**
     * ������ ��������
     */
    private final Client[] clients;
    /**
     * @param size ���������� �������� (������ �������)
     */
    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /**
     * �������� �������
     * @param client ������
     */
    public void addClient (final Client client) {
        this.clients[client.getId()] = client;
    }

    /**
     * ������ �������� �� ����� �������
     * @param name ��� �������
     * @return ������ �������� ��� null
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
     * ������ �������� �� �����
     * @param name ��� �������
     * @return ������ �������� ��� null
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
     * ������� ������� �� �����
     * @param name ��� �������
     */
    public void removeClient(final String name) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getName().equalsIgnoreCase(name)) clients[i] = null;
        }
    }

    /**
     * ������� ������� �� ID
     * @param id ID �������
     */
    public void removeClient(final int id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null && clients[i].getId() == id) clients[i] = null;
        }
    }
    /**
     * �������� ������ ��������
     * @return ������ ���� �������� ��� null
     */
    public Client[] getAllClients() {
        return clients;
    }
}
