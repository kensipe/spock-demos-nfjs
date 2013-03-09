package com.example

import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Specification

/**
 *
 * @author kensipe
 */

@Narrative("""
this is a description of what this thing is suppose to do
""")
class IssueSpec extends Specification {

    @Issue("http://www.codementor.net/ISSUE-1")
    def "example of an issue + the specificationContext"() {
        given:
        def tags = specificationContext.currentFeature.tags

        expect:
        with(tags[0]) {
            name == "ISSUE-1"
            key == "issue"
            value == "ISSUE-1"
            url == "http://www.codementor.net/ISSUE-1"
        }
    }
}