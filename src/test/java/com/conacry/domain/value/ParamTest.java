package com.conacry.domain.value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParamTest {

    private static final Integer TEST_VALUE = 114;

    @Test
    void of_ValueIsNull_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> Param.of(null));
    }

    @Test
    void of_ValueIsNegative_ThrowIllegal() {
        assertThrows(IllegalArgumentException.class, () -> Param.of(-10));
    }

    @Test
    void of_valueIsValid_CreateParam() {
        var param = Param.of(TEST_VALUE);
        assertEquals(TEST_VALUE, param.getValue());
    }

    @Test
    void equal_twoParam_True() {
        assertEquals(Param.of(TEST_VALUE), Param.of(TEST_VALUE));
    }
}