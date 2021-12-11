package com.conacry.domain.value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    private static final Param TEST_N1_PARAM = Param.of(105);
    private static final Param TEST_N2_PARAM = Param.of(45);
    private static final Integer TEST_RESULT = 15;

    @Test
    void of_Param1IsNull_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> Calculation.of(null, TEST_N2_PARAM, TEST_RESULT));
    }

    @Test
    void of_Param2IsNull_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> Calculation.of(TEST_N1_PARAM, null, TEST_RESULT));
    }

    @Test
    void of_ResultIsNull_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> Calculation.of(TEST_N1_PARAM, TEST_N2_PARAM, null));
    }

    @Test
    void of_ValidParam_NotThrowEx() {
        assertDoesNotThrow(() -> Calculation.of(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT));
    }

    @Test
    void equal_TwoCalculations_True() {
        var calc1 = Calculation.of(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT);
        var calc2 = Calculation.of(TEST_N1_PARAM, TEST_N2_PARAM, TEST_RESULT);
        assertEquals(calc1, calc2);
    }
}
