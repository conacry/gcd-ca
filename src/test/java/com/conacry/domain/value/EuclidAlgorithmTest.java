package com.conacry.domain.value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclidAlgorithmTest {

    private static final int TEST_N1 = 105;
    private static final int TEST_N2 = 45;
    private static final int TEST_RESULT = 15;
    private static final int ZERO_PARAM = 0;

    @Test
    void execute_n2IsNull_ReturnN1() {
        var euclid = new EuclidAlgorithm();
        assertEquals(TEST_N1, euclid.execute(TEST_N1, ZERO_PARAM));
    }

    @Test
    void execute_n1IsNull_ReturnN1() {
        var euclid = new EuclidAlgorithm();
        assertEquals(TEST_N2, euclid.execute(ZERO_PARAM, TEST_N2));
    }

    @Test
    void execute_ValidParam() {
        var euclid = new EuclidAlgorithm();
        assertEquals(TEST_RESULT, euclid.execute(TEST_N1, TEST_N2));
    }
}