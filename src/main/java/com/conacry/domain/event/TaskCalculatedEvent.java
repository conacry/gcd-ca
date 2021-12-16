package com.conacry.domain.event;

import com.conacry.domain.value.Param;
import com.conacry.shared.mark.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public final class TaskCalculatedEvent implements DomainEvent {

    private final UUID taskIdentifier;
    private final Param n1;
    private final Param n2;
    private final Integer result;

    public TaskCalculatedEvent(UUID taskIdentifier, Param n1, Param n2, Integer result) {
        this.taskIdentifier = taskIdentifier;
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;
    }
}
