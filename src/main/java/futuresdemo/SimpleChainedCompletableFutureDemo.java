package futuresdemo;

import futuresdemo.simple.Reservation;
import futuresdemo.utils.Printer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChainedCompletableFutureDemo {
  public static void main(String[] args) {
    System.out.println("Running a chained business process\n");
    ExecutorService executor = Executors.newFixedThreadPool(5);
    // Supply a new CompletableFuture to make an airline reservation
    CompletableFuture.supplyAsync(
            () -> {
              try {
                return new Reservation().makeReservation("Airline");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor)
        .thenAccept(
            confirmation -> {
              Printer.printResult(String.valueOf(confirmation));
            })
        // Add a new CompletableFuture to make a hotel reservation
        .thenApplyAsync(
            result -> {
              try {
                return new Reservation().makeReservation("Hotel");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor)
        .thenAccept(confirmation -> Printer.printResult(String.valueOf(confirmation)))
        // Add a new CompletableFuture to make a car rental reservation
        .thenApplyAsync(
            result -> {
              try {
                return new Reservation().makeReservation("Car Rental");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor)
        .thenAccept(
            confirmation -> {
              Printer.printResult(String.valueOf(confirmation));
              executor.shutdown();
              System.exit(0);
            });
  }
}
