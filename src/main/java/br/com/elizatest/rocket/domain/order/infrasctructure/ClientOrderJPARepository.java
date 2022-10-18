package br.com.elizatest.rocket.domain.order.infrasctructure;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.ClientOrderRepository;

@Service
public class ClientOrderJPARepository implements ClientOrderRepository {
    private final ClientOrderRepositoryDAO dao;

    public ClientOrderJPARepository(ClientOrderRepositoryDAO dao) {
        this.dao = dao;
    }

    @Override
    public Optional<ClientOrder> load(Integer id) {
        var clientOrder = dao.findById(id).orElse(null);
        if (clientOrder != null) {
            return Optional.of(clientOrder.toClient());
        }        
        return Optional.empty();
    }

    @Override
    public void save(ClientOrder client) {
        ClientOrderModel clientOrder = new ClientOrderModel();
        clientOrder.setId(client.getId());
        clientOrder.setAddress(client.getAddress());
        clientOrder.setBirth(client.getBirth());
        clientOrder.setCpf(client.getCpf());
        clientOrder.setEmail(client.getEmail());
        clientOrder.setName(client.getName());
        clientOrder.setPhone(client.getPhone());
        clientOrder.setDeleted(client.getDeleted());
        dao.save(clientOrder);
       
    }

    @Override
    public ClientOrder updateClient(ClientOrder updateClient) {
        ClientOrderModel client = new ClientOrderModel(updateClient.getId(), updateClient.getName(), updateClient.getCpf(), updateClient.getEmail(), updateClient.getPhone(), updateClient.getAddress(), updateClient.getBirth(), updateClient.getDeleted());;     
        dao.save(client);
        return updateClient;        
    }

    @Override
    public void deleteClient(ClientOrder deleteClient) {
        ClientOrderModel client = new ClientOrderModel(deleteClient.getId(), deleteClient.getName(), deleteClient.getCpf(), deleteClient.getEmail(),deleteClient.getPhone(), deleteClient.getAddress(), deleteClient.getBirth(), deleteClient.getDeleted());
        client.setDeleted(true);
        dao.save(client);    
        
    }

    @Override
    public Boolean emailExists(String email) {
       return dao.findByEmail(email) != null;
    }

    

    

    
}
