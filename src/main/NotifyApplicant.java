package main;

public class NotifyApplicant implements NotifyBehaviour {
    @Override
    public void sendNotification(Object updatedApplication) {
        System.out.println("***************Notification***************");
        Application application = (Application) updatedApplication;
        System.out.println("Application: " + application.getId() + " has been updated.");
    }


}
