package com.conacry.application.usecase;

import com.conacry.application.model.TaskData;

import java.util.UUID;

/**
 * Use case of task creation
 */
public interface CreateTask {

    /**
     * Execute use case
     *
     * Method create task, save it to a storage and
     * publish TaskCreatedEvent
     *
     * @param data Input params containing two integers
     * @return Identifier of task
     *
     * @throws IllegalArgumentException if data is null
     */
    UUID execute(TaskData data);
}
