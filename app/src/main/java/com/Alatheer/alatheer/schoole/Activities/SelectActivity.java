package com.Alatheer.alatheer.schoole.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.Alatheer.alatheer.schoole.Models.School_Fees_Model;
import com.Alatheer.alatheer.schoole.R;
import com.Alatheer.alatheer.schoole.Services.Service;
import com.Alatheer.alatheer.schoole.Services.ServicesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener{
    Button fees,about;
    private String school_name;
    private String phone;
    private String fax;
    private String email;
    private String tuition_fees;
    private String transfer_fees_1;
    private String transfer_fees_2;
    private Double school_google_lat;
    private Double school_google_long;
    String code,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        getDataFromIntent();
        initView();

    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent !=null)
        {

                code=intent.getStringExtra("code");
                type=intent.getStringExtra("user_type");
Log.e("mmmm",code+type);
        }
    }

    private void getFatherSchoolData() {

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<School_Fees_Model>> call = service.GetFatherSchoolDetials(code);

        call.enqueue(new Callback<List<School_Fees_Model>>() {
            @Override
            public void onResponse(Call<List<School_Fees_Model>> call, Response<List<School_Fees_Model>> response) {

                if (response.isSuccessful()) {
                    school_name=response.body().get(0).getSchool_name();
                    phone=response.body().get(0).getPhone();
                    fax=response.body().get(0).getFax();
                    email=response.body().get(0).getEmail();
                    tuition_fees=response.body().get(0).getTuition_fees();
                    transfer_fees_1=response.body().get(0).getTransfer_fees_1();
                    transfer_fees_2=response.body().get(0).getTransfer_fees_2();
                    school_google_lat=response.body().get(0).getSchool_google_lat();
                    school_google_long=response.body().get(0).getSchool_google_long();
                    Log.e("ccc",school_name+phone+tuition_fees);
                }

            }

            @Override
            public void onFailure(Call<List<School_Fees_Model>> call, Throwable t) {

                Toast.makeText(SelectActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void getStudentSchoolData() {

            Service service = ServicesApi.CreateApiClient().create(Service.class);
            Call<List<School_Fees_Model>> call = service.GetStudentSchoolData(code);

            call.enqueue(new Callback<List<School_Fees_Model>>() {
                @Override
                public void onResponse(Call<List<School_Fees_Model>> call, Response<List<School_Fees_Model>> response) {

                    if (response.isSuccessful()) {
                        school_name=response.body().get(0).getSchool_name();
                        phone=response.body().get(0).getPhone();
                        fax=response.body().get(0).getFax();
                        email=response.body().get(0).getEmail();
                        tuition_fees=response.body().get(0).getTuition_fees();
                        transfer_fees_1=response.body().get(0).getTransfer_fees_1();
                        transfer_fees_2=response.body().get(0).getTransfer_fees_2();
                        school_google_lat=response.body().get(0).getSchool_google_lat();
                        school_google_long=response.body().get(0).getSchool_google_long();
                        Log.e("sssss",school_name+phone+tuition_fees);

                    }
                }

                @Override
                public void onFailure(Call<List<School_Fees_Model>> call, Throwable t) {
                    Toast.makeText(SelectActivity.this, "failed", Toast.LENGTH_SHORT).show();


                }
            });


    }
    private void initView() {
        fees=findViewById(R.id.school_fees);
        about=findViewById(R.id.aboutus);

        fees.setOnClickListener(this);
        about.setOnClickListener(this);

        if (type.equals("student"))
        {
            getStudentSchoolData();
        }else if (type.equals("parent"))
        {
            getFatherSchoolData();

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.aboutus:
                Intent intent4=new Intent(SelectActivity.this,ActivityAboutUs.class);
                intent4.putExtra("type"              , type             );
                intent4.putExtra("phone"             , phone             );
                intent4.putExtra("fax"               , fax               );
                intent4.putExtra("email"             , email             );
                intent4.putExtra("school_google_long", school_google_long);
                intent4.putExtra("school_google_lat" , school_google_lat );
                intent4.putExtra("school_name"       , school_name       );
                startActivity(intent4);
                break;

            case R.id.school_fees:
                Intent intent3=new Intent(SelectActivity.this,ActivitySchoolFees.class);
                intent3.putExtra("type"             , type             );
                intent3.putExtra("school_name"       , school_name       );
                intent3.putExtra("tuition_fees"             , tuition_fees             );
                intent3.putExtra("transfer_fees_1"            , transfer_fees_1               );
                intent3.putExtra("transfer_fees_2"             , transfer_fees_2             );

                startActivity(intent3);
                break;
        }

    }
}
