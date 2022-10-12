package br.com.elizatest.rocket.domain.client.application.queries;

import java.util.List;
import java.util.stream.Collectors;

import br.com.elizatest.rocket.domain.client.Infrastructure.ClientRepositoryDAO;
import br.com.elizatest.rocket.domain.client.application.queries.GetAllClients.ClientResult;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;

public class GetAllClientsExecutor implements ApplicationQueryExecutor<List<GetAllClients.ClientResult>, GetAllClients> {
    public final ClientRepositoryDAO dao;    

    public GetAllClientsExecutor(ClientRepositoryDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ClientResult> execute(GetAllClients command) {
        var client = dao.findAll();
        var result = client.stream().map(c -> 
            new ClientResult(c.getName(), c.getCpf(), c.getEmail(), c.getPhone(), c.getAddress(), c.getBirth())
        ).collect(Collectors.toList());
        return result;
    }

    

}
