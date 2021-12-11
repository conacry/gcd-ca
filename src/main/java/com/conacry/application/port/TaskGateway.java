package com.conacry.application.port;

import com.conacry.domain.entity.Task;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.UUID;

public interface TaskGateway {

    void save(@Nonnull Task task);

    void saveResult(@Nonnull Task value);

    Optional<Task> findByIdentifier(UUID identifier);
}
