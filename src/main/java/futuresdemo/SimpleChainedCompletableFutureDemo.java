package futuresdemo;

import futuresdemo.simple.Reservation;
import futuresdemo.utils.Printer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChainedCompletableFutureDemo {
  public static void main(String[] args) {
    System.out.println("Running a chained business process\n");
    // Create a new ExecutorService to provide threads for the CompletableFuture
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
        .thenAccept((confirmation) -> Printer.printResult(String.valueOf(confirmation)))
        // Run a hotel reservation asynchronously
        .thenApplyAsync(
            (result) -> {
              try {
                return new Reservation().makeReservation("Hotel");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor)
        // print the result of the hotel reservation synchronously
        .thenAccept((confirmation) -> Printer.printResult(String.valueOf(confirmation)))
        // Run a car rental reservation asynchronously
        .thenApplyAsync(
            (result) -> {
              try {
                return new Reservation().makeReservation("Car Rental");
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            },
            executor)
        // print the result of the car rental reservation synchronously
        .thenAccept(
            (confirmation) -> {
              Printer.printResult(String.valueOf(confirmation));
              // shut down the executor and exit the program
              executor.shutdown();
              System.exit(0);
            });
  }
}
