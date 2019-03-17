package com.Alatheer.alatheer.schooles.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.alatheer.schooles.Activities.SafofActivity;
import com.Alatheer.alatheer.schooles.Models.ModelStage;
import com.Alatheer.alatheer.schooles.R;

import java.util.List;

/**
 * Created by elashry on 3/5/2018.
 */

public class SubStagesAdapter extends RecyclerView.Adapter <SubStagesAdapter.mViewHolder>{

    Context context;
    List<ModelStage> subStagesList;
    SafofActivity safofActivity;

    public SubStagesAdapter(Context context, List<ModelStage> subStagesList) {
        this.context = context;
        this.subStagesList = subStagesList;
        safofActivity = (SafofActivity) context;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_stages_row,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, int position) {
        ModelStage subStages = subStagesList.get(position);
        holder.BindData(subStages);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                safofActivity.setPos(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return subStagesList.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder
    {
        private TextView sub_stage_name,stage_name;

        public mViewHolder(View itemView) {
            super(itemView);

            sub_stage_name = itemView.findViewById(R.id.sub_stage_name);
            stage_name = itemView.findViewById(R.id.stage_name);

        }
        public void BindData(ModelStage subStages)
        {
            stage_name.setText(subStages.getStage_name());
            sub_stage_name.setText(subStages.getSub_stage_name());

        }
    }
}
