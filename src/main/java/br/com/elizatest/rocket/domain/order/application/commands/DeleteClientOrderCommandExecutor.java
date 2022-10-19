package br.com.elizatest.rocket.domain.order.application.commands;

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.ClientOrderRepository;
import br.com.elizatest.rocket.domain.order.core.Order;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class DeleteClientOrderCommandExecutor implements ApplicationCommandExecutor<Void, DeleteClientOrderCommand> {
    private final ClientOrderRepository repository;
    private final OrderRepository orderRepository;

    public DeleteClientOrderCommandExecutor(ClientOrderRepository repository, OrderRepository orderRepository) {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Void execute(DeleteClientOrderCommand command) {
        // delete client without deleting order
        ClientOrder client = repository.load(command.id).get();
        Order order = orderRepository.load(command.id).get();
        client.setDeleted(true);
        if (client.getDeleted() == true) {
            order.getId();
            orderRepository.save(order);            
        }
        repository.updateClient(client);
        return null;
        
    }
    
}
