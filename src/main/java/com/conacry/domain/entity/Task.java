package com.conacry.domain.entity;

import com.conacry.domain.event.CalculatedTaskEvent;
import com.conacry.domain.event.TaskCreatedEvent;
import com.conacry.domain.value.Calculation;
import com.conacry.domain.value.GcdAlgorithm;
import com.conacry.domain.value.Param;
import com.conacry.shared.ResultWithEvent;
import com.conacry.shared.mark.Entity;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Getter
public class Task implements Entity {

    private final UUID identifier;
    private final Param n1;
    private final Param n2;
    private Integer result;
    private TaskStatus status;

    public static ResultWithEvent<Task, TaskCreatedEvent> create(Param n1, Param n2) {
        if (n1.getValue() == 0 && n2.getValue() == 0) {
            log.warn("All integers cannot be zero");
            throw new IllegalArgumentException("All integers cannot be zero");
        }

        var task = new Task(UUID.randomUUID(), n1, n2, TaskStatus.CREATED);

        return ResultWithEvent.of(task, new TaskCreatedEvent(task.identifier, task.status));
    }

    private Task(UUID identifier, Param n1, Param n2, TaskStatus status) {
        this.identifier = identifier;
        this.status = status;
        this.n1 = n1;
        this.n2 = n2;
    }

    public Task(UUID identifier, Param n1, Param n2, TaskStatus status, Integer result) {
        this.identifier = identifier;
        this.status = status;
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;
    }

    public ResultWithEvent<Task, CalculatedTaskEvent> calculate(Calculation calculation) {
        if (calculation.getResult() == null) {
            log.warn("Calculation must have result");
            throw new IllegalStateException("Calculation must have result");
        }

        this.result = calculation.getResult();
        this.status = TaskStatus.DONE;
        return ResultWithEvent.of(this, new CalculatedTaskEvent(this.identifier, this.n1, this.n2, this.result));
    }

    public ResultWithEvent<Task, CalculatedTaskEvent> calculate(GcdAlgorithm algorithm) {
        this.result = algorithm.execute(n1.getValue(), n2.getValue());
        this.status = TaskStatus.DONE;

        return ResultWithEvent.of(this, new CalculatedTaskEvent(this.identifier, this.n1, this.n2, this.result));
    }
}
