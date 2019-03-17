package com.Alatheer.alatheer.schooles.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.alatheer.schooles.Models.AbsenceModel;
import com.Alatheer.alatheer.schooles.R;

import java.util.List;


public class AbsenceStudentAdapter extends RecyclerView.Adapter<AbsenceStudentAdapter.Holder> {
    Context context;
    AbsenceModel mmodel;
    List<AbsenceModel> Array;

    public AbsenceStudentAdapter(Context context, List<AbsenceModel> Array) {
        this.context = context;
        this.Array = Array;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_apsent_student, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        mmodel = Array.get(position);

        holder.student_name.setText(mmodel.getStudent_name());
        holder.absence_type.setText(mmodel.getAbsence_type_name());
        holder.date.setText(mmodel.getDate_ar());


    }

    @Override
    public int getItemCount() {
        return Array.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView student_name, absence_type,date;

        public Holder(View itemView) {
            super(itemView);

            student_name = itemView.findViewById(R.id.txt_student_name);
            absence_type = itemView.findViewById(R.id.txt_absence_type);
            date=itemView.findViewById(R.id.txt_date_ar);



        }



    }




}
