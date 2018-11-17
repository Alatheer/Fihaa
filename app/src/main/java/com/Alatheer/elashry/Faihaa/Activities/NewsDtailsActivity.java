package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Alatheer.elashry.Faihaa.Models.News_Model;
import com.Alatheer.elashry.Faihaa.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class NewsDtailsActivity extends AppCompatActivity {

    private ImageView back;
    private PhotoView news_img;
    private TextView school_name,news_date,news_title,news_content;
    private Target target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_dtails);

        initView();

        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent() ;
        if (intent!=null)
        {
            News_Model news_model = (News_Model) intent.getSerializableExtra("details");

            UpdateUI(news_model);
        }
    }

    private void UpdateUI(News_Model news_model) {

        school_name.setText(news_model.getSchool_name());
        news_date.setText(news_model.getNews_date());
        news_title.setText(news_model.getNews_title());
        news_content.setText(news_model.getNews_content());

        target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                news_img.setImageBitmap(bitmap);
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
            Picasso.with(this).load(R.drawable.logo).into(target);
        }else
        {
            Picasso.with(this).load(Uri.parse("http://anwaralfyaha.anwaralfyaha.com/uploads/images/"+news_model.getImage_name())).into(target);

        }

    }

    private void initView() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        news_img = findViewById(R.id.news_img);
        school_name = findViewById(R.id.school_name);
        news_date = findViewById(R.id.news_date);
        news_title = findViewById(R.id.news_title);
        news_content = findViewById(R.id.news_details);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Picasso.with(this).cancelRequest(target);
    }
}
