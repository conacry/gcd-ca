package com.conacry.application.usecase;

import com.conacry.domain.value.Param;

/**
 * Use case of saving calculation
 */
public interface SaveCalculation {

    /**
     * Execute use case
     * <p>
     * Method save calculation to storage
     * with others calculated early
     *
     * @param n1 the first param
     * @param n2 the second param
     * @param result result of calculation
     */
    void execute(Param n1, Param n2, Integer result);
}
