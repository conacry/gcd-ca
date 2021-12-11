package com.conacry.application.usecase;

import com.conacry.domain.value.Param;

public interface SaveCalculation {

    void execute(Param n1, Param n2, Integer result);
}
