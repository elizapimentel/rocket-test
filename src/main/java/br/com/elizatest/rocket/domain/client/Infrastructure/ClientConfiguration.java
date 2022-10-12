package br.com.elizatest.rocket.domain.client.Infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.elizatest.rocket.domain.client.application.commands.CreateClientCommand;
import br.com.elizatest.rocket.domain.client.application.commands.CreateClientCommandExecutor;
import br.com.elizatest.rocket.domain.client.application.commands.DeleteClientCommand;
import br.com.elizatest.rocket.domain.client.application.commands.DeleteClientCommandExecutor;
import br.com.elizatest.rocket.domain.client.application.commands.UpdateClientCommand;
import br.com.elizatest.rocket.domain.client.application.commands.UpdateClientCommandExecutor;
import br.com.elizatest.rocket.domain.client.core.ClientRepository;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

@Configuration
public class ClientConfiguration {
    private final ClientRepositoryDAO dao;
    private final ApplicationCommandDispatcher commands;

    public ClientConfiguration(ApplicationCommandDispatcher commands, ClientRepositoryDAO dao) {
        this.commands = commands;
        this.dao = dao;

    }

    @Bean
    public ApplicationCommandExecutor<Void, CreateClientCommand> createClientCommandExecutor() {
        CreateClientCommandExecutor executor = new CreateClientCommandExecutor(this.clientRepository());
        commands.register(CreateClientCommand.class, executor);
        return executor;
    }

    @Bean
    public ApplicationCommandExecutor<Void, UpdateClientCommand> updateClientCommandExecutor() {
        UpdateClientCommandExecutor executor = new UpdateClientCommandExecutor(this.clientRepository());
        commands.register(UpdateClientCommand.class, executor);
        return executor;
    }

   
    @Bean
    public ClientRepository clientRepository() {
        return new ClientJPARepository(dao);
    }

    @Bean
    public ApplicationCommandExecutor<Void, DeleteClientCommand> deleteClientCommandExecutor() {
        DeleteClientCommandExecutor executor = new DeleteClientCommandExecutor(this.clientRepository());
        commands.register(DeleteClientCommand.class, executor);
        return executor;       
        
    }

}
