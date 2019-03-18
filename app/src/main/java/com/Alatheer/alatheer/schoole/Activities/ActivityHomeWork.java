package com.Alatheer.alatheer.schoole.Activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.Alatheer.alatheer.schoole.Adapters.HomeWorkAdapter;
import com.Alatheer.alatheer.schoole.Models.HomeWorkModel;
import com.Alatheer.alatheer.schoole.R;
import com.Alatheer.alatheer.schoole.Services.Service;
import com.Alatheer.alatheer.schoole.Services.ServicesApi;

import java.util.ArrayList;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityHomeWork extends AppCompatActivity {
    ArrayList<HomeWorkModel> model;
    HomeWorkAdapter adapter;
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    String class_room_id;
    private ProgressBar progBar;
    private LinearLayout nodata_container;
    private SwipeRefreshLayout sr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);

        getDataFromIntent();
        initView();
        getDataFromServer();
    }

    private void getDataFromServer() {

        progBar.setVisibility(View.VISIBLE);

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<HomeWorkModel>> call = service.GetHomeworkStudent(class_room_id);
        call.enqueue(new Callback<List<HomeWorkModel>>() {
            @Override
            public void onResponse(Call<List<HomeWorkModel>> call, Response<List<HomeWorkModel> > response) {


                model.clear();
                model.addAll( response.body());


                if (model.size()>0){
                    adapter.notifyDataSetChanged();
                    progBar.setVisibility(View.GONE);
                    sr.setRefreshing(false);
                    // Toast.makeText(Activities.this, "no activities", Toast.LENGTH_SHORT).show();
                }else {
                    progBar.setVisibility(View.GONE);
                    nodata_container.setVisibility(View.VISIBLE);
                    sr.setRefreshing(false);
                }

            }

            @Override
            public void onFailure(Call<List<HomeWorkModel>> call, Throwable t) {
                nodata_container.setVisibility(View.GONE);
                sr.setRefreshing(false);
            }
        });
    }

    private void initView() {
        sr = findViewById(R.id.sr);
        sr.setRefreshing(false);

        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        nodata_container = findViewById(R.id.nodata_container);
        sr.setColorSchemeResources(R.color.colorPrimary);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromServer();
            }
        });
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        recyclerView = findViewById(R.id.rec_homework);
        model = new ArrayList<>();
        mLayoutManager=new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new HomeWorkAdapter(this, model);
        recyclerView.setAdapter(adapter);
    }

    private void getDataFromIntent() {

        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("class_room_id"))
            {
                class_room_id = intent.getStringExtra("class_room_id");
            }
        }

    }

}

