package com.conacry.infrastructure.db.repository;

import com.conacry.application.model.TaskStatusModel;
import com.conacry.application.port.TaskStatusGateway;
import com.conacry.infrastructure.db.dao.TaskDao;
import com.conacry.infrastructure.db.mapper.TaskStatusMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TaskStatusRepository implements TaskStatusGateway {

    private final TaskDao taskDao;
    private final TaskStatusMapper taskStatusMapper;

    public TaskStatusRepository(TaskDao taskDao,
            TaskStatusMapper taskStatusMapper) {
        this.taskDao = taskDao;
        this.taskStatusMapper = taskStatusMapper;
    }

    @Override
    public TaskStatusModel findByTaskIdentifier(UUID identifier) {
        var taskModel = taskDao.getById(identifier);
        return taskStatusMapper.fromTaskModel(taskModel);
    }
}
