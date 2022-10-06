package br.com.elizatest.rocket.client.core;

import java.util.Optional;

public interface ClientRepository {
    
    void save(Client client);
    Optional<Client> load(Integer id);
    Client updateClient(Client updateClient);
   
}
