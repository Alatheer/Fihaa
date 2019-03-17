package com.Alatheer.alatheer.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.alatheer.schooles.Models.Student_Fees_Model;
import com.Alatheer.alatheer.schooles.R;
import com.Alatheer.alatheer.schooles.Services.Service;
import com.Alatheer.alatheer.schooles.Services.ServicesApi;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student_Fees extends AppCompatActivity {

 String student_code;

    TextView name,transport_type,payment_type,current_all_fees,current_remain,current_paid,sub_stages_name,classrooms_name,school_name,txt_transport_fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__fees);
      

        initview();
        getDatafromIntent();
        getDataFromServer();
    }

    private void getDataFromServer() {

        Service service= ServicesApi.CreateApiClient().create(Service.class);
        Call<Student_Fees_Model> call=service.GetStudentFees(student_code);
        call.enqueue(new Callback<Student_Fees_Model>() {
            @Override
            public void onResponse(Call<Student_Fees_Model> call, Response<Student_Fees_Model> response) {
                name.setText(response.body().getName());
                transport_type.setText(response.body().getTransport_type());
                payment_type.setText(response.body().getPayment_type());
                current_all_fees.setText(response.body().getCurrent_all_fees());
                current_remain.setText(response.body().getCurrent_remain());
                current_paid.setText(response.body().getCurrent_paid());
                sub_stages_name.setText(response.body().getSub_stages_name());
                classrooms_name.setText(response.body().getClassrooms_name());
                school_name.setText(response.body().getSchool_name());
                txt_transport_fees.setText(response.body().getTransport_fee());
            }

            @Override
            public void onFailure(Call<Student_Fees_Model> call, Throwable t) {

            }
        });



    }

    private void getDatafromIntent() {
        Intent intent = getIntent();
        if (intent !=null)
        {
            if(intent.hasExtra("student_code"))
            {
                student_code   = intent.getStringExtra("student_code");

                Toast.makeText(this, ""+student_code, Toast.LENGTH_SHORT).show();
            }
        }
        
    }

    private void initview() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        name            =findViewById(R.id.txt_name            );
        transport_type  =findViewById(R.id.txt_transport_type  );
        payment_type    =findViewById(R.id.txt_payment_type    );
        current_all_fees=findViewById(R.id.txt_current_all_fees);
        current_remain  =findViewById(R.id.txt_current_remain  );
        current_paid    =findViewById(R.id.txt_current_paid    );
        sub_stages_name =findViewById(R.id.txt_sub_stages_name );
        classrooms_name =findViewById(R.id.txt_classrooms_name );
        school_name     =findViewById(R.id.txt_school_name     );
        txt_transport_fees =findViewById(R.id.txt_transport_fees);

    }
}
