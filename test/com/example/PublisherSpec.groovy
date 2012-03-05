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
}
