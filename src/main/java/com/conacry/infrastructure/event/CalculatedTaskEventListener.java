package com.conacry.infrastructure.event;

import com.conacry.application.usecase.SaveCalculation;
import com.conacry.domain.event.CalculatedTaskEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatedTaskEventListener {

    private final SaveCalculation saveCalculation;

    public CalculatedTaskEventListener(SaveCalculation saveCalculation) {
        this.saveCalculation = saveCalculation;
    }

    @EventListener(classes = { CalculatedTaskEvent.class })
    public void handleEvent(CalculatedTaskEvent event) {
        saveCalculation.execute(event.getN1(), event.getN2(), event.getResult());
    }
}
