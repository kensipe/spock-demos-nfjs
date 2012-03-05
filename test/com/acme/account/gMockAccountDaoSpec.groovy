package com.acme.account

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author ksipe
 */

class gMockAccountDaoSpec extends Specification {


    def "deposit into account test refactor"() {

        def mock = Mock(AccountDao)
        // this could be...
//        AccountDao mock = Mock()
        
        def service = new AccountServiceImpl(mock)

        when:
        service.deposit nmr, amt

        then:
        1 * mock.findAccount(_) >> account
        1 * mock.updateAccount(_)
        0 * mock.createAccount(_)

        and:
        account.balance == total

        where:
        nmr   | account                 | amt | total
        "101" | new Account("101", 100) | 50  | 150
        "101" | new Account("101", 0)   | 50  | 50
    }

    def "deposit into account test"() {
        def TEST_ACCOUNT_NO = "1234"
        def account = new Account(TEST_ACCOUNT_NO, 100)

        AccountDao mock = Mock()

        def service = new AccountServiceImpl(mock)

        when:
        service.deposit TEST_ACCOUNT_NO, 50

        then:
        (_..2) * mock.findAccount("1234") >> account
        _ * mock.updateAccount(_)
        0 * mock.createAccount(_)
        _ * mock./(update | create)Account/(_)
        /**
         * Above are examples of what is possible with mocking in spock
         * 1. (_..2) or (2.._) provides range
         * 2. _ * mock.updateAccount() really is mock.updateAccount()
         * 3. 0 * mock.createAccount() is this should not be called
         * 4. _ * mock./(update | create)Account/(_) is a regex of updateAccount and createAccount
         * ** just because it can be done doesn't mean it should be done:)
         */

        and:
        account.balance == 150

        and:
        account.balance > 100
    }

    def "deposit into account guarantee order of execution"() {
        def TEST_ACCOUNT_NO = "1234"
        def account = new Account(TEST_ACCOUNT_NO, 100)

        AccountDao mock = Mock()

        def service = new AccountServiceImpl(mock)

        when:
        service.deposit TEST_ACCOUNT_NO, 50

        then:
        1 * mock.findAccount("1234") >> account
        0 * mock.createAccount(_)

        then:
        // this verifies order... update has to come after find
        _ * mock.updateAccount(_)

        then:
        // and after update... nothing else should be called on the mock
        0 * mock._

        and:
        account.balance == 150

        and:
        account.balance > 100
    }

}
