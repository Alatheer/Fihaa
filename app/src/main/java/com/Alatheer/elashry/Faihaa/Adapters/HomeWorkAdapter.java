package com.Alatheer.elashry.Faihaa.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Alatheer.elashry.Faihaa.Models.AbsenceModel;
import com.Alatheer.elashry.Faihaa.Models.HomeWorkModel;
import com.Alatheer.elashry.Faihaa.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.squareup.picasso.Picasso;

import java.util.List;


public class HomeWorkAdapter extends RecyclerView.Adapter<HomeWorkAdapter.Holder> {
    Context context;
    HomeWorkModel mmodel;
    List<HomeWorkModel> Array;

    public HomeWorkAdapter(Context context, List<HomeWorkModel> Array) {
        this.context = context;
        this.Array = Array;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homework_student, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        mmodel = Array.get(position);

        if (mmodel.getHomework_image()!=null || !TextUtils.isEmpty(mmodel.getHomework_image())|| !mmodel.getHomework_image().equals("0"))
        {
            Picasso.with(context).load("http://anwaralfyaha.anwaralfyaha.com/uploads/images/"+mmodel.getHomework_image()).into(holder.homework);

        }



    }

    @Override
    public int getItemCount() {
        return Array.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        PhotoView homework;


        public Holder(View itemView) {
            super(itemView);

            homework = itemView.findViewById(R.id.img_homework);

        }



    }




}
