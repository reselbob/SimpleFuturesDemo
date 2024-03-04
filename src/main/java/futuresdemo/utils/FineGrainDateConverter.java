package futuresdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FineGrainDateConverter {
    public static String convertToHumanReadableTime(long time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(time));
    }
}
