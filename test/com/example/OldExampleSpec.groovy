package com.example

import spock.lang.Specification

/**
 *
 * @author kensipe
 */
class OldExampleSpec extends Specification {

    def "looking at old lists"() {
        def list = [1, 2, 3]

        when:
        list << 4

        then:
        list.size() == 4
        old(list.size()) == 3
    }

    def "looking at old maps"() {
        def map = [:]
        map.example = "test"

        when:
        map.example = "new"

        then:
        map.example == "new"
        old(map.example) == "test"
        map.example != old(map.example)
    }
}
