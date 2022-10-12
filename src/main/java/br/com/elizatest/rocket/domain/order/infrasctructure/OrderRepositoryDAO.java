package br.com.elizatest.rocket.domain.order.infrasctructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryDAO extends JpaRepository<OrderModel, Integer> {

}
