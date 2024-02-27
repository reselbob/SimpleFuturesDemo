package futuresdemo;

import futuresdemo.simple.Reservation;
import futuresdemo.utils.DateConverter;
import java.util.concurrent.*;

public class SimpleFutureDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    Future<String> airlineFuture = new Reservation().makeReservation("Airline");

    while (!airlineFuture.isDone()) {
      printWaitingMessage("Airline");
      Thread.sleep(300);
    }

    printResult(airlineFuture.get());

    Future<String> hotelFuture = new Reservation().makeReservation("Hotel");

    while (!hotelFuture.isDone()) {
      printWaitingMessage("Hotel");
      Thread.sleep(300);
    }

    printResult(hotelFuture.get());

    Future<String> carRentalFuture = new Reservation().makeReservation("Car Rental");

    while (!carRentalFuture.isDone()) {
      printWaitingMessage("Car Rental");
      Thread.sleep(300);
    }

    printResult(carRentalFuture.get());

    System.exit(0);
  }

  private static void printResult(String travelServiceMessage) {
    System.out.printf(
        "--------%nResult: %s at %s%n--------%n",
        travelServiceMessage, DateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
  }

  private static void printWaitingMessage(String travelServiceMessage) {
    System.out.printf(
        "Waiting for %s at %s %n",
        travelServiceMessage, DateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
  }
}
