package futuresdemo.simple;

import futuresdemo.utils.DateConverter;
import futuresdemo.utils.FineGrainDateConverter;

public class TimedReservation implements IReservation {
  @Override
  public String makeReservation(String travelService) throws InterruptedException {
    // Report the start of the reservation
    System.out.printf(
        "Making a reservation for %s at %s%n",
        travelService, FineGrainDateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
    Thread.sleep(1000);

    // Report the end of the reservation
    System.out.printf(
        "Ending a reservation for %s at %s%n",
        travelService, FineGrainDateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
    // Send the confirmation message
    return travelService + " is confirmed";
  }
}
