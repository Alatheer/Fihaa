package com.Alatheer.alatheer.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.Alatheer.alatheer.schooles.Adapters.SubClassesAdapter;
import com.Alatheer.alatheer.schooles.Models.Stud_ClassModel;
import com.Alatheer.alatheer.schooles.R;

import java.util.ArrayList;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;

public class SubClassesActivity extends AppCompatActivity {

    private RecyclerView recView_SubClasses;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private List<Stud_ClassModel> subClassesList;
    private String user_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_classes);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("subClassesList"))
            {
                subClassesList = (List<Stud_ClassModel>) intent.getSerializableExtra("subClassesList");
                user_type = intent.getStringExtra("user_type");
                UpdateUi(subClassesList);
            }
        }
    }

    private void UpdateUi(List<Stud_ClassModel> subClassesList) {
        adapter = new SubClassesAdapter(this,subClassesList);
        recView_SubClasses.setAdapter(adapter);
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        subClassesList = new ArrayList<>();
        recView_SubClasses = findViewById(R.id.recView_SubClasses);
        manager = new GridLayoutManager(this,3);
        recView_SubClasses.setLayoutManager(manager);
        recView_SubClasses.setHasFixedSize(true);



    }
    public void setPos(int pos)
    {
        Stud_ClassModel subClasses =subClassesList.get(pos);
        Intent intent = new Intent(this,ClassRoom.class);
        Log.e("class_room_id",subClasses.getId_class_room());
        intent.putExtra("class_room_id",subClasses.getId_class_room());
        intent.putExtra("user_type",user_type);
        startActivity(intent);
    }
}
