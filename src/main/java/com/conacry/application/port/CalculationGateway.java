package com.conacry.application.port;

import com.conacry.domain.value.Calculation;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface CalculationGateway {

    Optional<Calculation> findByParam(Integer n1, Integer n2);

    boolean existsByParam(Integer n1, Integer n2);

    void save(@Nonnull Calculation calculation);
}
