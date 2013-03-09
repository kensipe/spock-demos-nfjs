package com.example

import spock.lang.Specification

class FastAndSlowSpec extends Specification {

    @Fast
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

    @Fast
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

    @Slow
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
        1 * subscriber2./receive/({ it == "event" })
    }

    def "crazy math examples"() {
        when:
        def x = Math.max(1, 2)

        then:
        x == 2

        expect:
        Math.max(1, 2) == 2
    }

}


