package com.Alatheer.alatheer.schooles.Activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.Alatheer.alatheer.schooles.Adapters.AllSchools_Adapters;
import com.Alatheer.alatheer.schooles.MVP.DisplayAllSchools_MVP.Presenter;
import com.Alatheer.alatheer.schooles.MVP.DisplayAllSchools_MVP.PresenterImp;
import com.Alatheer.alatheer.schooles.MVP.DisplayAllSchools_MVP.ViewData;
import com.Alatheer.alatheer.schooles.Models.AllSchoolModel;
import com.Alatheer.alatheer.schooles.R;

import java.util.ArrayList;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;

public class AllSchools extends AppCompatActivity implements ViewData {

    private RecyclerView recView_AllSchool;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private List<AllSchoolModel> allSchoolModelList;
    private Presenter presenter;
    private SwipeRefreshLayout swipeRefresh;
    private ProgressBar progressBar;

    private String user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_schools);
        presenter = new PresenterImp(this,this);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {

        Intent intent = getIntent();
        if (intent !=null)
        {
            if (intent.hasExtra("user_type"))
            {
                user_type = intent.getStringExtra("user_type");

            }

        }
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        swipeRefresh       = findViewById(R.id.swipeRefresh);
        progressBar        = findViewById(R.id.progressBar);

        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.y400), PorterDuff.Mode.SRC_IN);


        allSchoolModelList = new ArrayList<>();
        recView_AllSchool  = findViewById(R.id.recView_AllSchool);
        manager            = new LinearLayoutManager(this);
        recView_AllSchool.setLayoutManager(manager);
        recView_AllSchool.setHasFixedSize(true);
        adapter            = new AllSchools_Adapters(allSchoolModelList,this);
        recView_AllSchool.setAdapter(adapter);


        swipeRefresh.setColorSchemeResources(R.color.y400);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.DisplayAllSchools();
            }
        });


    }

    @Override
    public void OnDisplayDataSuccess(List<AllSchoolModel> allSchoolModelList) {
        this.allSchoolModelList.addAll(allSchoolModelList);
        adapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void OnFailed(String error) {
        Toast.makeText(this, "error" + error, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
        swipeRefresh.setRefreshing(false);
    }

    public void setPos(int pos)
    {
        String school_id = allSchoolModelList.get(pos).getId_school();
        String phone = allSchoolModelList.get(pos).getPhone();
        String fax = allSchoolModelList.get(pos).getFax();
        String email = allSchoolModelList.get(pos).getEmail();
        Double school_google_long = allSchoolModelList.get(pos).getSchool_google_long();
        Double school_google_lat = allSchoolModelList.get(pos).getSchool_google_lat();
        String school_name = allSchoolModelList.get(pos).getSchool_name();
        //Intent intent = new Intent(this,Chooser_Activity.class);
        Intent intent = new Intent(this,ActivityVisitorHome.class);
        intent.putExtra("school_id"         ,school_id);
        intent.putExtra("phone"             ,phone);
        intent.putExtra("fax"               ,fax);
        intent.putExtra("email"             ,email);
        intent.putExtra("school_google_long",school_google_long);
        intent.putExtra("school_google_lat" ,school_google_lat);
        intent.putExtra("school_name"       ,school_name);

        intent.putExtra("user_type",user_type);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.DisplayAllSchools();
    }
}
