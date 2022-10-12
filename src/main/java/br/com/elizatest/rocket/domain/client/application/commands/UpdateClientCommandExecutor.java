package br.com.elizatest.rocket.domain.client.application.commands;

import br.com.elizatest.rocket.domain.client.core.ClientRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class UpdateClientCommandExecutor implements ApplicationCommandExecutor<Void, UpdateClientCommand> {

    private final ClientRepository repository;

    public UpdateClientCommandExecutor(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Void execute(UpdateClientCommand command) {        
        try {
            var client = repository.load(command.id).orElseThrow(() -> new IllegalAccessException("Id não encontrado"));
            client.update(command.name, command.cpf, command.email, command.phone, command.address, command.birth);
            repository.updateClient(client);
        } catch (IllegalAccessException e) {
            
            e.printStackTrace();
        }
        return null;
        
    }

 
}
