package place.home.hai.android_advance_realm_db.global;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Hai on 11/17/2017.
 */

public class Cmns {
    public static String getKeyID(int i) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
        return i + sdf.format(cal.getTime());
    }
}
