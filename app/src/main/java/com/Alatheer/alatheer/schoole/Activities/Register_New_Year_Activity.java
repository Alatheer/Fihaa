package com.Alatheer.alatheer.schoole.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.alatheer.schoole.Models.AllStagesModel;
import com.Alatheer.alatheer.schoole.Models.NationalityModel;
import com.Alatheer.alatheer.schoole.Models.ResponseModel;
import com.Alatheer.alatheer.schoole.R;
import com.Alatheer.alatheer.schoole.Services.Service;
import com.Alatheer.alatheer.schoole.Services.ServicesApi;
import com.Alatheer.alatheer.schoole.Services.Tags;
import com.lamudi.phonefield.PhoneInputLayout;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Register_New_Year_Activity extends AppCompatActivity {
    private Spinner spinner_gender,spinner_nat,spinner_stage;
    private EditText edt_name,edt_ident;
    private PhoneInputLayout edt_phone;
    private Button sendBtn;
    private TextView tv_skip;
    private ArrayAdapter<String> adapter_gender,adapter_nat,adapter_stage;
    private String [] genderList;
    private String m_gender="",m_nat="",m_stage="",m_name="",m_ident="",m_phone="";
    private List<NationalityModel> nationalityModelList;
    private List<AllStagesModel> allStagesModelList;
    private List<String> natonalityList;
    private List<String> stageList;
    private AlertDialog dialog;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__new__year_);
        initView();
    }

    private void initView() {
        nationalityModelList = new ArrayList<>();
        allStagesModelList = new ArrayList<>();
        natonalityList = new ArrayList<>();
        stageList = new ArrayList<>();
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

        getNationality();
        getStages();

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    m_gender="";
                }else if (position == 1)
                {
                        m_gender= Tags.girle;
                }else if (position == 2)
                {
                    m_gender=Tags.boy;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_nat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    m_nat="";
                }else
                    {
                        int pos = position-1;
                        m_nat = nationalityModelList.get(pos).getId();
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_stage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    m_stage="";
                }else
                {
                    int pos = position-1;
                    m_stage = allStagesModelList.get(pos).getId();                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        CreateAlertDialog();
        CreateAlertDialog2();


    }

    private void CreateAlertDialog2() {
        alertDialog = new AlertDialog.Builder(this)
                .setCancelable(true)
                .setMessage(R.string.success_regester)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).create();

        alertDialog.setCanceledOnTouchOutside(false);


    }

    private void CreateAlertDialog() {
         dialog = new SpotsDialog.Builder()
                 .setContext(this)
                 .setCancelable(true)
                 .setMessage(R.string.rege)
                 .build();
    }

    private void getNationality()
    {
        Retrofit retrofit = ServicesApi.CreateApiClient();
        retrofit.create(Service.class).getNationality()
                .enqueue(new Callback<List<NationalityModel>>() {
                    @Override
                    public void onResponse(Call<List<NationalityModel>> call, Response<List<NationalityModel>> response) {
                        if (response.isSuccessful())
                        {
                            if (response.body().size()>0)
                            {
                                Log.e("sdfsdfsdfs",response.body().size()+"");
                                Log.e("ee",response.body().get(0).getName_arabic());
                                nationalityModelList = response.body();
                                natonalityList.clear();
                                natonalityList.add(getString(R.string.nat));
                                for (NationalityModel nationalityModel:nationalityModelList)
                                {

                                    natonalityList.add(nationalityModel.getName_arabic());
                                }
                                adapter_nat = new ArrayAdapter<String>(Register_New_Year_Activity.this,R.layout.spinner_item,natonalityList);
                                spinner_nat.setAdapter(adapter_nat);

                            }else
                                {
                                    Log.e("sdfsdfsdfs",response.body().size()+"");

                                }
                        }else
                            {
                                Log.e("sdfsdfsdfs","fsdfsdddddddddddddddd");

                            }
                    }

                    @Override
                    public void onFailure(Call<List<NationalityModel>> call, Throwable t) {
                        Log.e("Error",t.getMessage());
                        Toast.makeText(Register_New_Year_Activity.this, R.string.something_error, Toast.LENGTH_SHORT).show();

                    }
                });

    }
    private void getStages()
    {
        Retrofit retrofit = ServicesApi.CreateApiClient();
        retrofit.create(Service.class)
                .getStagesForRegister()
                .enqueue(new Callback<List<AllStagesModel>>() {
                    @Override
                    public void onResponse(Call<List<AllStagesModel>> call, Response<List<AllStagesModel>> response) {
                        if (response.isSuccessful())
                        {
                            if (response.body().size()>0)
                            {
                                allStagesModelList = response.body();
                                stageList.clear();
                                stageList.add(getString(R.string.stag));
                                for (AllStagesModel allStagesModel:allStagesModelList)
                                {
                                    stageList.add(allStagesModel.getAr_name());
                                }

                                adapter_stage = new ArrayAdapter<String>(Register_New_Year_Activity.this,R.layout.spinner_item,stageList);
                                spinner_stage.setAdapter(adapter_stage);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<AllStagesModel>> call, Throwable t) {
                        Toast.makeText(Register_New_Year_Activity.this, R.string.something_error, Toast.LENGTH_SHORT).show();

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
            edt_name.setError(getString( R.string.empty_name));
        }else if (TextUtils.isEmpty(m_ident))
        {
            edt_name.setError(null);
            edt_ident.setError(getString( R.string.empty_ident));
        }else if (TextUtils.isEmpty(m_phone))
        {
            edt_name.setError(null);
            edt_ident.setError(null);
            edt_phone.getTextInputLayout().getEditText().setError(getString( R.string.empty_phone));
        }else if (!edt_phone.isValid())
        {
            edt_name.setError(null);
            edt_ident.setError(null);
            edt_phone.getTextInputLayout().getEditText().setError(getString(R.string.inv_phone));
        }else
            {
                dialog.show();
                edt_name.setError(null);
                edt_ident.setError(null);
                edt_phone.getTextInputLayout().getEditText().setError(null);

                Log.e("name",m_name);
                Log.e("gender",m_gender);
                Log.e("mstage",m_stage);
                Log.e("mnate",m_nat);
                Log.e("mident",m_ident);
                Log.e("mphone",m_phone);

                ServicesApi.CreateApiClient().create(Service.class)
                        .Register(m_name,m_gender,m_stage,m_nat,m_ident,m_phone)
                        .enqueue(new Callback<ResponseModel>() {
                            @Override
                            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                                if (response.isSuccessful())
                                {
                                    dialog.dismiss();
                                    if (response.body().getSuccess()==0)
                                    {
                                        Toast.makeText(Register_New_Year_Activity.this, R.string.error_try_later,Toast.LENGTH_LONG).show();
                                    }else if (response.body().getSuccess()==1)
                                    {
                                        alertDialog.show();
                                    }

                                    Log.e("0",response.body().getSuccess()+"");
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseModel> call, Throwable t) {
                                Log.e("error",t.getMessage());
                                Toast.makeText(Register_New_Year_Activity.this,R.string.error_try_later,Toast.LENGTH_LONG).show();

                            }
                        });
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
