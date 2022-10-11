package br.com.elizatest.rocket.client.Infrastructure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.client.application.queries.GetClientById;
import br.com.elizatest.rocket.client.application.queries.GetClientByIdExecutor;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;


@Configuration
public class GetClientByIdConfig {
    public final ClientRepositoryDAO dao;
    public final ApplicationQueryDispatcher queryDispatcher;

    public GetClientByIdConfig(ApplicationQueryDispatcher query, ClientRepositoryDAO dao) {
        this.queryDispatcher = query;
        this.dao = dao;
    }

    @Bean
    ApplicationQueryExecutor<GetClientById.ClientResult, GetClientById> getClientByIdExecutor() {
        var executor = new GetClientByIdExecutor(dao);
        queryDispatcher.register(GetClientById.class, executor);
        return executor;
    }


}
