package main;

import enums.AccountType;

public class User implements Account {
    private String name;
    private String email;
    private AccountType type;
    private NotifyBehaviour notifyBehaviour;

    public User() {
    }

    public User(String name, String email, AccountType type) {
        this.name = name;
        this.email = email;
        this.type = type;
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

    public void deleteAccount() {}

    public void addReport() {}

    public NotifyBehaviour getNotifyBehaviour() {
        return notifyBehaviour;
    }

    public void setNotifyBehaviour(NotifyBehaviour notifyBehaviour) {
        this.notifyBehaviour = notifyBehaviour;
    }

    public void sendNotification() {}

    @Override
    public void login() {

    }
}
