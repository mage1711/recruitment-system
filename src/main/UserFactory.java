package main;

import enums.AccountType;

public class UserFactory extends AccountFactory {

    @Override
    public Account createAccount(AccountType type) {

        return new User();
    }
}
