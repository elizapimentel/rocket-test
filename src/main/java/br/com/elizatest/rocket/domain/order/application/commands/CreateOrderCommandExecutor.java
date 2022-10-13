package br.com.elizatest.rocket.domain.order.application.commands;

import java.util.stream.Collectors;

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.Order;
import br.com.elizatest.rocket.domain.order.core.OrderItem;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class CreateOrderCommandExecutor implements ApplicationCommandExecutor<Void, CreateOrderCommand> {

    private final OrderRepository repository;

    public CreateOrderCommandExecutor(OrderRepository repository) {
        this.repository = repository;
    }


    @Override
    public Void execute(CreateOrderCommand command) {
        var client = new ClientOrder(command.client_id.id, command.client_id.name, command.client_id.cpf, command.client_id.email, command.client_id.phone, command.client_id.address, command.client_id.birth);
        var items = command.items
        .stream()
        .map(item -> new OrderItem(item.sku, item.name, item.value, item.quantity))
        .collect(Collectors.toList());
        // convertendo para order para verificar se está seguindo regra de negocio
        Order order = new Order(null, command.deliveryAddress, command.totalOrder, client, items);
        repository.save(order);
        return null;
    }


    
    
}
