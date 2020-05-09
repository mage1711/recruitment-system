package main;

import enums.AccountState;
import enums.AccountType;

public abstract class User implements Account {
    private int id;
    private String name;
    private String email;
    private AccountType type;
    protected NotifyBehaviour notifyBehaviour;
    protected AccountState accountState;

    public User() {
    }

    public User(String name, String email, AccountType type, AccountState accountState) {
        this.name = name;
        this.email = email;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.accountState = accountState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public void deleteAccount() { }

    public void addReport() {}

    public NotifyBehaviour getNotifyBehaviour() {
        return notifyBehaviour;
    }

    public void setNotifyBehaviour(NotifyBehaviour notifyBehaviour) {
        this.notifyBehaviour = notifyBehaviour;
    }

    public abstract void sendNotification(Object o);

    public AccountState getAccountState() {
        return accountState;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    @Override
    public void login(String email, String password) {

    }
}
