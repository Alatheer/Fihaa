package com.Alatheer.alatheer.schoole.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.Alatheer.alatheer.schoole.MVP.Display_AllSubStages.Presenter;
import com.Alatheer.alatheer.schoole.MVP.Display_AllSubStages.PresenterImp;
import com.Alatheer.alatheer.schoole.MVP.Display_AllSubStages.ViewData;
import com.Alatheer.alatheer.schoole.Models.ModelStage;
import com.Alatheer.alatheer.schoole.Models.ModelStage_Parent;
import com.Alatheer.alatheer.schoole.Preferense;
import com.Alatheer.alatheer.schoole.R;
import com.Alatheer.alatheer.schoole.Services.Service;
import com.Alatheer.alatheer.schoole.Services.ServicesApi;
import com.szugyi.circlemenu.view.CircleLayout;

import java.io.Serializable;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Home extends AppCompatActivity  implements ViewData, CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener{

    private CircleLayout circleLayout;
    private Presenter presenter;
    private String school_id;
    private String student_code,father_national_num;
    Button logout,student_fees,school_fees,classes,news,game;
    private Preferense preferense;
    private String user_type;
    private AlertDialog.Builder builder;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new PresenterImp(this,this);
        preferense = new Preferense(this);
        getDataFromIntent();

        initView();

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



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (user_type.equals("student"))
            {
                preferense.clear();
                Intent intent = new Intent(Home.this, Chooser_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }else if (user_type.equals("parent"))
            {
                preferense.clear();

                Intent intent = new Intent(Home.this, Chooser_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }else if (user_type.equals("visitor"))
            {
                Intent intent = new Intent(Home.this, Chooser_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }


            }
        });
        student_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user_type.equals("student"))
                {
                    Intent i4= new Intent(Home.this, Student_Fees.class);
                    i4.putExtra("student_code",student_code);
                    startActivity(i4);
                }else if (user_type.equals("parent"))
                {
                    Intent intent= new Intent(Home.this, ChildrenActivity.class);
                    intent.putExtra("father_national_num",father_national_num);
                    startActivity(intent);
                    //student
                }else if (user_type.equals("visitor"))
                {
                    builder.show();
                }

            }
        });
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_type.equals("parent")){
                    DisplayAll_SubStages_Parent(father_national_num);

                }
                else if (user_type.equals("student"))
                {
                 presenter.DisplayAll_SubStages(school_id,student_code,user_type);


                }
            }
        });


        school_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_type.equals("student"))
                {
                Intent i3= new Intent(Home.this, SelectActivity.class);
                i3.putExtra("code",student_code);
                i3.putExtra("user_type",user_type);

                    startActivity(i3);
                }
                else if (user_type.equals("parent")){
                    Intent i3= new Intent(Home.this, SelectActivity.class);
                    i3.putExtra("code",father_national_num);
                    i3.putExtra("user_type",user_type);
                    startActivity(i3);
                }
            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(Home.this, NewsActivity.class);
                i3.putExtra("user_type",user_type);
                startActivity(i3);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(Home.this, CopyRight.class);
                startActivity(i3);
            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6=new Intent(Home.this,WebViewEmployee.class);
                intent6.putExtra("game","game");

                startActivity(intent6);
            }
        });
    }

    private void DisplayAll_SubStages_Parent(final String father_national_num) {
        Retrofit retrofit = ServicesApi.CreateApiClient();
        Service service = retrofit.create(Service.class);
        Call<List<ModelStage_Parent>> call = service.DisplayAll_Parent_SubStages(father_national_num);
        call.enqueue(new Callback<List<ModelStage_Parent>>() {
            @Override
            public void onResponse(Call<List<ModelStage_Parent>> call, Response<List<ModelStage_Parent>> response) {
                if (response.isSuccessful())
                {
                    if (response.body().size()>0)
                    {
                        Intent intent = new Intent(Home.this,SafofActivity.class);
                        intent.putExtra("schools_classes_parent", (Serializable) response.body());
                        intent.putExtra("user_type",user_type);
                        intent.putExtra("code",father_national_num);

                        startActivity(intent);
                    }else
                        {
                            Toast.makeText(Home.this, "لاتوجد بيانات لعرضها", Toast.LENGTH_SHORT).show();
                        }
                }
            }

            @Override
            public void onFailure(Call<List<ModelStage_Parent>> call, Throwable t) {

            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent !=null)
        {
            if (intent.hasExtra("user_type"))
            {
                user_type = intent.getStringExtra("user_type");
                Log.e("usertype",user_type);

                if(user_type.equals("student"))
                {
                    // school_id = intent.getStringExtra("school_id");
                    student_code   = intent.getStringExtra("student_code");
                    user_type = "student";
                    Log.e("scode",student_code);

                    //  Toast.makeText(this, ""+student_code, Toast.LENGTH_SHORT).show();
                }else if (user_type.equals("parent"))
                {
                    father_national_num = intent.getStringExtra("parent_code");

                    Log.e("pcode",""+father_national_num);
                    user_type = "parent";
                }

            }

        }
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        fab =  findViewById(R.id.fab);
        logout=findViewById(R.id.btn_logout);
        student_fees=findViewById(R.id.btn_student_fees);
        school_fees=findViewById(R.id.btn_school_fees);
        classes=findViewById(R.id.classes);
        news=findViewById(R.id.btn_news);
        game=findViewById(R.id.game);

       // circleLayout=findViewById(R.id.circle);
       // circleLayout.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view) {


}

    @Override
    public void onRotationFinished(View view) {

    }

    @Override
    public void OnDisplayDataSuccess(List<ModelStage> schools_stages) {

        List<ModelStage> schools_stagesList = schools_stages;
        //ModelStage modelStage = schools_stagesList.get(0);
        if (user_type.equals("student")){
        Intent intent = new Intent(Home.this,SafofActivity.class);
        intent.putExtra("schools_classes", (Serializable) schools_stagesList);
        intent.putExtra("user_type",user_type);
        intent.putExtra("code",student_code);

        startActivity(intent);
        }
       /* else if (user_type.equals("parent")){
            Intent intent = new Intent(Home.this,SafofActivity.class);
            intent.putExtra("schools_classes", (Serializable) schools_stagesList);
            intent.putExtra("user_type",user_type);
            intent.putExtra("code",father_national_num);

            startActivity(intent);
        }*/

    }

    @Override
    public void OnFailed(String error) {

        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        finish();
    }
}
