package com.example

import spock.lang.Ignore
import spock.lang.Specification

class MyFirstSpec extends Specification {

    //fields

    //fixture methods
    def setup() {}          // run before every feature method
    def cleanup() {}        // run after every feature method
    def setupSpec() {}     // run before the first feature method
    def cleanupSpec() {}   // run after the last feature method

    // feature methods
    def "pushing an element on the stack"() {

        setup:
        def stack = new Stack()
        def elem = "push me"

        when:
        stack.pop()

        then:
        thrown(EmptyStackException)
        stack.empty

        when:
        stack.pop()

        then:
        EmptyStackException e = thrown()
        e.cause == null

        when:   // stimulus
        stack.push(elem)

        then:   // response
        !stack.empty
        stack.size() == 1
        stack.peek() == elem

    }

    def "pushing an element on the stack given"() {

        given: "setup and initialization of ..."
        def stack = new Stack()
        def elem = "push me"

    }

    def "HashMap accepts null key"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }

    def "events are published to all subscribers"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)
        def publisher = new Publisher()
        publisher.add(subscriber1)
        publisher.add(subscriber2)

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive("event")
        1 * subscriber2./receive/({ it == "event"})
    }

    def "crazy math examples"() {
        when:
        def x = Math.max(1, 2)

        then:
        x == 2

        expect:
        Math.max(1, 2) == 2
    }

    @Ignore
    def "setup and cleanup example"() {
        setup:
        def file = new File("/some/path")
        file.createNewFile()

        // ...

        cleanup:
        file.delete()
    }

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    @Ignore
    def "offered PC matches preferred configuration"() {
        when:
        def pc = shop.buyPc()

        then:
        matchesPreferredConfiguration(pc)
    }

    // helper methods
    //    def matchesPreferredConfiguration(pc) {
    //        pc.vendor == "Sunny" && pc.clockRate >= 2333
    //    }

    void matchesPreferredConfiguration(pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate >= 2333
    }

}


