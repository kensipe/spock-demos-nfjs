package com.math;

/**
 * @author kensipe
 */
public interface InterestCalculator {

    void setRate(double rate);
    double calculate(double amount, double year);

    double subtract(double value1, double value2);
}
