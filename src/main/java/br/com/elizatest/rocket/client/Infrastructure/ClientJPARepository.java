package br.com.elizatest.rocket.client.Infrastructure;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.elizatest.rocket.client.core.Client;
import br.com.elizatest.rocket.client.core.ClientRepository;

@Service
public class ClientJPARepository implements ClientRepository {

    private final ClientRepositoryDAO dao;

    public ClientJPARepository(ClientRepositoryDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(br.com.elizatest.rocket.client.core.Client client) {
        ClientModel clientModel = new ClientModel();
        clientModel.setId(client.getId());
        clientModel.setAddress(client.getAddress());
        clientModel.setBirth(client.getBirth());
        clientModel.setCpf(client.getCpf());
        clientModel.setEmail(client.getEmail());
        clientModel.setName(client.getName());
        clientModel.setPhone(client.getPhone());
        clientModel.setDeleted(client.getDeleted());
        dao.save(clientModel);
       
    }

    @Override
    public Client updateClient(Client updateClient) {
        ClientModel client = new ClientModel(updateClient.getId(), updateClient.getName(), updateClient.getCpf(), updateClient.getEmail(), updateClient.getPhone(), updateClient.getAddress(), updateClient.getBirth(), updateClient.getDeleted());;     
        dao.save(client);
        return updateClient;        
    }

    @Override
    public Optional<Client> load(Integer id) {
      var client = dao.findById(id).orElse(null);
        if(client != null) {
            return Optional.of(client.toClient());
        }
        return Optional.empty();
    
    }

    @Override
    public void deleteClient(Client deleteClient) {
        ClientModel client = new ClientModel(deleteClient.getId(), deleteClient.getName(), deleteClient.getCpf(), deleteClient.getEmail(),deleteClient.getPhone(), deleteClient.getAddress(), deleteClient.getBirth(), deleteClient.getDeleted());
        client.setDeleted(true);
        dao.save(client);
    }

    @Override
    public Boolean emailExists(String email) {
        return dao.findByEmail(email) != null;
       
    }

  
   

   
   
    
}
