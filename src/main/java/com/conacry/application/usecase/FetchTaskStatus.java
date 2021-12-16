package com.conacry.application.usecase;

import com.conacry.application.model.TaskStatusModel;

import java.util.UUID;

/**
 * Use case of looking for information
 * about task state
 */
public interface FetchTaskStatus {

    /**
     * Execute use case
     *
     * Method looks for task in a storage and return information about it
     *
     * @param identifier Identifier of task
     * @return Information about task state
     */
    TaskStatusModel execute(UUID identifier);
}
