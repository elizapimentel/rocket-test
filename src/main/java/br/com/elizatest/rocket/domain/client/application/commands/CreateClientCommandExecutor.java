package br.com.elizatest.rocket.domain.client.application.commands;

import br.com.elizatest.rocket.domain.client.core.Client;
import br.com.elizatest.rocket.domain.client.core.ClientRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class CreateClientCommandExecutor implements ApplicationCommandExecutor<Void, CreateClientCommand> {

    private final ClientRepository repository;

    public CreateClientCommandExecutor(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(CreateClientCommand command) {
        Client client = new Client(null, command.name, command.cpf, command.email, command.phone, command.address, command.birth);
        repository.save(client);
        return null;
    }

    
    
}
