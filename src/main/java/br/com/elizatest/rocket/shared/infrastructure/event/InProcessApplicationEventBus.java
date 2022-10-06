package br.com.elizatest.rocket.shared.infrastructure.event;

import java.util.*;

import br.com.elizatest.rocket.shared.event.ApplicationEvent;
import br.com.elizatest.rocket.shared.event.ApplicationEventBus;
import br.com.elizatest.rocket.shared.event.ApplicationEventListener;

public class InProcessApplicationEventBus implements ApplicationEventBus {

    private final Map<Class<?>, List<ApplicationEventListener<?>>> listeners = new HashMap<>();

    @Override
    public <T extends ApplicationEvent> void on(Class<T> eventClass, ApplicationEventListener<T> listener) {
        listeners
                .computeIfAbsent(eventClass, (k) -> new ArrayList<>())
                .add(listener);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ApplicationEvent> void publish(T event) {
        var eventClass = event.getClass();
        listeners
                .computeIfAbsent(eventClass, (k) -> new ArrayList<>())
                .forEach((rawListener) -> {
                    var listener = ((ApplicationEventListener<T>) rawListener);
                    listener.handle(event);
                });
    }
}
