package com.conacry.application.port;

import com.conacry.application.model.TaskStatusModel;

import java.util.UUID;

public interface TaskStatusGateway {

    TaskStatusModel findByTaskIdentifier(UUID identifier);
}
