package com.Alatheer.alatheer.schooles.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.Alatheer.alatheer.schooles.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ClassRoom extends AppCompatActivity implements View.OnClickListener {

    CardView homework,absent,activity,honorboard,rate,timetable;
    String class_room_id;
    String user_type;
    private AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_room);
        initView();
        getDataFromIntent();
        builder = new AlertDialog.Builder(this);
        builder.setMessage("هذه الخدمة غير متاحة لك");
        builder.setPositiveButton("إلغاء", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AlertDialog alertDialog = builder.create();
                alertDialog.dismiss();
            }
        });
        builder.create();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("class_room_id"))
            {
                class_room_id = intent.getStringExtra("class_room_id");
                user_type = intent.getStringExtra("user_type");
            }
        }
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        homework   = findViewById(R.id.txt_homework);
        absent     = findViewById(R.id.txt_absent);
        activity   = findViewById(R.id.txt_activities);
        honorboard = findViewById(R.id.txt_honorbourd);
        rate       = findViewById(R.id.txt_rate);
        timetable      = findViewById(R.id.txt_timetable);



        homework  .setOnClickListener(this);
        absent    .setOnClickListener(this);
        activity  .setOnClickListener(this);
        honorboard.setOnClickListener(this);
        rate      .setOnClickListener(this);
        timetable     .setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.txt_homework:
                if (user_type.equals("visitor"))
                {
                    builder.show();
                }else {
                    Intent intent1 = new Intent(this,ActivityHomeWork.class);
                    intent1.putExtra("class_room_id",class_room_id);
                    startActivity(intent1);
                }
                break;
            case R.id.txt_absent:
                if (user_type.equals("visitor"))
                {
                    builder.show();
                }else {
                    Intent intent2 = new Intent(this,ActivityApsent.class);
                    intent2.putExtra("class_room_id",class_room_id);
                    startActivity(intent2);
                }
                break;
            case R.id.txt_timetable:
                if (user_type.equals("visitor"))
                {
                    builder.show();
                }else {
                    Intent intent2 = new Intent(this,ActivityTimeTableStudent.class);
                    intent2.putExtra("class_room_id",class_room_id);
                    startActivity(intent2);
                }
                break;
            case R.id.txt_activities:
                Intent intent3 = new Intent(this,Activities.class);
                intent3.putExtra("class_room_id",class_room_id);
                startActivity(intent3);
                break;
            case R.id.txt_honorbourd:
                Intent intent4 = new Intent(this,HonorBoardStudent.class);
                intent4.putExtra("class_room_id",class_room_id);
                startActivity(intent4);
                break;
            case R.id.txt_rate:
                Intent intent5 = new Intent(this,Student_State.class);
                intent5.putExtra("class_room_id",class_room_id);
                startActivity(intent5);
                break;
           /* case R.id.txt_news:
                Intent intent6 = new Intent(this,NewsActivity.class);
                intent6.putExtra("class_room_id",class_room_id);
                startActivity(intent6);
                break;*/
        }
    }
}
