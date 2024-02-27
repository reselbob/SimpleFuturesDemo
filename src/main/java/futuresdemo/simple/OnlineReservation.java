package futuresdemo.simple;

public class OnlineReservation {
    public String makeReservation(String travelService) throws InterruptedException {
        Thread.sleep(1000);
        return travelService + " is confirmed";
    }
}

