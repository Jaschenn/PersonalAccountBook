package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private  static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date){
        synchronized(simpleDateFormat){
            return simpleDateFormat.format(date);
        }
    }
    public static Date parse(String strDate) throws ParseException {
        synchronized (simpleDateFormat){
            return simpleDateFormat.parse(strDate);
        }
    }
}
