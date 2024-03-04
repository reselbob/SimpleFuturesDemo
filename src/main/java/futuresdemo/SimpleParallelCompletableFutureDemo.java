package futuresdemo;

import futuresdemo.simple.TimedReservation;
import futuresdemo.utils.Printer;
import java.util.concurrent.*;

public class SimpleParallelCompletableFutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("Running a set of simple Parallel CompletableFutures\n");
    ExecutorService executor = Executors.newFixedThreadPool(3);
    // Create the airline reservation CompletableFuture
    CompletableFuture<String> airlineFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return new TimedReservation().makeReservation("Airline");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor);
    // Create the hotel reservation CompletableFuture
    CompletableFuture<String> hotelFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return new TimedReservation().makeReservation("Hotel");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor);
    // Create the car rental reservation CompletableFuture
    CompletableFuture<String> carRentalFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return new TimedReservation().makeReservation("Car Rental");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor);

   // Wait for all the CompletableFutures to complete
    CompletableFuture.allOf(airlineFuture, hotelFuture, carRentalFuture).join();

    Printer.printResult(String.valueOf(airlineFuture.get()));
    Printer.printResult(String.valueOf(hotelFuture.get()));
    Printer.printResult(String.valueOf(carRentalFuture.get()));

    executor.shutdown();
    System.exit(0);
  }
}
