package br.com.elizatest.rocket.domain.order.application.commands;

import br.com.elizatest.rocket.domain.order.core.Order;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class DeleteOrderCommandExecutor implements ApplicationCommandExecutor<Void, DeleteOrderCommand> {

    private final OrderRepository repository;    

    public DeleteOrderCommandExecutor(OrderRepository repository) {
        this.repository = repository;

    }


    @Override
    public Void execute(DeleteOrderCommand command) {
        Order deleteOrder = repository.load(command.id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
        deleteOrder.delete();
        repository.deleteOrder(deleteOrder);
        return null;
    }
  
}
