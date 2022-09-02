package br.com.elizatest.rocket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elizatest.rocket.model.Client;

public interface ClientDAO extends JpaRepository<Client, Integer>{
	Client findByEmail(String email);

}
