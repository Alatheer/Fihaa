package com.Alatheer.alatheer.schooles.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.alatheer.schooles.Activities.AllSchools;
import com.Alatheer.alatheer.schooles.Models.AllSchoolModel;
import com.Alatheer.alatheer.schooles.R;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public class AllSchools_Adapters extends RecyclerView.Adapter<AllSchools_Adapters.mViewHolder> {

    List<AllSchoolModel> allSchoolModelList;
    Context context;
    AllSchools allSchools;

    public AllSchools_Adapters(List<AllSchoolModel> allSchoolModelList, Context context) {
        this.allSchoolModelList = allSchoolModelList;
        this.context = context;
        this.allSchools = (AllSchools) context;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_schools_item_row,parent,false);

        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {
        AllSchoolModel allSchoolModel = allSchoolModelList.get(position);
        holder.BindData( allSchoolModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allSchools.setPos(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return allSchoolModelList.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder
    {
        private TextView schoolName;
    public mViewHolder(View itemView) {
        super(itemView);
        schoolName = itemView.findViewById(R.id.schoolName);

    }

    public void BindData(AllSchoolModel allSchoolModel)
    {
        schoolName.setText(allSchoolModel.getSchool_name());
    }

    }
}
