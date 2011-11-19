package com.acme.account

import org.junit.Test

/**
 *
 * @author ksipe
 */
class gInMemoryAccountDaoTests extends GroovyTestCase {
    def EXISTING_ACCOUNT_NO = "1234"
    def NEW_ACCOUNT_NO = "5678"

    Account existingAccount
    Account newAccount
    InMemoryAccountDao accountDao

    protected void setUp() {
        super.setUp()
        existingAccount = new Account(EXISTING_ACCOUNT_NO, 100)
        newAccount = new Account(NEW_ACCOUNT_NO, 200)
        accountDao = new InMemoryAccountDao()
        accountDao.createAccount(existingAccount)
    }

    public void testAccountExists() {
        assert accountDao.accountExists(EXISTING_ACCOUNT_NO)
        assert (accountDao.accountExists(NEW_ACCOUNT_NO)) == false
    }

    public void testCreateNewAccount() {
        accountDao.createAccount(newAccount)
        assert accountDao.findAccount(NEW_ACCOUNT_NO) == newAccount
    }

    public void findNotExistedAccount() {
        shouldFail {
            accountDao.findAccount(NEW_ACCOUNT_NO)
        }
    }

    @Test(expected = DuplicateAccountException.class)
    public void createDuplicateAccount() {
        accountDao.createAccount(existingAccount)
    }

    public void testUpdateExistedAccount() {
        existingAccount.setBalance(150)
        accountDao.updateAccount(existingAccount)
        assert accountDao.findAccount(EXISTING_ACCOUNT_NO) == existingAccount
    }

    public void testUpdateNotExistedAccount() {
        shouldFail {
            accountDao.updateAccount(newAccount)
        }
    }

}
