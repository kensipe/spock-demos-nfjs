package com.example

import java.util.concurrent.Executors
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import org.junit.rules.TestName
import spock.lang.AutoCleanup
import spock.lang.Ignore
import spock.lang.Issue
import spock.lang.Specification

/**
 *
 * @author ksipe
 */
class RuleExampleSpec extends Specification {
    @Rule name = new TestName()
    @Rule tempDir = new TemporaryFolder()

    @AutoCleanup("shutdown")  //custom cleanup method
    def executor = Executors.newCachedThreadPool()

    @Issue("123")
    def "retrieve test name at runtime"() {
        println "running '$name.methodName'"

        expect: 1 + 1 == 2
    }

    def "temp folder is guarenteed to be deleted at the end of a test"() {
        File createdFile = tempDir.newFile("temp.txt");

        expect: true
    }

    @Ignore
    def "ignored test"() {
        expect: true
    }

    def "testing the input stream and threadpool"() {
        File createdFile = tempDir.newFile("temp.txt");

        @AutoCleanup
        def input = new FileInputStream(createdFile.absolutePath)
        // auto clean up of file stream

        expect: true
    }
}