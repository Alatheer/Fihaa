package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.elashry.Faihaa.Adapters.SubStagesAdapter;
import com.Alatheer.elashry.Faihaa.MVP.DisplaySubClasses.Presenter;
import com.Alatheer.elashry.Faihaa.MVP.DisplaySubClasses.PresenterImp;
import com.Alatheer.elashry.Faihaa.MVP.DisplaySubClasses.ViewData;
import com.Alatheer.elashry.Faihaa.Models.Schools_Stages;
import com.Alatheer.elashry.Faihaa.Models.SubClasses;
import com.Alatheer.elashry.Faihaa.Models.SubStages;
import com.Alatheer.elashry.Faihaa.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;

public class SafofActivity extends AppCompatActivity implements ViewData {

    private RecyclerView recView_sufouf;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private Schools_Stages school_stages;
    private TextView stage_name;
    private List<SubStages> subStages;
    private Presenter presenter;
    private String user_type,code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safof);
        presenter = new PresenterImp(this,this);
        initView();
        getDataFromIntent();
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        subStages = new ArrayList<>();
        stage_name = findViewById(R.id.stage_name);
        recView_sufouf = findViewById(R.id.recView_sufouf);
        manager = new GridLayoutManager(this,3);
        recView_sufouf.setLayoutManager(manager);
        recView_sufouf.setHasFixedSize(true);


    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("schools_stages"))
            {
                school_stages = (Schools_Stages) intent.getSerializableExtra("schools_stages");
                user_type = intent.getStringExtra("user_type");
                code=intent.getStringExtra("code");
                UpdateUi(school_stages);

            }
        }

    }

    private void UpdateUi(Schools_Stages school_stages) {
        stage_name.setText(school_stages.getStage_name());
        subStages = school_stages.getSub_stage();
        adapter = new SubStagesAdapter(this,subStages);
        recView_sufouf.setAdapter(adapter);
    }

    public void setPos(int pos)
    {
        presenter.DisplayAllSubClasses(subStages.get(pos).getSub_stages_id(),code,user_type);
       // Toast.makeText(this, ""+subStages.get(pos).getSub_stages_id(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnDisplayDataSuccess(List<SubClasses> subClassesList) {

        Intent intent = new Intent(SafofActivity.this,SubClassesActivity.class);
        intent.putExtra("subClassesList", (Serializable) subClassesList);
        intent.putExtra("user_type",user_type);

        startActivity(intent);

    }

    @Override
    public void OnFailed(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();

    }
}
