package com.Alatheer.alatheer.schoole.Adapters;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.Alatheer.alatheer.schoole.Models.HonerModel;
import com.Alatheer.alatheer.schoole.R;
import java.util.List;


public class HonorBoardStudentAdapter extends RecyclerView.Adapter<HonorBoardStudentAdapter.Holder> {
    Context context;
    HonerModel mmodel;
    List<HonerModel> Array;

    public HonorBoardStudentAdapter(Context context, List<HonerModel> Array) {
        this.context = context;
        this.Array = Array;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_honorboard_student, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        mmodel = Array.get(position);

        holder.student_name.setText(mmodel.getStudent_name());
        holder.student_degree.setText(mmodel.getDegree());


    }

    @Override
    public int getItemCount() {
        return Array.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView student_name, student_degree;

        public Holder(View itemView) {
            super(itemView);

            student_name = itemView.findViewById(R.id.txt_student_name);
            student_degree = itemView.findViewById(R.id.txt_student_degree);



        }



    }




}
