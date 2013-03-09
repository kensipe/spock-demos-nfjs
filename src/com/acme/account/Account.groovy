package com.acme.account

/**
 *
 * @author ksipe
 */
class Account {
    String accountNo;
    double balance;
    AccountType type = new AccountType()



    Account(String accountNo, double balance) {
        this.accountNo = accountNo
        this.balance = balance
    }

    Account() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        Account account = (Account) obj;
        return account.accountNo.equals(accountNo) && account.balance == balance;
    }
}
