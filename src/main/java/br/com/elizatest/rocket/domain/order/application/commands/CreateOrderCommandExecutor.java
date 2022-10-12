package br.com.elizatest.rocket.domain.order.application.commands;

import br.com.elizatest.rocket.domain.order.core.Order;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class CreateOrderCommandExecutor implements ApplicationCommandExecutor<Void, CreateOrderCommand> {

    private final OrderRepository repository;

    public CreateOrderCommandExecutor(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(CreateOrderCommand command) {
        Order order = new Order(null, command.deliveryAddress, command.totalOrder, command.client_id, command.items);
        repository.save(order);
        return null;
    }

    
    
}
