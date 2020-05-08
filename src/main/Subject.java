package main;

public interface Subject {
    void registerObserver(Observer obj);
    void removeObserver(Observer obj);
    void notifyObservers();
}
