package com.math

import spock.lang.Specification
import com.extensions.Report

/**
 * shows off the spock extension of reports
 * @author ksipe
 */

@Report
class SimpleInterestCalculatorExtensionSpec  extends Specification {

    def "interest rate calcs with Simple calculator"() {

        given: "simple calc with rate of .05"
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect: "interest calculation"
        interest == calc.calculate(amt, year)

        where:
        interest = 1000.0
        amt = 10000
        year = 2
    }

}
