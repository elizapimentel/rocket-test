package br.com.elizatest.rocket.shared.query;

public interface ApplicationQueryExecutor<R, T extends ApplicationQuery<R>> {
    R execute(T command);
}
