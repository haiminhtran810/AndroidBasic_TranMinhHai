package place.home.hai.android_advance2_room;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Hai on 11/18/2017.
 */

public class Cmns {
    public static String getKeyID() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        return sdf.format(cal.getTime());
    }
}
