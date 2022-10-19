package br.com.elizatest.rocket.domain.order.core;

import java.util.Optional;


public interface ClientOrderRepository {
    Optional<ClientOrder> load(Integer id); 
    void save(ClientOrder client);
    ClientOrder updateClient(ClientOrder updateClient);
    void deleteClient(ClientOrder deleteClient);
    Boolean emailExists(String email);
   
}
