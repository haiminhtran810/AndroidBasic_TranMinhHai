package place.home.hai.android_advance2_room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import place.home.hai.android_advance2_room.entity.University;

/**
 * Created by Hai on 11/17/2017.
 */
@Dao
public interface DaoAccess {
    @Insert
    void insertMultipleRecord(University... universities);

    @Insert
    void insertOnlySingleRecord(University university);

    @Query("SELECT * FROM University")
    List<University> getAllData();

    /*@Query("SElECT * FROM University WHERE clgid = college_id ")
    University getSingleRecord(int college_id);*/

    @Update
    void updateRecord(University university);

    @Delete
    void deleteRecord(University university);
}
