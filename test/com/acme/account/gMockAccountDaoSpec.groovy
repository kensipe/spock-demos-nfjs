package com.acme.account

import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * @author ksipe
 */

class gMockAccountDaoSpec extends Specification {

    def "deposit into account test"() {
        def TEST_ACCOUNT_NO = "1234"
        def account = new Account(TEST_ACCOUNT_NO, 100)

        AccountDao mock = Mock()

        def service = new AccountServiceImpl(mock)

        when:
        service.deposit TEST_ACCOUNT_NO, 50

        then:
        1 * mock.findAccount(TEST_ACCOUNT_NO) >> account
        _ * mock.updateAccount(_)
        0 * mock.createAccount(_)
        _ * mock./(update | create)Account/(_)

        and:
        account.balance == 150

        and:
        account.balance > 100
    }

    def "deposit into account test refactor"() {

        def mock = Mock(AccountDao)
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
}
