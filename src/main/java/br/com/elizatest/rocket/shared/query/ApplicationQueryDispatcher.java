package br.com.elizatest.rocket.shared.query;

public interface ApplicationQueryDispatcher {
     <R, T extends ApplicationQuery<R>> void register(Class<T> commandType, ApplicationQueryExecutor<R, T> executor);

     <R> R execute(ApplicationQuery<R> cmd);
}
