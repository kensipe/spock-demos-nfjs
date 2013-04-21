package com.example

import spock.lang.Shared
import spock.lang.Specification

/**
 *
 * @author kensipe
 */
class SpockSpec extends Specification {

    //fields
    def object = new ClassUnderTest()

    @Shared
    def sharedObject = new SharedClasses()

    // fixture methods
    def setupSpec() {}      // called once for Specification
    def setup() {}          // called before each feature test
    def cleanup () {}       // called after each feature test
    def cleanupSpec() {}    // called once after the Specification

    // feature test
    def "feature test with description" () {
        // setup: or given block
        // when:  (stimulus)
        // then:  (response... asserts)
        // or expect: (stimulus and response)
        // cleanup:
    }
}