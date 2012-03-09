package com.example

import spock.lang.Specification

/**
 *
 * @author ksipe
 */
class PublisherSpec extends Specification {

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
        1 * subscriber2.receive("event")
    }

    def "events are published to all subscribers with closures"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()
        publisher.subscribers << subscriber1
        publisher.subscribers << subscriber2

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive(!null)
        1 * subscriber2.receive({ it.contains("eve")})
        /**
         * sub1 -> the argument passed is only checked to be not null
         * sub2 -> the argument passed must contain the string "eve"
         */

    }

    def "events are published to all subscribers with regex mocking"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()
        publisher.subscribers << subscriber1 << subscriber2

        when:
        publisher.fire("event")

        then:
        1 * subscriber1./rec.*/(!null)
        1 * subscriber2.receive(_ as String)
        /**
         * sub1 -> regex on receive + the argument passed is only checked to be not null
         * sub2 -> argument can be anything, but it must be a String
         */
    }

    def "events are published to all subscribers with abbr mocking"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()
        publisher.subscribers << subscriber1 << subscriber2

        when:
        publisher.fire("event")

        then:
        2 * _.receive("event")
        /**
         * the number of times all mocks will have a receive method called is 2
         */
    }

    /**
     * 1 missing example is
     * subscriber1.receive(_) >>> ["ok", "ok", "NotOK"]
     * a series of returns
     */

    def "events are published a subscriber throws an exception"() {
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()
        publisher.subscribers << subscriber1 << subscriber2

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive("event")  >> { throw new Exception() }
        1 * subscriber2.receive("event")
    }


}