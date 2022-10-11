package br.com.elizatest.rocket.client.Infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepositoryDAO extends JpaRepository<ClientModel, Integer>{
	ClientModel findByEmail(String email); 
	@Query("SELECT c FROM ClientModel c WHERE c.id = ?1 AND c.deleted = false")
	Optional<ClientModel> findById(Integer id);
	@Query("SELECT c FROM ClientModel c WHERE c.deleted = false")
	List<ClientModel> findAll();

}
