package main;

import enums.ApplicationState;

public interface Observer {
    void  update(ApplicationState state);


}
