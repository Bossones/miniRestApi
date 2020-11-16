package net.bossones.rest_api.service;

import net.bossones.rest_api.users.Client;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void create(Client client) {
        final int clientId = atomicInteger.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}
