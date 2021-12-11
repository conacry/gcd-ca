package com.conacry.application.usecase.interactor;

import com.conacry.application.port.CalculationGateway;
import com.conacry.application.usecase.SaveCalculation;
import com.conacry.domain.value.Calculation;
import com.conacry.domain.value.Param;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SaveCalculationTest {

    private static final Param TEST_N1_PARAM = Param.of(105);
    private static final Param TEST_N2_PARAM = Param.of(45);
    private static final Integer TEST_RESULT = 15;

    @Mock
    private CalculationGateway calculationGateway;

    private SaveCalculation saveCalculation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        saveCalculation = new SaveCalculationImpl(calculationGateway);
    }

    @Test
    void execute_CalculationNotExist_GatewayInvoked() {
        when(calculationGateway.existsByParam(TEST_N1_PARAM.getValue(), TEST_N2_PARAM.getValue()))
                .thenReturn(Boolean.FALSE);

        saveCalculation.execute(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT);

        var calculation = Calculation.of(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT);
        verify(calculationGateway, times(1)).save(calculation);
    }

    @Test
    void execute_CalculationExist_GatewayNotInvoked() {
        when(calculationGateway.existsByParam(TEST_N1_PARAM.getValue(), TEST_N2_PARAM.getValue()))
                .thenReturn(Boolean.TRUE);

        saveCalculation.execute(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT);

        verify(calculationGateway, never()).save(any(Calculation.class));
    }
}