package com.conacry.application.usecase;

import java.util.UUID;

/**
 * Use case of task calculation
 */
public interface CalculateGcd {

    /**
     * Execute use case
     * <p>
     * Method calculate GCD, update task in a storage and
     * publish TaskCalculatedEvent
     *
     * @param taskIdentifier Identifier of task
     * @throws IllegalStateException if task wasn't created
     */
    void execute(UUID taskIdentifier);
}
