package br.com.elizatest.rocket.shared.event;

public interface ApplicationEventBus {

    <T extends ApplicationEvent> void on(Class<T> eventClass, ApplicationEventListener<T> listener);

    <T extends ApplicationEvent> void publish(T event);

}
