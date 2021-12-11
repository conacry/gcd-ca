package com.conacry.infrastructure.event;

import com.conacry.application.usecase.CalculateGcd;
import com.conacry.domain.event.TaskCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskCreatedEventListener {

    private final CalculateGcd calculateGcd;

    public TaskCreatedEventListener(CalculateGcd calculateGcd) {
        this.calculateGcd = calculateGcd;
    }

    @EventListener(classes = { TaskCreatedEvent.class })
    public void handleEvent(TaskCreatedEvent taskCreatedEvent) {
        calculateGcd.execute(taskCreatedEvent.getTaskIdentifier());
    }
}
