package com.Alatheer.alatheer.schoole.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.alatheer.schoole.Activities.SubClassesActivity;
import com.Alatheer.alatheer.schoole.Models.Stud_ClassModel;
import com.Alatheer.alatheer.schoole.R;

import java.util.List;

/**
 * Created by elashry on 3/5/2018.
 */

public class SubClassesAdapter extends RecyclerView.Adapter <SubClassesAdapter.mViewHolder>{

    Context context;
    List<Stud_ClassModel> subClassesList;
    SubClassesActivity subClassesActivity;

    public SubClassesAdapter(Context context, List<Stud_ClassModel> subClassesList) {
        this.context = context;
        this.subClassesList = subClassesList;
        subClassesActivity = (SubClassesActivity) context;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_classes_row,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {
        Stud_ClassModel subClasses = subClassesList.get(position);
        holder.BindData(subClasses);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subClassesActivity.setPos(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return subClassesList.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder
    {
        private TextView sub_classes_name;

        public mViewHolder(View itemView) {
            super(itemView);

            sub_classes_name = itemView.findViewById(R.id.sub_classes_name);

        }
        public void BindData(Stud_ClassModel subClasses)
        {
            sub_classes_name.setText(subClasses.getClass_name());
        }
    }
}
