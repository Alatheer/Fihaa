package com.Alatheer.alatheer.schoole.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Alatheer.alatheer.schoole.Activities.ActivitiesDetails;
import com.Alatheer.alatheer.schoole.Models.AllActivities_Model;
import com.Alatheer.alatheer.schoole.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ok on 29/01/2018.
 */

public class All_Activities_Adapter extends RecyclerView.Adapter<All_Activities_Adapter.Holder>{
    Context context;
    AllActivities_Model Model;
    ArrayList<AllActivities_Model> actiitiesList;


    public All_Activities_Adapter(Context context, ArrayList<AllActivities_Model> actiitiesList) {
        this.context = context;
        this.actiitiesList = actiitiesList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activities,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        Model=actiitiesList.get(position);
        holder.title.setText(Model.getActivity_title());
        holder.content.setText(Model.getActivity_content());
        holder.date.setText(Model.getActivity_date());

        if (Model.getImage_name()!=null || !TextUtils.isEmpty(Model.getImage_name())|| !Model.getImage_name().equals("0"))
        {
            Picasso.with(context).load("http://anwaralfyaha.anwaralfyaha.com/uploads/images/"+Model.getImage_name()).into(holder.image);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllActivities_Model allActivities_model = actiitiesList.get(holder.getAdapterPosition());
                Intent i = new Intent(context,ActivitiesDetails.class);
                i.putExtra("activities_details",allActivities_model);
                context.startActivity(i);
            }
        }) ;
    }
    @Override
    public int getItemCount() {
        return  actiitiesList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView title, content,date;
        ImageView image;

         Holder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txt_title);
            content=itemView.findViewById(R.id.txt_content);
            date=itemView.findViewById(R.id.txt_date);
            image=itemView.findViewById(R.id.img_activities);

        }

    }
}
