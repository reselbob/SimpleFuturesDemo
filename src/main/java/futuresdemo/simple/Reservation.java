package futuresdemo.simple;

public class Reservation implements IReservation {
  public String makeReservation(String travelService) throws InterruptedException {
    Thread.sleep(1000);
    return travelService + " is confirmed";
  }
}
