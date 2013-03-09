package com.example

import spock.lang.Specification

/**
 *
 * @author kensipe
 */
class TableOfClosuresSpec extends Specification {

    def "closure calling example"() {
        when:
        def value = example.replace('e', 'a')

        then:
        check.call(value)
        !anotherCheck.call(value)

        where:
        example  | check                                                              | anotherCheck
        "test"   | { it.contains('a') }                                               | { String s -> s.contains('e') }
        "testee" | { String s -> s.toCharArray().findAll({ it == 'a' }).size() == 3 } | { false }
    }
}
