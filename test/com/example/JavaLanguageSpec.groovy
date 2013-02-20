package com.example

import spock.lang.IgnoreIf
import spock.lang.Specification

/**
 *
 * @author kensipe
 */
class JavaLanguageSpec extends Specification {

    @IgnoreIf({!jvm.java8 })
    def "java 8 feature"() {
        def friends = ["Brian", "Nate", "Neal", "Raju", "Sara", "Scott", "Venkay"]

        expect:
        friends.stream().getFirst() != null
    }
}
