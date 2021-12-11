package com.conacry.application.usecase.interactor;

import com.conacry.application.port.CalculationGateway;
import com.conacry.application.port.EventPublisher;
import com.conacry.application.port.TaskGateway;
import com.conacry.application.usecase.CalculateGcd;
import com.conacry.domain.value.EuclidAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CalculateGcdImpl implements CalculateGcd {

    private final TaskGateway taskGateway;
    private final EventPublisher eventPublisher;
    private final CalculationGateway calculationGateway;

    public CalculateGcdImpl(
            TaskGateway taskGateway,
            EventPublisher eventPublisher,
            CalculationGateway calculationGateway) {
        this.taskGateway = taskGateway;
        this.eventPublisher = eventPublisher;
        this.calculationGateway = calculationGateway;
    }

    @Override
    public void execute(UUID taskIdentifier) {
        var task = taskGateway.findByIdentifier(taskIdentifier)
                .orElseThrow(() -> {
                    log.error("Task didn't create");
                    return new IllegalStateException("Task didn't create");
                });

        var n1Value = task.getN1().getValue();
        var n2Value = task.getN2().getValue();
        var calculationOpt = calculationGateway.findByParam(n1Value, n2Value);

        var result = calculationOpt.isPresent()
                ? task.calculate(calculationOpt.get())
                : task.calculate(new EuclidAlgorithm());

        taskGateway.saveResult(result.getValue());
        eventPublisher.publish(result.getEvent());
    }
}

