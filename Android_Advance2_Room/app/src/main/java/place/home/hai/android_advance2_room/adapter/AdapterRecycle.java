package place.home.hai.android_advance2_room.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import place.home.hai.android_advance2_room.Cmns;
import place.home.hai.android_advance2_room.R;
import place.home.hai.android_advance2_room.database.SampleDatabase;
import place.home.hai.android_advance2_room.entity.College;
import place.home.hai.android_advance2_room.entity.University;

/**
 * Created by Hai on 11/18/2017.
 */

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.MyViewHolder> {

    private List<University> mUniversities;
    private Activity context;
    private LayoutInflater layoutInflater;
    private SampleDatabase sampleDatabase;

    public AdapterRecycle(List<University> mUniversities, Activity context, SampleDatabase sampleDatabase) {
        this.mUniversities = mUniversities;
        this.context = context;
        this.sampleDatabase = sampleDatabase;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(mUniversities.get(position));
    }

    @Override
    public int getItemCount() {
        return mUniversities == null ? 0 : mUniversities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView btnUpdate, btnDelete;
        private TextView txtShowDetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            txtShowDetail = itemView.findViewById(R.id.txtShowDetail);
            btnDelete.setOnClickListener(this);
            btnUpdate.setOnClickListener(this);
        }

        public void bindData(University university) {
            if (university == null) return;
            String temp =
                    "University \n\t" +
                            "ID : " + university.getSlNo() + "\n" +
                            "Name : " + university.getName() + "\n" +
                            "College \n\t\t" +
                            "ID : " + university.getCollege().getId() + "\n\t\t" +
                            "Name : " + university.getCollege().getName();
            txtShowDetail.setText(temp);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.btnDelete:
                    deleteData(mUniversities.get(position));
                    break;
                case R.id.btnUpdate:
                    University universityTemp = mUniversities.get(position);
                    universityTemp.setName("University : " + Cmns.getKeyID());
                    College collegeTemp = universityTemp.getCollege();
                    collegeTemp.setName("College : " + Cmns.getKeyID());
                    updateData(universityTemp);
                    break;
            }
        }
    }

    private List<University> getAllData() {
        List<University> universitiesTemp = new ArrayList<>();
        universitiesTemp.addAll(sampleDatabase.daoAccess().getAllData());
        return universitiesTemp;
    }

    private void updateData(University university) {
        sampleDatabase.daoAccess().updateRecord(university);
        mUniversities.clear();
        mUniversities.addAll(getAllData());
        notifyDataSetChanged();
    }

    private void deleteData(University university) {
        sampleDatabase.daoAccess().deleteRecord(university);
        mUniversities.clear();
        mUniversities.addAll(getAllData());
        notifyDataSetChanged();
    }


}
