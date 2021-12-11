package com.conacry.infrastructure.db.mapper;

import com.conacry.application.model.TaskStatusModel;
import com.conacry.infrastructure.db.model.TaskDbModel;
import org.springframework.stereotype.Component;

@Component
public class TaskStatusMapper {

    public TaskStatusModel fromTaskModel(TaskDbModel taskModel) {
        var statusModel = new TaskStatusModel();

        statusModel.setIdentifier(taskModel.getIdentifier().toString());
        statusModel.setStatus(taskModel.getStatus());
        statusModel.setN1(taskModel.getN1());
        statusModel.setN2(taskModel.getN2());
        statusModel.setResult(taskModel.getResult());

        return statusModel;
    }
}
