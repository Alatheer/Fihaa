package com.Alatheer.alatheer.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.alatheer.schooles.Models.School_Fees_Model;
import com.Alatheer.alatheer.schooles.R;
import com.Alatheer.alatheer.schooles.Services.Service;
import com.Alatheer.alatheer.schooles.Services.ServicesApi;


import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySchoolFees extends AppCompatActivity {
    TextView school_name,school_fees,transport_fees,transport_fees2;
    String school_id;
    String type;
    private String school_name1;
    private String tuition_fees;
    private String transfer_fees_1;
    private String transfer_fees_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_fees);

        getDataFromIntent();
        initView();
    }

    private void getDataFromServer() {

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<School_Fees_Model>> call = service.GetSchoolFeesData(school_id);

        call.enqueue(new Callback<List<School_Fees_Model>>() {
            @Override
            public void onResponse(Call<List<School_Fees_Model>> call, Response<List<School_Fees_Model>> response) {

                if (response.isSuccessful()){
                    school_name.setText(response.body().get(0).getSchool_name());
                    school_fees.setText(response.body().get(0).getTuition_fees());
                    transport_fees.setText(response.body().get(0).getTransfer_fees_1());
                    transport_fees2.setText(response.body().get(0).getTransfer_fees_2());

                }else {
                    Toast.makeText(ActivitySchoolFees.this, "No Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<School_Fees_Model>> call, Throwable t) {

            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {

                school_id = intent.getStringExtra("school_id");
                school_name1 = intent.getStringExtra("school_name");
                tuition_fees = intent.getStringExtra("tuition_fees");
                transfer_fees_1 = intent.getStringExtra("transfer_fees_1");
                transfer_fees_2 = intent.getStringExtra("transfer_fees_2");
                type=intent.getStringExtra("type");

        }


    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        school_name =findViewById(R.id.txt_school_name);
        school_fees =findViewById(R.id.txt_school_fees);
        transport_fees=findViewById(R.id.txt_school_trans);
        transport_fees2=findViewById(R.id.txt_school_trans2);
        if (type.equals("student")||type.equals("parent"))
        {
            school_name.setText(school_name1);
            school_fees .setText(tuition_fees);
            transport_fees .setText(transfer_fees_1);
            transport_fees2.setText(transfer_fees_2);
        }
        else if (type.equals("visitor")){
            getDataFromServer();

        }

    }
}
