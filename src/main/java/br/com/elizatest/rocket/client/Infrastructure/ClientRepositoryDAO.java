package br.com.elizatest.rocket.client.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoryDAO extends JpaRepository<ClientModel, Integer>{
	ClientModel findByEmail(String email); 
	

}
