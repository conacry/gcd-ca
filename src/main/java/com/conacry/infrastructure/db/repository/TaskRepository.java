package com.conacry.infrastructure.db.repository;

import com.conacry.application.port.TaskGateway;
import com.conacry.domain.entity.Task;
import com.conacry.infrastructure.db.dao.TaskDao;
import com.conacry.infrastructure.db.mapper.TaskModelMapper;
import com.conacry.infrastructure.db.model.TaskDbModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class TaskRepository implements TaskGateway {

    private final TaskDao taskDao;
    private final TaskModelMapper taskModelMapper;

    public TaskRepository(TaskDao taskDao, TaskModelMapper taskModelMapper) {
        this.taskDao = taskDao;
        this.taskModelMapper = taskModelMapper;
    }

    @Override
    @Transactional
    public void save(@Nonnull Task task) {
        Objects.requireNonNull(task);
        var model = taskModelMapper.toModel(task);
        taskDao.save(model);
    }

    @Override
    @Transactional
    public void saveResult(@Nonnull Task task) {
        Objects.requireNonNull(task);
        var model = taskModelMapper.toModel(task);
        taskDao.addResult(model.getIdentifier(), model.getResult(), model.getStatus());
    }

    @Override
    public Optional<Task> findByIdentifier(@Nullable UUID identifier) {
        if (identifier == null) {
            return Optional.empty();
        }

        TaskDbModel model;

        try {
            model = taskDao.getById(identifier);
            var task = taskModelMapper.fromModel(model);
            return Optional.of(task);
        } catch (EntityNotFoundException ex) {
            log.warn("Task with identifier {} not found", identifier);
            return Optional.empty();
        }
    }
}
