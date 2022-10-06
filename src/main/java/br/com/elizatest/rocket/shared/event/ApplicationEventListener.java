package br.com.elizatest.rocket.shared.event;

public interface ApplicationEventListener<T extends ApplicationEvent> {

    void handle(T event);

}
