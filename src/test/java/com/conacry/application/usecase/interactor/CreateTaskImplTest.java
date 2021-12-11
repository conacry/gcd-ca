package com.conacry.application.usecase.interactor;

import com.conacry.application.model.TaskData;
import com.conacry.application.port.EventPublisher;
import com.conacry.application.port.TaskGateway;
import com.conacry.application.usecase.CreateTask;
import com.conacry.domain.entity.Task;
import com.conacry.domain.event.TaskCreatedEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateTaskTest {

    private static final Integer TEST_N1 = 105;
    private static final Integer TEST_N2 = 45;

    @Mock
    private TaskGateway taskGateway;

    @Mock
    private EventPublisher eventPublisher;

    private CreateTask createTask;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createTask = new CreateTaskImpl(taskGateway, eventPublisher);
    }

    @Test
    void execute_ValidData_ReturnIdentifier() {
        var data = new TaskData();
        data.setN1(TEST_N1);
        data.setN2(TEST_N2);

        var result = createTask.execute(data);

        assertNotNull(result);

        verify(taskGateway, times(1)).save(any(Task.class));
        verify(eventPublisher, times(1)).publish(any(TaskCreatedEvent.class));
    }

    @Test
    void execute_DataIsNull_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> createTask.execute(null));
    }
}