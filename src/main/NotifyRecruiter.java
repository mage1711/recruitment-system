package main;

public class NotifyRecruiter implements NotifyBehaviour {
    @Override
    public void sendNotification(Object o) {
        AccountRequest accountRequest = (AccountRequest) o;
        System.out.println("***************Notification***************");
        System.out.println("Account request: " + accountRequest.getId() + " has been updated.");
    }

}
