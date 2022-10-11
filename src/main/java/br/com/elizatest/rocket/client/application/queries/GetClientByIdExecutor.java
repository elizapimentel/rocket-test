package br.com.elizatest.rocket.client.application.queries;


import br.com.elizatest.rocket.client.Infrastructure.ClientRepositoryDAO;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;

public class GetClientByIdExecutor implements ApplicationQueryExecutor<GetClientById.ClientResult, GetClientById> {
    public final ClientRepositoryDAO dao;

    public GetClientByIdExecutor(ClientRepositoryDAO dao) {
        this.dao = dao;
    }

    @Override
    public GetClientById.ClientResult execute(GetClientById command) {
        var client = dao.findById(command.id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));       
        return new GetClientById.ClientResult(client.getName(), client.getCpf(), client.getEmail(), client.getPhone(), client.getAddress(), client.getBirth());
       
    }
}
    
