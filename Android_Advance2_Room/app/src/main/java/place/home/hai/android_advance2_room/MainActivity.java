package place.home.hai.android_advance2_room;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import place.home.hai.android_advance2_room.adapter.AdapterRecycle;
import place.home.hai.android_advance2_room.database.SampleDatabase;
import place.home.hai.android_advance2_room.entity.College;
import place.home.hai.android_advance2_room.entity.University;

public class MainActivity extends AppCompatActivity {

    private SampleDatabase sampleDatabase;
    private List<University> mUniversities;
    private AdapterRecycle adapterRecycle;
    private RecyclerView rcyShowData;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUniversities = new ArrayList<>();
        sampleDatabase = Room.databaseBuilder(this, SampleDatabase.class, "tmh-db").allowMainThreadQueries().build();
        btnAddItem = findViewById(R.id.btnAddItem);
        rcyShowData = findViewById(R.id.rcyShowData);
        rcyShowData.setLayoutManager(new LinearLayoutManager(this));
        adapterRecycle = new AdapterRecycle(mUniversities, this, sampleDatabase);
        rcyShowData.setAdapter(adapterRecycle);
        new DatabaseAsync().execute();
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataNew();
            }
        });
    }

    private void addDataToDatabase() {
        for (int i = 0; i < 10; i++) {
            University university = new University();
            university.setName("University : " + i);
            College college = new College();
            college.setId(i);
            college.setName("College " + i);
            university.setCollege(college);
            sampleDatabase.daoAccess().insertOnlySingleRecord(university);
        }
    }

    private void addDataNew(){
        University universityTemp = new University();
        universityTemp.setName("University : " + Cmns.getKeyID());
        College college = new College();
        college.setId(1);
        college.setName("College " + Cmns.getKeyID());
        universityTemp.setCollege(college);
        sampleDatabase.daoAccess().insertOnlySingleRecord(universityTemp);
        mUniversities.clear();
        mUniversities.addAll(getAllData());
        adapterRecycle.notifyDataSetChanged();
    }

    private List<University> getAllData() {
        List<University> universitiesTemp = new ArrayList<>();
        universitiesTemp.addAll(sampleDatabase.daoAccess().getAllData());
        return universitiesTemp;
    }

    private class DatabaseAsync extends AsyncTask<Void, Void, List<University>> {
        // run in ThreadMain
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // run in Background
        @Override
        protected List<University> doInBackground(Void... voids) {
            mUniversities.addAll(getAllData());
            if (mUniversities.size() == 0) {
                addDataToDatabase();
            }
            mUniversities.clear();
            mUniversities.addAll(getAllData());
            return mUniversities;
        }

        // run in ThreadMain
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        // run in ThreadMain
        @Override
        protected void onPostExecute(List<University> universities) {
            super.onPostExecute(universities);
            adapterRecycle.notifyDataSetChanged();
        }
    }
}
