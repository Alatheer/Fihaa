package com.Alatheer.alatheer.schoole.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.alatheer.schoole.Activities.ChildrenActivity;
import com.Alatheer.alatheer.schoole.Models.ChildrenModel;
import com.Alatheer.alatheer.schoole.R;

import java.util.List;

/**
 * Created by elashry on 3/7/2018.
 */

public class Children_Adapter extends RecyclerView.Adapter<Children_Adapter.Holder>{
    Context context;
    List<ChildrenModel> childrenModelList;
    ChildrenActivity childrenActivity;


    public Children_Adapter(Context context,  List<ChildrenModel> childrenModelList) {
        this.context = context;
        this.childrenModelList = childrenModelList;
        this.childrenActivity = (ChildrenActivity) context;
    }

    @Override
    public Children_Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.children_row,parent,false);

        return new Children_Adapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(final Children_Adapter.Holder holder, int position) {

        ChildrenModel childrenModel = childrenModelList.get(position);
        holder.BindData(childrenModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                childrenActivity.setPos(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  childrenModelList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView child_name, classroom;


        public Holder(View itemView) {
            super(itemView);

            child_name=itemView.findViewById(R.id.child_name);
            classroom=itemView.findViewById(R.id.class_room);

        }

        public void BindData(ChildrenModel childrenModel)
        {
            child_name.setText(childrenModel.getName());
            classroom.setText(childrenModel.getClassrooms_name());
        }


    }
}
