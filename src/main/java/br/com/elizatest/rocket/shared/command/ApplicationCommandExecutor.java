package br.com.elizatest.rocket.shared.command;

public interface ApplicationCommandExecutor<R, T extends ApplicationCommand<R>> {
    R execute(T command);
}
