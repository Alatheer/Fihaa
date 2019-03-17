package com.Alatheer.alatheer.schooles.Activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.Alatheer.alatheer.schooles.Adapters.Children_Adapter;
import com.Alatheer.alatheer.schooles.Models.ChildrenModel;
import com.Alatheer.alatheer.schooles.R;
import com.Alatheer.alatheer.schooles.Services.Service;
import com.Alatheer.alatheer.schooles.Services.ServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildrenActivity extends AppCompatActivity {

    private ImageView back;
    private RecyclerView allChildren_recView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private String father_national_num;
    private List<ChildrenModel>childrenModelList;
    private ProgressBar progBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
        initView();
        getDataFromIntent();

    }

    private void getDataFromIntent() {

        Intent intent = getIntent();

        if (intent!=null)
        {
            father_national_num = intent.getStringExtra("father_national_num");
        }
    }

    private void initView() {

        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        childrenModelList = new ArrayList<>();
        allChildren_recView = findViewById(R.id.children_recView);
        allChildren_recView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        allChildren_recView.setLayoutManager(manager);
        adapter = new Children_Adapter(this,childrenModelList);
        allChildren_recView.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        DisplayChildrenDetails();
    }

    private void DisplayChildrenDetails() {
        progBar.setVisibility(View.VISIBLE);
        Service service= ServicesApi.CreateApiClient().create(Service.class);
        Call<List<ChildrenModel>> call=service.DisplayChildrenDetails(father_national_num);
        call.enqueue(new Callback<List<ChildrenModel>>() {
            @Override
            public void onResponse(Call<List<ChildrenModel>> call, Response<List<ChildrenModel>> response) {

                if (response.isSuccessful())
                {
                    childrenModelList.clear();
                    childrenModelList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<ChildrenModel>> call, Throwable t) {
                progBar.setVisibility(View.GONE);
                Toast.makeText(ChildrenActivity.this, R.string.something_error, Toast.LENGTH_SHORT).show();
                Log.e("error",t.getMessage());

            }
        });
    }
    public void setPos(int pos)
    {
        ChildrenModel childrenModel = childrenModelList.get(pos);
        Intent intent = new Intent(this,ChildrenFeesDetails.class);
        intent.putExtra("fees_details",childrenModel);
        startActivity(intent);

    }
}
