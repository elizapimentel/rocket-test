package br.com.elizatest.rocket.domain.order.infrasctructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.domain.client.Infrastructure.ClientJPARepository;
import br.com.elizatest.rocket.domain.client.Infrastructure.ClientRepositoryDAO;
import br.com.elizatest.rocket.domain.client.core.ClientRepository;
import br.com.elizatest.rocket.domain.order.application.commands.CreateOrderCommand;
import br.com.elizatest.rocket.domain.order.application.commands.CreateOrderCommandExecutor;
import br.com.elizatest.rocket.domain.order.application.commands.DeleteOrderCommand;
import br.com.elizatest.rocket.domain.order.application.commands.DeleteOrderCommandExecutor;
import br.com.elizatest.rocket.domain.order.core.ClientOrderRepository;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

@Configuration
public class OrderConfiguration {
    private final OrderRepositoryDAO dao;
    private final ApplicationCommandDispatcher commands;
    private final ClientOrderRepositoryDAO clientDao;

    public OrderConfiguration(OrderRepositoryDAO dao, ApplicationCommandDispatcher commands,
    ClientOrderRepositoryDAO clientDao) {
        this.dao = dao;
        this.commands = commands;
        this.clientDao = clientDao;
    }

    @Bean
    public ApplicationCommandExecutor<Void, CreateOrderCommand> createOrderCommandExecutor() {
        CreateOrderCommandExecutor executor = new CreateOrderCommandExecutor(this.orderRepository(), this.clientOrderRepository());
        commands.register(CreateOrderCommand.class, executor);
        return executor;
    }

    @Bean
    public OrderRepository orderRepository() {
        return new OrderJPARepository(dao);
    }

    @Bean
    public ClientOrderRepository clientOrderRepository() {
        return new ClientOrderJPARepository(clientDao);
    }

    @Bean
    public ApplicationCommandExecutor<Void, DeleteOrderCommand> deleteOrderCommandExecutor() {
        DeleteOrderCommandExecutor executor = new DeleteOrderCommandExecutor(this.orderRepository());
        commands.register(DeleteOrderCommand.class, executor);
        return executor;
    }
    
    
}
