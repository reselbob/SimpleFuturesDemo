package futuresdemo;

import futuresdemo.simple.OnlineReservation;
import futuresdemo.utils.DateConverter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleCompletableFutureDemo {
    public static void main(String[] args) {
        System.out.println("Running a chained business process\n");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture.supplyAsync(() -> {
                    try {
                        return new OnlineReservation().makeReservation("Airline");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executor)
                .thenAccept(confirmation -> {
                    printResult(String.valueOf(confirmation));
                })
                // Add a new CompletableFuture to make a hotel reservation
                .thenApplyAsync(result -> {
                    try {
                        return new OnlineReservation().makeReservation("Hotel");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executor)
                .thenAccept(confirmation -> printResult(String.valueOf(confirmation)))
                .thenApplyAsync(result -> {
                    try {
                        return new OnlineReservation().makeReservation("Car Rental");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executor)
                .thenAccept(confirmation -> {
                    printResult(String.valueOf(confirmation));
                    System.exit(0);
                });
    }

    private static void printResult(String travelServiceMessage) {
        System.out.printf(
                "--------%nResult: %s at %s%n--------%n",
                travelServiceMessage, DateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
    }
}
