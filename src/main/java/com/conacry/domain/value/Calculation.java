package com.conacry.domain.value;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Value object "Calculation"
 * <p>
 * Calculation contains input params
 * and calculation result
 */
@Slf4j
@Getter
public final class Calculation {

    private final Param n1;
    private final Param n2;
    private final Integer result;

    public static Calculation of(Param n1, Param n2, Integer result) {
        if (n1 == null || n2 == null || result == null) {
            log.warn("Each param cannot be null");
            throw new IllegalArgumentException("Each param cannot be null");
        }

        return new Calculation(n1, n2, result);
    }

    private Calculation(Param n1, Param n2, Integer result) {
        this.n1 = n1;
        this.n2 = n2;
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Calculation that = (Calculation) o;
        return n1.equals(that.n1) && n2.equals(that.n2) && result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2, result);
    }
}
