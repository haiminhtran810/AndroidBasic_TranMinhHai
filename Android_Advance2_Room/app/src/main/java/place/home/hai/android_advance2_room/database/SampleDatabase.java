package place.home.hai.android_advance2_room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import place.home.hai.android_advance2_room.dao.DaoAccess;
import place.home.hai.android_advance2_room.entity.University;

/**
 * Created by Hai on 11/17/2017.
 */

@Database(entities = {University.class}, version = 1)
public abstract class SampleDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
