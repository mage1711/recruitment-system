package main;

import enums.AccountType;

public abstract class AccountFactory {

    public abstract Account createAccount(AccountType type);

}
