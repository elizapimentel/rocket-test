package br.com.elizatest.rocket.domain.order.infrasctructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepositoryDAO extends JpaRepository<ClientOrderModel, Integer>{
    ClientOrderModel findByEmail(String email);

    
}
