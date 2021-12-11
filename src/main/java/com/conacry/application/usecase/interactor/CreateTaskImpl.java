package com.conacry.application.usecase.interactor;

import com.conacry.application.model.TaskData;
import com.conacry.application.port.EventPublisher;
import com.conacry.application.port.TaskGateway;
import com.conacry.application.usecase.CreateTask;
import com.conacry.domain.entity.Task;
import com.conacry.domain.value.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CreateTaskImpl implements CreateTask {

    public final TaskGateway taskGateway;
    public final EventPublisher eventPublisher;

    public CreateTaskImpl(
            TaskGateway taskGateway,
            EventPublisher eventPublisher
    ) {
        this.taskGateway = taskGateway;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UUID execute(TaskData data) {

        if (data == null) {
            log.warn("Task data cannot be null");
            throw new IllegalArgumentException("Task data cannot be null");
        }

        var n1 = Param.of(data.getN1());
        var n2 = Param.of(data.getN2());
        var result = Task.create(n1, n2);

        taskGateway.save(result.getValue());
        eventPublisher.publish(result.getEvent());
        return result.getEvent().getTaskIdentifier();
    }
}
