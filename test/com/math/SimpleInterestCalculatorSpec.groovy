package com.math

import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

// hamcrest requires, runtime of core, plus the matchers, plus that or expect
/**
 *
 * @author ksipe
 */
class SimpleInterestCalculatorSpec extends Specification {

    def "interest rate calcs with Simple calculator"() {
        given:
        @Subject
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

    @Unroll("int: #interest amt: #amt year: #year")
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
        given:
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        interest | amt     | year
        1000.0   | 10000   | 2
        25.0     | value() | 5
    }


    def value() {
        10 * 10
    }

    @FailsWith(IllegalArgumentException)
    def "failure example on cal"() {

        expect:
        def calc = new SimpleInterestCalculator(rate: 0.05)
        1000.0 == calc.calculate(10000, -1)
    }

    def "hamcrest values"() {
        def calc = new SimpleInterestCalculator()

        expect:
        that calc.subtract(2.0, 1.1), closeTo(0.9, 0.01)

    }
}
