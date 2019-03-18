package com.Alatheer.alatheer.schoole.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.alatheer.schoole.Models.Student_State_Model;
import com.Alatheer.alatheer.schoole.R;

import java.util.List;


public class StudentStateAdapter extends RecyclerView.Adapter<StudentStateAdapter.Holder> {
    Context context;
    Student_State_Model mmodel;
    List<Student_State_Model> list;

    public StudentStateAdapter(Context context, List<Student_State_Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student_state, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        mmodel = list.get(position);


        holder.exam_name.setText(mmodel.getExam_name());
        holder.student_name.setText(mmodel.getStudent_name());
        holder.subject_name.setText(mmodel.getSubject_name());
        holder.evaluatin_degree.setText(mmodel.getEvaluatin_degree());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView exam_name, student_name,subject_name,evaluatin_degree;

        public Holder(View itemView) {
            super(itemView);

            exam_name = itemView.findViewById(R.id.txt_exam_name);
            student_name = itemView.findViewById(R.id.txt_student_name);
            subject_name = itemView.findViewById(R.id.txt_subject_name);
            evaluatin_degree = itemView.findViewById(R.id.txt_evaluatin_degree);



        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            mmodel = list.get(position);

        }

    }




}
