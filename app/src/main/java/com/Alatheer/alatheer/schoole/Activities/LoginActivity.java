package com.Alatheer.alatheer.schoole.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.Alatheer.alatheer.schoole.MVP.LoginMVP.Presenter;
import com.Alatheer.alatheer.schoole.MVP.LoginMVP.PresenterImp;
import com.Alatheer.alatheer.schoole.MVP.LoginMVP.ViewData;
import com.Alatheer.alatheer.schoole.Models.LoginModel;
import com.Alatheer.alatheer.schoole.Preferense;
import com.Alatheer.alatheer.schoole.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class LoginActivity extends AppCompatActivity implements ViewData {

    private ShimmerTextView shimmer;
    private Button login;
    private String school_id,id;
    private EditText user_id;
    private Presenter presenter;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        ProgressBar progressBar = new ProgressBar(this);
        Drawable mutate = progressBar.getIndeterminateDrawable().mutate();
        mutate.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        dialog = new ProgressDialog(this);
        dialog.setIndeterminateDrawable(mutate);
        dialog.setMessage(getString(R.string.log_in));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);

        SharedPreferences sharedPreferences=getSharedPreferences("id",MODE_PRIVATE);
         id=sharedPreferences.getString("user_id","");
        if (!TextUtils.isEmpty(id)) {
            Intent intent = new Intent(LoginActivity.this, Home.class);
            intent.putExtra("student_code", id);
            intent.putExtra("user_type","student");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            dialog.dismiss();

            finish();
        }
        presenter = new PresenterImp(this,this);

       // getDataFromIntent();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                String id2 = user_id.getText().toString();
                presenter.Login(id2);

            }
        });
    }

   /* private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("school_id"))
            {
                school_id = intent.getStringExtra("school_id");
            }

        }*/
    //}

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        user_id = findViewById(R.id.user_id);
        shimmer = findViewById(R.id.shimmer);
        login =findViewById(R.id.btnlogin);
        Shimmer shimmer2 = new Shimmer();
        shimmer2.setDuration(1500)
                .setStartDelay(300);
        shimmer2.start(shimmer);

    }

    @Override
    public void setUserIdError() {
        user_id.setError("empty field");
        dialog.dismiss();
    }


    @Override
    public void setNationalIdError() {
        user_id.setError("Wrong Student National Number");
        dialog.dismiss();
    }

    @Override
    public void OnDisplayDataSuccess(LoginModel loginModel) {

        Preferense pref = new Preferense(LoginActivity.this);
        pref.CreateSharedPref(loginModel.getStudent_code(),"student");
        Intent intent = new Intent(LoginActivity.this, Home.class);
     //   intent.putExtra("school_id",school_id);
        Log.e("cooooode",loginModel.getStudent_code());
        intent.putExtra("student_code",loginModel.getStudent_code());
        intent.putExtra("user_type","student");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        dialog.dismiss();
        startActivity(intent);
        finish();
    }

    @Override
    public void OnFailed(String error) {

        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
