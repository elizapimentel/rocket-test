package br.com.elizatest.rocket.domain.order.core;

import java.util.Optional;

public interface OrderRepository {
    
    Optional<Order> load(Integer id);
    void save(Order order);
    void deleteOrder(Order deleteOrder);
    
}
