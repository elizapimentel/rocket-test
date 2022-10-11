package br.com.elizatest.rocket.client.core;

import java.util.Optional;

public interface ClientRepository {
    //Optional<Client> findAll(Boolean isDeleted); //precisa?
    Optional<Client> load(Integer id); 
    void save(Client client);
    Client updateClient(Client updateClient);
    void deleteClient(Client deleteClient);
    Boolean emailExists(String email);
   
}
