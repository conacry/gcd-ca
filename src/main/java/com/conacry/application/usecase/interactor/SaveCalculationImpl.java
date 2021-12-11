package com.conacry.application.usecase.interactor;

import com.conacry.application.port.CalculationGateway;
import com.conacry.application.usecase.SaveCalculation;
import com.conacry.domain.value.Calculation;
import com.conacry.domain.value.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaveCalculationImpl implements SaveCalculation {

    private final CalculationGateway calculationGateway;

    public SaveCalculationImpl(CalculationGateway calculationGateway) {
        this.calculationGateway = calculationGateway;
    }

    @Override
    public void execute(Param n1, Param n2, Integer result) {
        if (calculationGateway.existsByParam(n1.getValue(), n2.getValue())) {
            log.info("Calculation with param ({}, {}) already exist", n1.getValue(), n2.getValue());
            return;
        }

        var calculation = Calculation.of(n1, n2, result);
        calculationGateway.save(calculation);
    }
}
