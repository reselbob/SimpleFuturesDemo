package futuresdemo;

import futuresdemo.simple.Reservation;
import futuresdemo.utils.Printer;
import java.util.concurrent.*;

public class SimpleFutureDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    System.out.println("Running a set of simple Futures in sequence\n");

    // Create a new ExecutorService to provide threads for the Futures
    ExecutorService executor = Executors.newFixedThreadPool(3);

    // Create a new Future for making an airline reservation
    Future<String> airlineFuture =
        executor.submit(() -> new Reservation().makeReservation("Airline"));
    // Query the Future to see if it's done
    while (!airlineFuture.isDone()) {
      Printer.printWaitingMessage("Airline");
      Thread.sleep(300);
    }
    // Get the result of the Future and print it to the console
    Printer.printResult(airlineFuture.get());

    // Create a new Future for making a hotel reservation
    Future<String> hotelFuture = executor.submit(() -> new Reservation().makeReservation("Hotel"));

    // Query the Future to see if it's done
    while (!hotelFuture.isDone()) {
      Printer.printWaitingMessage("Hotel");
      Thread.sleep(300);
    }

    // Get the result of the Future and print it to the console
    Printer.printResult(hotelFuture.get());

    // Create a new Future for making a car rental reservation
    Future<String> carRentalFuture =
        executor.submit(() -> new Reservation().makeReservation("Car Rental"));

    // Query the Future to see if it's done
    while (!carRentalFuture.isDone()) {
      Printer.printWaitingMessage("Car Rental");
      Thread.sleep(300);
    }

    // Get the result of the Future and print it to the console
    Printer.printResult(carRentalFuture.get());

    // Shut down the ExecutorService and exit the program
    executor.shutdown();
    System.exit(0);
  }
}
