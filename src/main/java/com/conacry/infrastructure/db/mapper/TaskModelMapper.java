package com.conacry.infrastructure.db.mapper;

import com.conacry.domain.entity.Task;
import com.conacry.domain.entity.TaskStatus;
import com.conacry.domain.value.Param;
import com.conacry.infrastructure.db.model.TaskDbModel;
import org.springframework.stereotype.Component;

@Component
public class TaskModelMapper {

    public TaskDbModel toModel(Task task) {
        var model = new TaskDbModel();
        model.setIdentifier(task.getIdentifier());
        model.setStatus(task.getStatus().name());
        model.setN1(task.getN1().getValue());
        model.setN2(task.getN2().getValue());

        if (task.getResult() != null) {
            model.setResult(task.getResult());
        }

        return model;
    }

    public Task fromModel(TaskDbModel model) {
        var n1 = Param.of(model.getN1());
        var n2 = Param.of(model.getN2());
        return new Task(model.getIdentifier(), n1, n2, TaskStatus.valueOf(model.getStatus()), model.getResult());
    }
}
