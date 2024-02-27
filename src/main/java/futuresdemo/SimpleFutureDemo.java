package futuresdemo;

import futuresdemo.simple.Reservation;
import futuresdemo.utils.DateConverter;
import futuresdemo.utils.Printer;

import java.util.concurrent.*;

public class SimpleFutureDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool(3);

    Future<String> airlineFuture = executor.submit(() -> new Reservation().makeReservation("Airline"));
    while (!airlineFuture.isDone()) {
      Printer.printWaitingMessage("Airline");
      Thread.sleep(300);
    }

    Printer.printResult(airlineFuture.get());

    Future<String> hotelFuture = executor.submit(() -> new Reservation().makeReservation("Hotel"));

    while (!hotelFuture.isDone()) {
      Printer.printWaitingMessage("Hotel");
      Thread.sleep(300);
    }

    Printer.printResult(hotelFuture.get());

    Future<String> carRentalFuture = executor.submit(() -> new Reservation().makeReservation("Car Rental"));

    while (!carRentalFuture.isDone()) {
      Printer.printWaitingMessage("Car Rental");
      Thread.sleep(300);
    }

    Printer.printResult(carRentalFuture.get());

    executor.shutdown();

    System.exit(0);
  }


}
