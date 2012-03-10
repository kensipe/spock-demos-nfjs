package com.acme.account

import groovy.mock.interceptor.MockFor

/**
 *
 * @author ksipe
 */

class gMockMemoryAccountDaoTest extends GroovyTestCase {

    static final String TEST_ACCOUNT_NO = "1234";

    void testDeposit() {

        Account account = new Account(TEST_ACCOUNT_NO, 100)

        def mock = new MockFor(AccountDao)
        mock.demand.findAccount(TEST_ACCOUNT_NO) { account }
        mock.demand.updateAccount(account) { assertEquals 150, account.balance }

        def dao = mock.proxyDelegateInstance()
        def service = new AccountServiceImpl(dao)

        service.deposit TEST_ACCOUNT_NO, 50
        mock.verify dao
    }
}
