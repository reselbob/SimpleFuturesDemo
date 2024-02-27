package futuresdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
  public static String convertToHumanReadableTime(long time) {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
  }
}
