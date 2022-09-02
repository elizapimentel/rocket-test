package br.com.elizatest.rocket.service;

import java.util.ArrayList;

import br.com.elizatest.rocket.model.Client;

public interface IClientService {
	public ArrayList<Client> getAll(Boolean isDeleted);
	public Client getClientById(Integer id);
    public Client postClient(Client newClient);
    public Client updateClient(Integer id, Client updateClient);
    public void deleteClient(Integer id);

}
