package br.com.elizatest.rocket.shared.infrastructure.query;


import java.util.HashMap;
import java.util.Map;

import br.com.elizatest.rocket.shared.query.ApplicationQuery;
import br.com.elizatest.rocket.shared.query.ApplicationQueryDispatcher;
import br.com.elizatest.rocket.shared.query.ApplicationQueryExecutor;


public class InProcessApplicationQueryDispatcher implements ApplicationQueryDispatcher {
    private final Map<Class<?>, ApplicationQueryExecutor<?, ?>> executors;

    public InProcessApplicationQueryDispatcher() {
        this.executors = new HashMap<>();
    }

    @Override
    public <R, T extends ApplicationQuery<R>> void register(Class<T> commandType, ApplicationQueryExecutor<R, T> executor) {
        this.executors.put(commandType, executor);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> R execute(ApplicationQuery<R> cmd) {
        ApplicationQueryExecutor<R, ApplicationQuery<R>> executor = (ApplicationQueryExecutor<R, ApplicationQuery<R>>) this.executors.getOrDefault(cmd.getClass(), null);
        if (executor == null) throw new IllegalStateException("No query executor for " + cmd.getClass() + " found.");
        var execute = executor.execute(cmd);
        return execute;
    }

}
