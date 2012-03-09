package com.example

/**
 *
 * @author ksipe
 */
class Publisher {

    def subscribers = []

    def add(Subscriber subscriber) {
        subscribers << subscriber
    }

    def fire(String s) {
        subscribers.each {
            try {
                it.receive(s)
            } catch (Exception e) {
                // do something magical
            }
        }
    }
}
