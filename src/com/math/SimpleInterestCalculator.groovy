package com.math

/**
 *
 * @author ksipe
 */
class SimpleInterestCalculator implements InterestCalculator {

    double rate;

    double calculate(double amount, double year) {
        if (amount < 0 || year < 0) {
            throw new IllegalArgumentException("Amount or year must be positive");
        }
        return amount * year * rate;
    }
}
