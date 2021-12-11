package com.conacry.application.usecase;

import com.conacry.application.model.TaskData;

import java.util.UUID;

public interface CreateTask {

    UUID execute(TaskData data);
}
