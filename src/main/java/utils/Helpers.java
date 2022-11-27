package utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {
    public static String todayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        return sdf.format(now);
    }

//    public static String roundingDown(Double a) {
//        DecimalFormat df = new DecimalFormat("0.00");
//        return df.format(a);
//    }
}
