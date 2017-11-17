package place.home.hai.android_advance_realm_db.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Hai on 11/17/2017.
 */

public class RealmApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("hmt.realm").build();
        // delete then we create again it
        Realm.deleteRealm(config);
        Realm.setDefaultConfiguration(config);
    }
}
