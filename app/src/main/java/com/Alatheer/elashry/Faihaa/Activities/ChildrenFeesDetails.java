package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Alatheer.elashry.Faihaa.Models.ChildrenModel;
import com.Alatheer.elashry.Faihaa.R;

public class ChildrenFeesDetails extends AppCompatActivity {

    private ImageView back;
    private ChildrenModel childrenModel;
    private TextView child_name,school_name,payment_type,transport_type,current_fees,current_remain,current_paid,sub_stages_name,classrooms_name,transport_fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_fees_details);

        initView();
        getDataFromIntent();
    }

    private void initView() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        child_name = findViewById(R.id.name);
        school_name = findViewById(R.id.school_name);
        payment_type = findViewById(R.id.payment_type);
        transport_type = findViewById(R.id.transport_type);
        current_fees = findViewById(R.id.current_fees);
        current_remain = findViewById(R.id.current_remain);
        current_paid = findViewById(R.id.current_paid);
        sub_stages_name = findViewById(R.id.sub_stages);
        classrooms_name = findViewById(R.id.classrooms);
        transport_fee = findViewById(R.id.transport_fee);

    }

    private void getDataFromIntent() {
        Intent intent = getIntent();

        if (intent!=null)
        {
            childrenModel = (ChildrenModel) intent.getSerializableExtra("fees_details");
            UpdateUI(childrenModel);
        }
    }

    private void UpdateUI(ChildrenModel childrenModel) {
        child_name.setText(childrenModel.getName());
        school_name.setText(childrenModel.getSchool_name());
        payment_type.setText(childrenModel.getPayment_type());
        transport_type.setText(childrenModel.getTransport_type());
        current_fees.setText(childrenModel.getCurrent_all_fees());
        current_remain.setText(childrenModel.getCurrent_remain());
        current_paid.setText(childrenModel.getCurrent_paid());
        sub_stages_name.setText(childrenModel.getSub_stages_name());
        classrooms_name.setText(childrenModel.getClassrooms_name());
        transport_fee.setText(childrenModel.getTransport_fee());
    }
}
