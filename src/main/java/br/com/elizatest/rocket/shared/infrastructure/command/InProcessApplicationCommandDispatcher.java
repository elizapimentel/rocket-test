package br.com.elizatest.rocket.shared.infrastructure.command;

import java.util.HashMap;
import java.util.Map;

import br.com.elizatest.rocket.shared.command.ApplicationCommand;
import br.com.elizatest.rocket.shared.command.ApplicationCommandDispatcher;
import br.com.elizatest.rocket.shared.command.ApplicationCommandExecutor;

public class InProcessApplicationCommandDispatcher implements ApplicationCommandDispatcher {
    private final Map<Class<?>, ApplicationCommandExecutor<?, ?>> executors;

    public InProcessApplicationCommandDispatcher() {
        this.executors = new HashMap<>();
    }

    @Override
    public <R, T extends ApplicationCommand<R>> void register(Class<T> commandType, ApplicationCommandExecutor<R, T> executor) {
        this.executors.put(commandType, executor);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> R execute(ApplicationCommand<R> cmd) {
        
        ApplicationCommandExecutor<R, ApplicationCommand<R>> executor = (ApplicationCommandExecutor<R, ApplicationCommand<R>>) this.executors.getOrDefault(cmd.getClass(), null);
        if (executor == null) throw new IllegalStateException("No command executor for " + cmd.getClass() + " found.");
        var execute = executor.execute(cmd);
        return execute;
    }
}
