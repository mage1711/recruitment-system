package main;

public class AdminFactory extends AccountFactory {
    @Override
    public Account createAccount() {
        return new Admin();
    }
}
