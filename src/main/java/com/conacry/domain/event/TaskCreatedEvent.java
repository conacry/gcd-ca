package com.conacry.domain.event;

import com.conacry.domain.entity.TaskStatus;
import com.conacry.shared.mark.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public final class TaskCreatedEvent implements DomainEvent {

    private final UUID taskIdentifier;
    private final TaskStatus status;

    public TaskCreatedEvent(UUID taskIdentifier, TaskStatus status) {
        this.taskIdentifier = taskIdentifier;
        this.status = status;
    }
}

