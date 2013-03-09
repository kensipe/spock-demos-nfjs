package com.example

import com.acme.account.Account
import com.acme.account.AccountType
import spock.lang.Specification

/**
 *
 * @author kensipe
 */
class WithExampleSpec extends Specification {

    def "working with with"() {
        def account = new Account(accountNo: "123", balance: 50.0)

        expect:
        with(account) {
            accountNo == "123"
            balance == 50.0
        }
    }

    def "working with composites"() {
        def account = new Account(accountNo: "123", balance: 50.0)

        expect:
        with(account.type, AccountType) {
            type == "checking"
        }
    }

    //
}
