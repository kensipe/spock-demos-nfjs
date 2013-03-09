package com.example;

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author kensipe
 */
class WhereBlockSpec extends Specification {

    def "add stuff together"() {

        expect:
        1 + 2 == 3
        'Bat' + 'man' == 'Bat man'
        99 + 1 == 100
    }

    @Unroll('#a + #b = #c')
    def "add stuff from the where body"() {

        expect:
        a + b == c

        where:
        a << [1, 'Bat', 99]
        b << [2, 'man', 1]
        c << [3, 'Bat man', '100']

    }

    @Unroll
    def "#a + #b = #c"() {

        expect:
        a + b == c

        where:
        a << [1, 'Bat', 99]
        b << [2, 'man', 1]
        c << [3, 'Bat man', '100']

    }

    @Unroll('#a + #b = #c')
    def "table version of adding stuff"() {

        expect:
        a + b == c

        where:
        a     | b     || c
        1     | 2     || 3
        'Bat' | 'man' || 'Batman'
        99    | 1     || 100
    }

    @Unroll
    def "custom data provider version"() {

        expect:
        a + b == c

        where:
        [a, b, c] << new CustomDataProvider()
    }

}