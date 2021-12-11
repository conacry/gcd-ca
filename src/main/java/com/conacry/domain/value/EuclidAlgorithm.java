package com.conacry.domain.value;

/**
 * Greatest common division by Euclid's algorithm
 */
public final class EuclidAlgorithm implements GcdAlgorithm {

    @Override
    public int execute(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }

        return this.execute(n2, n1 % n2);
    }
}
