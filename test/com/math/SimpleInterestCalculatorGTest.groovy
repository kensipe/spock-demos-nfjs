package com.math

/**
 *
 * @author ksipe
 */

class SimpleInterestCalculatorGTest extends GroovyTestCase {

    def interestCalculator

    protected void setUp() throws Exception {
        interestCalculator = new SimpleInterestCalculator(rate: 0.05)
    }

    public void testCalculate() {
        double interest = interestCalculator.calculate(10000, 2)
        assert interest == 1000.0
        assert "test".toLowerCase() == "test".toLowerCase()
    }

    public void testIllegalCalculate() {
        shouldFail {
            interestCalculator.calculate(-10000, 2)
        }
    }

}
