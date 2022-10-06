package br.com.elizatest.rocket.shared.command;

public interface ApplicationCommandDispatcher {
     <R, T extends ApplicationCommand<R>> void register(Class<T> commandType, ApplicationCommandExecutor<R, T> executor);

     <R> R execute(ApplicationCommand<R> cmd);
}
