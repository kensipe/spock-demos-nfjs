package com.example

import spock.lang.Specification
import spock.util.environment.RestoreSystemProperties

/**
 *
 * @author kensipe
 */
class SysPropsSpec extends Specification {
    final static KEY = "spec-test"

    def setupSpec() {
        System.setProperty(KEY, "example")
    }

    def cleanupSpec() {
        assert System.getProperty(KEY) == "example"
    }

    @RestoreSystemProperties
    def "channge sys properties"() {

        System.setProperty(KEY, "bad")

        expect:
        System.getProperty(KEY) == "bad"
    }
}
