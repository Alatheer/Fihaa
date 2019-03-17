package com.Alatheer.alatheer.schooles.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Alatheer.alatheer.schooles.Models.TimeTableStudentModel;
import com.Alatheer.alatheer.schooles.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.Holder> {
    Context context;
    TimeTableStudentModel mmodel;
    List<TimeTableStudentModel> Array;

    public TimeTableAdapter(Context context, List<TimeTableStudentModel> Array) {
        this.context = context;
        this.Array = Array;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_timetable_student, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        mmodel = Array.get(position);

        if (mmodel.getSchool_schedule_images()!=null || !TextUtils.isEmpty(mmodel.getSchool_schedule_images())|| !mmodel.getSchool_schedule_images().equals("0"))
        {
            Picasso.with(context).load("http://anwaralfyaha.anwaralfyaha.com/uploads/images/"+mmodel.getSchool_schedule_images()).into(holder.timetamleimg);

        }



    }

    @Override
    public int getItemCount() {
        return Array.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView timetamleimg;

        public Holder(View itemView) {
            super(itemView);

            timetamleimg = itemView.findViewById(R.id.img_timetable);

        }



    }




}
