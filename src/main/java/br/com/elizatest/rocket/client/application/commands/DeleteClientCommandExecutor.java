package br.com.elizatest.rocket.client.application.commands;

import br.com.elizatest.rocket.client.application.DeleteClientCommand;
import br.com.elizatest.rocket.client.core.Client;
import br.com.elizatest.rocket.client.core.ClientRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class DeleteClientCommandExecutor implements ApplicationCommandExecutor<Void, DeleteClientCommand> {
    private final ClientRepository repository;

    public DeleteClientCommandExecutor(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(DeleteClientCommand command) {
        // delete client informing the id and changing the status of deleted to true
        Client client = repository.load(command.id).get();
        client.setDeleted(true);
        repository.updateClient(client);
        return null;
        
    }
}   
