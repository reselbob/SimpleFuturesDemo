package futuresdemo.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Reservation {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<String> makeReservation(String travelService) {
        return executor.submit(
                () -> {
                    Thread.sleep(1000);
                    return travelService + " is confirmed";
                });
    }
}
