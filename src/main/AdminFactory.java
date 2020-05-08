package main;

import enums.AccountType;

public class AdminFactory extends AccountFactory {
    @Override
    public Account createAccount(AccountType type) {
        return new Admin();
    }
}
