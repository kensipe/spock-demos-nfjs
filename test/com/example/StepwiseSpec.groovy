package com.example

import spock.lang.Specification
import spock.lang.Stepwise

/**
 *
 * @author ksipe
 */
@Stepwise
class StepwiseSpec extends Specification {

    /**
     * the method names don't matter... the point is that sometimes there are quick quicks
     * that you want to test first in order to run some other tests.  This allows the Spec to fail quickly.
     * the first test in order written that fails... stops all other feature tests.
     */
    def "step 1"() {
        expect: true
    }

    def "step 2"() {
        expect: true   // if you swap this with the false, you will see that step 2 fails and step 3 is ignored
//        expect: false
    }

    def "step 3"() {
        expect: true
    }
}
