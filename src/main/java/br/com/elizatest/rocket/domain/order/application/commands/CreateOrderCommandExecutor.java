package br.com.elizatest.rocket.domain.order.application.commands;

import java.util.stream.Collectors;

import br.com.elizatest.rocket.domain.order.core.ClientOrder;
import br.com.elizatest.rocket.domain.order.core.ClientOrderRepository;
import br.com.elizatest.rocket.domain.order.core.Order;
import br.com.elizatest.rocket.domain.order.core.OrderItem;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class CreateOrderCommandExecutor implements ApplicationCommandExecutor<Void, CreateOrderCommand> {

    private final OrderRepository repository;
    private final ClientOrderRepository clientRepository;

    public CreateOrderCommandExecutor(OrderRepository repository, ClientOrderRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Void execute(CreateOrderCommand command) {
        var items = command.items
        .stream()
        .map(item -> new OrderItem(item.sku, item.name, item.value, item.quantity))
        .collect(Collectors.toList());
        ClientOrder client = clientRepository.load(command.client.id).get();
        if (client != null) {
            client.setName(command.client.name);
            client.setCpf(command.client.cpf);
            client.setEmail(command.client.email);
            client.setPhone(command.client.phone);
            client.setAddress(command.client.address);
            client.setBirth(command.client.birth);
            clientRepository.save(client);   
        } else {
            client = new ClientOrder(command.client.id, command.client.name, command.client.cpf, command.client.email, command.client.phone, command.client.address, command.client.birth);
            clientRepository.save(client);
        }
        // convertendo para order para verificar se está seguindo regra de negocio
        Order order = new Order(null, command.deliveryAddress, command.totalOrder, client, items);
        repository.save(order);
        return null;
    }   
    
}       

