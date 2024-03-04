package futuresdemo.utils;

public class Printer {
  public static void printResult(String travelServiceMessage) {
    System.out.printf(
        "--------%nResult: %s at %s%n--------%n",
        travelServiceMessage, DateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
  }

  public static void printFineGrainResult(String travelServiceMessage) {
    System.out.printf(
        "--------%nResult: %s at %s%n--------%n",
        travelServiceMessage, FineGrainDateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
  }

  public static void printWaitingMessage(String travelServiceMessage) {
    System.out.printf(
        "Waiting for %s at %s %n",
        travelServiceMessage, DateConverter.convertToHumanReadableTime(System.currentTimeMillis()));
  }
}
