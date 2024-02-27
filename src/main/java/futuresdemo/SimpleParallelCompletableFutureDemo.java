package futuresdemo;

import futuresdemo.simple.Reservation;
import futuresdemo.utils.Printer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleParallelCompletableFutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("Running a set of simple Parallel CompletableFutures\n");
    ExecutorService executor = Executors.newFixedThreadPool(3);

    CompletableFuture<String> airlineFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return new Reservation().makeReservation("Airline");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor);
    CompletableFuture<String> hotelFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return new Reservation().makeReservation("Hotel");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor);
    CompletableFuture<String> carRentalFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                return new Reservation().makeReservation("Car Rental");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor);

    CompletableFuture.allOf(airlineFuture, hotelFuture, carRentalFuture);
    Printer.printResult(String.valueOf(airlineFuture.get()));
    Printer.printResult(String.valueOf(hotelFuture.get()));
    Printer.printResult(String.valueOf(carRentalFuture.get()));

    executor.shutdown();
    System.exit(0);
  }
}
