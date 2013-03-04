package com.math

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author ksipe
 */
class SimpleInterestCalculatorSQLSpec extends Specification {

    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table calcdata (id int primary key, year integer, interest decimal, amt integer)")
        sql.execute("insert into calcdata values (1, 2, 1000.0, 10000), (2, 5, 25.0, 100)")
    }



    @Unroll
    def "showing off vars list in calc"() {
        given:
        def calc = new SimpleInterestCalculator(rate: 0.05)

        expect:
        interest == calc.calculate(amt, year)

        where:
        [year, interest, amt] << sql.rows("""select year, interest, amt from calcdata""")
    }
}
