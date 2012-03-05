package com.math

import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author ksipe
 */
class SimpleInterestCalculatorSpec extends Specification {

    def "interest rate calcs with Simple calculator"() {
        given:
        def calc = new SimpleInterestCalculator()

        when:
        calc.rate = 0.05

        then:
        1000.0 == calc.calculate(10000, 2)
    }

    def "showing off vars in calc"() {
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        interest = 1000.0
        amt = 10000
        year = 2
    }

    @Unroll
    def "showing off vars list in calc"() {
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        interest << [1000.0, 25.0]
        amt << [10000, 100]
        year << [2, 5]
    }

    def "show of data table"() {
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        interest | amt     | year
        1000.0   | 10000   | 2
        25.0     | value() | 5

    }


    def value() {
        100
    }

    @FailsWith(IllegalArgumentException)
    def "failure example on cal"() {

        expect:
        def calc = new SimpleInterestCalculator(rate: 0.05)
        1000.0 == calc.calculate(10000, -1)
    }

}
