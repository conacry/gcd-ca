package com.conacry.application.usecase;

import com.conacry.application.model.TaskStatusModel;

import java.util.UUID;

public interface FetchTaskStatus {

    TaskStatusModel execute(UUID identifier);
}
