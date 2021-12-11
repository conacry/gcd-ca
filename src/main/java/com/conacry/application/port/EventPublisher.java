package com.conacry.application.port;

import com.conacry.shared.mark.DomainEvent;

public interface EventPublisher {

    <T extends DomainEvent> void publish(T event);
}
