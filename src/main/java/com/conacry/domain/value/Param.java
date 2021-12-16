package com.conacry.domain.value;

import com.conacry.shared.mark.ValueObject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Object value "Param"
 * <p>
 * Param wrap input integer and
 * do all necessary validation
 */
@Slf4j
@Getter
public class Param implements ValueObject {

    private final Integer value;

    public static Param of(Integer value) {
        return new Param(value);
    }

    private Param(Integer value) {
        if (value == null) {
            log.warn("Value cannot be null");
            throw new IllegalArgumentException("Value cannot be null");
        }

        if (value < 0) {
            log.warn("Value cannot be negative");
            throw new IllegalArgumentException("Value cannot be negative");
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Param param = (Param) o;
        return value.equals(param.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
