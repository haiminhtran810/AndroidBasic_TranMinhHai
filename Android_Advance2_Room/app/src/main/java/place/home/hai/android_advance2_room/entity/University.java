package place.home.hai.android_advance2_room.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Hai on 11/17/2017.
 */

//The table name will be University
//The column names will be slNo, name, clgid, clgname
@Entity
public class University {
    @PrimaryKey(autoGenerate = true)
    private int slNo;
    private String name;
    @Embedded(prefix = "clg")
    private College college;

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
