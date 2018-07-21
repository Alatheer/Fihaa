package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.elashry.Faihaa.R;
import com.lamudi.phonefield.PhoneInputLayout;

public class Register_New_Year_Activity extends AppCompatActivity {
    private Spinner spinner_gender,spinner_nat,spinner_stage;
    private EditText edt_name,edt_ident;
    private PhoneInputLayout edt_phone;
    private Button sendBtn;
    private TextView tv_skip;
    private ArrayAdapter<String> adapter_gender,adapter_nat,adapter_stage;
    private String [] genderList;
    private String m_gender="",m_nat="",m_stage="",m_name="",m_ident="",m_phone="";
    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__new__year_);
        initView();
    }

    private void initView() {
        genderList = getResources().getStringArray(R.array.gender_array);
        spinner_gender = findViewById(R.id.spinner_gender);
        spinner_nat = findViewById(R.id.spinner_nat);
        spinner_stage = findViewById(R.id.spinner_stage);
        edt_name = findViewById(R.id.edt_name);
        edt_ident = findViewById(R.id.edt_ident);
        edt_phone = findViewById(R.id.edt_phone);
        sendBtn = findViewById(R.id.btn_send);
        tv_skip = findViewById(R.id.tv_skip);
        edt_phone.getTextInputLayout().getEditText().setHint(getString(R.string.phone));
        edt_phone.getTextInputLayout().getEditText().setTextSize(TypedValue.COMPLEX_UNIT_SP,13f);
        edt_phone.setDefaultCountry("sa");

        adapter_gender = new ArrayAdapter<>(this,R.layout.spinner_item,genderList);
        spinner_gender.setAdapter(adapter_gender);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Register_New_Year_Activity.this,AllSchools.class);
                intent.putExtra("user_type","visitor");
                startActivity(intent);
                finish();
            }
        });
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i==0)
                {
                    m_gender="";
                }else
                    {
                        m_gender = genderList[i];
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void sendData() {
        m_ident = edt_ident.getText().toString();
        m_name = edt_name.getText().toString();
        m_phone = edt_phone.getPhoneNumber();

        if (TextUtils.isEmpty(m_nat))
        {
            Toast.makeText(this, R.string.ch_nat, Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(m_gender))
        {
            Toast.makeText(this, R.string.ch_gender, Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(m_stage))
        {
            Toast.makeText(this, R.string.ch_stage, Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(m_name))
        {
            Toast.makeText(this, R.string.empty_name, Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(m_ident))
        {
            Toast.makeText(this, R.string.empty_ident, Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(m_phone))
        {
            Toast.makeText(this, R.string.empty_phone, Toast.LENGTH_LONG).show();
        }else if (!edt_phone.isValid())
        {
            Toast.makeText(this, R.string.inv_phone, Toast.LENGTH_LONG).show();
        }else
            {
                HideKeyBoard();
            }

    }

    private void HideKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(edt_ident.getWindowToken(),0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Register_New_Year_Activity.this,Chooser_Activity.class);
        startActivity(intent);
        finish();
    }
}
