package com.example

import org.junit.Rule
import org.junit.rules.TestName
import spock.lang.Specification

/**
 *
 * @author kensipe
 */
class JUnitRulesSpec extends Specification{

    @Rule TestName name = new TestName()

    def "test name at runtime" () {

        println( "entering $name.methodName")
        expect:
        name.methodName == "test name at runtime"
    }

}
