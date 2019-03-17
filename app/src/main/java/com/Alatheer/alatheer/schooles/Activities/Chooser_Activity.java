package com.Alatheer.alatheer.schooles.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.Alatheer.alatheer.schooles.Models.CheckRegister;
import com.Alatheer.alatheer.schooles.R;
import com.Alatheer.alatheer.schooles.Services.Service;
import com.Alatheer.alatheer.schooles.Services.ServicesApi;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Chooser_Activity extends AppCompatActivity {
    LinearLayout student,employee,visitor,parent;
    String id ,user_type;
    ShimmerTextView textShimmer;
    Shimmer  shimmer;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser_);

        initView();

        SharedPreferences sharedPreferences=getSharedPreferences("id",MODE_PRIVATE);
        id=sharedPreferences.getString("user_id","");
        if (!TextUtils.isEmpty(id)) {
            user_type = sharedPreferences.getString("user_type","");

            Log.e("user_type idddd",user_type+"\n"+id);
            if (user_type.equals("student"))
            {
                Intent intent = new Intent(Chooser_Activity.this, Home.class);
                intent.putExtra("student_code", id);
                intent.putExtra("user_type",user_type);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                finish();
            }else if (user_type.equals("parent"))
            {
                Intent intent = new Intent(Chooser_Activity.this, Home.class);
                intent.putExtra("parent_code", id);
                intent.putExtra("user_type",user_type);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

        }

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,LoginActivity.class);
                intent.putExtra("user_type","student");
                startActivity(intent);
                finish();

            }
        });

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,WebViewEmployee.class);
                intent.putExtra("user_type","employee");
                startActivity(intent);
                finish();

            }
        });
        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,AllSchools.class);
                intent.putExtra("user_type","visitor");
                startActivity(intent);
                finish();

            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,LoginParentActivity.class);
                intent.putExtra("user_type","parent");
                startActivity(intent);
                finish();

            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,Register_New_Year_Activity.class);
                startActivity(intent);
                finish();

            }
        });


    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        student=findViewById(R.id.student);
        employee=findViewById(R.id.employee);
        visitor=findViewById(R.id.visitor);
        parent = findViewById(R.id.parent);
        textShimmer=findViewById(R.id.textShimmer);
        cardView=findViewById(R.id.cardView);

        shimmer=new Shimmer();
        shimmer.setDirection(Shimmer.ANIMATION_DIRECTION_RTL);
        shimmer.setDuration(3000);
        shimmer.start(textShimmer);


        CheckRegistration_Open();

    }

    private void CheckRegistration_Open() {
        Retrofit retrofit = ServicesApi.CreateApiClient();
        retrofit.create(Service.class).checkRegistration()
                .enqueue(new Callback<CheckRegister>() {
                    @Override
                    public void onResponse(Call<CheckRegister> call, Response<CheckRegister> response) {
                        if (response.isSuccessful())
                        {
                            if (response.body().getRegester_state()==0)
                            {
                                cardView.setVisibility(View.INVISIBLE);
                            }else if (response.body().getRegester_state()==1)
                            {
                                cardView.setVisibility(View.VISIBLE);

                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<CheckRegister> call, Throwable t) {
                        Toast.makeText(Chooser_Activity.this, R.string.something_error, Toast.LENGTH_LONG).show();
                    }
                });
    }



}
