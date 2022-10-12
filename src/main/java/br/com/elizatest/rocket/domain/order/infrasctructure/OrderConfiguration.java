package br.com.elizatest.rocket.domain.order.infrasctructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.domain.order.application.commands.CreateOrderCommand;
import br.com.elizatest.rocket.domain.order.application.commands.CreateOrderCommandExecutor;
import br.com.elizatest.rocket.domain.order.core.OrderRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

@Configuration
public class OrderConfiguration {
    private final OrderRepositoryDAO dao;
    private final ApplicationCommandDispatcher commands;

    public OrderConfiguration(OrderRepositoryDAO dao, ApplicationCommandDispatcher commands) {
        this.dao = dao;
        this.commands = commands;
    }

    @Bean
    public ApplicationCommandExecutor<Void, CreateOrderCommand> createOrderCommandExecutor() {
        CreateOrderCommandExecutor executor = new CreateOrderCommandExecutor(this.orderRepository());
        commands.register(CreateOrderCommand.class, executor);
        return executor;
    }

    @Bean
    public OrderRepository orderRepository() {
        return new OrderJPARepository(dao);
    }

    
    
}
