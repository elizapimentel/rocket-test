package br.com.elizatest.rocket.client.Infrastructure;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.client.application.queries.GetAllClients;
import br.com.elizatest.rocket.client.application.queries.GetAllClientsExecutor;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;

@Configuration
public class GetAllClientsConfig {
    public final ClientRepositoryDAO dao;
    public final ApplicationQueryDispatcher queryDispatcher;

    public GetAllClientsConfig(ClientRepositoryDAO dao, ApplicationQueryDispatcher query) {
        this.dao = dao;
        this.queryDispatcher = query;
    }

    @Bean
    ApplicationQueryExecutor<List<GetAllClients.ClientResult>, GetAllClients> getAllClientsExecutor() {
        var executor = new GetAllClientsExecutor(dao);
        queryDispatcher.register(GetAllClients.class, executor);
        return executor;
    }

    
    
}
