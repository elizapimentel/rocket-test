package br.com.elizatest.rocket.domain.order.infrasctructure;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryDAO extends JpaRepository<OrderModel, Integer> {
    Optional<OrderModel> findById(Integer id);
   

}
