package br.com.elizatest.rocket.domain.order.infrasctructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.domain.order.application.queries.GetOrderById;
import br.com.elizatest.rocket.domain.order.application.queries.GetOrderByIdExecutor;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;

@Configuration
public class GetOrderByIdConfig {
    public final OrderRepositoryDAO dao;
    public final ApplicationQueryDispatcher queryDispatcher;

    public GetOrderByIdConfig(OrderRepositoryDAO dao, ApplicationQueryDispatcher queryDispatcher) {
        this.dao = dao;
        this.queryDispatcher = queryDispatcher;
    }

    @Bean
    ApplicationQueryExecutor<GetOrderById.OrderResult, GetOrderById> getOrderByIdExecutor() {
        var executor = new GetOrderByIdExecutor(dao);
        queryDispatcher.register(GetOrderById.class, executor);
        return executor;
    }
    
}
