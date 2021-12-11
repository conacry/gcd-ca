package com.conacry.domain.entity;

import com.conacry.domain.value.Calculation;
import com.conacry.domain.value.EuclidAlgorithm;
import com.conacry.domain.value.Param;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private static final Param ZERO_PARAM = Param.of(0);
    private static final Param TEST_N1_PARAM = Param.of(105);
    private static final Param TEST_N2_PARAM = Param.of(45);
    private static final Integer TEST_RESULT = 15;

    @Test
    void create_AllParamIsZero_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> Task.create(ZERO_PARAM, ZERO_PARAM));
    }

    @Test
    void create_AllParamIsValid_TaskCreated() {
        var result = Task.create(TEST_N1_PARAM, TEST_N2_PARAM);

        var task = result.getValue();
        assertEquals(TEST_N1_PARAM, task.getN1());
        assertEquals(TEST_N2_PARAM, task.getN2());

        var event = result.getEvent();
        assertEquals(TaskStatus.CREATED, event.getStatus());
        assertNotNull(event.getTaskIdentifier());
    }

    @Test
    void calculate_WithAlgorithm_TaskCalculated() {
        var result = Task.create(TEST_N1_PARAM, TEST_N2_PARAM);
        var task = result.getValue();

        var calcResult = task.calculate(new EuclidAlgorithm());

        var event = calcResult.getEvent();
        assertEquals(TEST_RESULT, event.getResult());
    }

    @Test
    void calculate_WithCalculation_TaskCalculated() {
        var result = Task.create(TEST_N1_PARAM, TEST_N2_PARAM);
        var task = result.getValue();

        var calculation = Calculation.of(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT);
        var calcResult = task.calculate(calculation);

        var event = calcResult.getEvent();
        assertEquals(TEST_RESULT, event.getResult());
    }
}
