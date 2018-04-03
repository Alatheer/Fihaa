package com.Alatheer.elashry.Faihaa.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.Alatheer.elashry.Faihaa.Activities.DescActivity;
import com.Alatheer.elashry.Faihaa.Activities.NewsActivity;
import com.Alatheer.elashry.Faihaa.Models.News_Model;
import com.Alatheer.elashry.Faihaa.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;


/**
 * Created by ok on 29/01/2018.
 */

public class All_News_Adapter extends RecyclerView.Adapter<All_News_Adapter.Holder>{
Context context;
    ArrayList<News_Model> news;
    public static double lat;
    public static double longit;
    public static String adress;
    NewsActivity newsActivity;
    private Target target;
    public All_News_Adapter(Context context, ArrayList<News_Model> news) {
        this.context = context;
        this.news = news;
        newsActivity = (NewsActivity) context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        News_Model news_model=news.get(position);

        holder.BindData(news_model);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                newsActivity.setPos(pos);
            }
        });
       //Picasso.with(context).load("http://nsqapp.anwaralfyaha.com/a6d1bd7227d79458109e2e480b8f1da0.png"+Model.getImageName()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return  news.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView title, desc,news_date;
        ImageView image;


        public Holder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            image=itemView.findViewById(R.id.img);
            news_date = itemView.findViewById(R.id.news_date);

        }

        public void BindData(News_Model news_model)
        {
            title.setText(news_model.getNews_title());
            desc.setText(news_model.getNews_content());
            news_date.setText(news_model.getNews_date());

            target = new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    image.setImageBitmap(bitmap);
                }

                @Override
                public void onBitmapFailed(Drawable errorDrawable) {

                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            };

            if (news_model.getImage_name()==null|| TextUtils.isEmpty(news_model.getImage_name())||news_model.getImage_name().equals("0"))
            {
                Picasso.with(context).load(R.drawable.logo).into(target);
            }else
                {
                    Picasso.with(context).load(Uri.parse("http://anwaralfyaha.anwaralfyaha.com/uploads/images/"+news_model.getImage_name())).into(target);

                }

        }

    }
}
