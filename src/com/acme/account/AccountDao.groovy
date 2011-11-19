package com.acme.account

/**
 *
 * @author ksipe
 */
interface AccountDao {

    void createAccount(Account account)

    void updateAccount(Account account)

    void removeAccount(Account account)

    Account findAccount(String accountNo)
}
