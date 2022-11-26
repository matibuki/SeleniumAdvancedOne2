package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String todayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        return sdf.format(now);
    }
}
