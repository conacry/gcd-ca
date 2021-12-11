package com.conacry.application.usecase.interactor;

import com.conacry.application.model.TaskStatusModel;
import com.conacry.application.port.TaskStatusGateway;
import com.conacry.application.usecase.FetchTaskStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FetchTaskStatusImpl implements FetchTaskStatus {

    private final TaskStatusGateway taskStatusGateway;

    public FetchTaskStatusImpl(TaskStatusGateway taskStatusGateway) {
        this.taskStatusGateway = taskStatusGateway;
    }

    @Override
    public TaskStatusModel execute(UUID identifier) {
        return taskStatusGateway.findByTaskIdentifier(identifier);
    }
}
