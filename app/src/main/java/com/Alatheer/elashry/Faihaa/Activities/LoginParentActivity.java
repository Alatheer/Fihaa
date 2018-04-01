package com.Alatheer.elashry.Faihaa.Activities;

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

import com.Alatheer.elashry.Faihaa.MVP.LoginMVP.Presenter;
import com.Alatheer.elashry.Faihaa.MVP.LoginMVP.PresenterImp;
import com.Alatheer.elashry.Faihaa.MVP.ParentLogin.ViewData;
import com.Alatheer.elashry.Faihaa.Models.LoginModel;
import com.Alatheer.elashry.Faihaa.Models.ParentLoginModel;
import com.Alatheer.elashry.Faihaa.Preferense;
import com.Alatheer.elashry.Faihaa.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class LoginParentActivity extends AppCompatActivity implements ViewData {
    private ShimmerTextView shimmer;
    private Button login;
    private String school_id,id;
    private EditText user_id;
    private com.Alatheer.elashry.Faihaa.MVP.ParentLogin.Presenter presenter;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_parent);
        initView();


        ProgressBar progressBar = new ProgressBar(this);
        Drawable mutate = progressBar.getIndeterminateDrawable().mutate();
        mutate.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        dialog = new ProgressDialog(this);
        dialog.setIndeterminateDrawable(mutate);
        dialog.setMessage(getString(R.string.log_in));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);


        presenter =new com.Alatheer.elashry.Faihaa.MVP.ParentLogin.PresenterImp(this,this);
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
        user_id.setError("Wrong parent National Number");
        dialog.dismiss();
    }

    @Override
    public void OnDisplayDataSuccess(ParentLoginModel parentLoginModel) {
        Preferense pref = new Preferense(LoginParentActivity.this);
        pref.CreateSharedPref(parentLoginModel.getFather_national_num(),"parent");
        Intent intent = new Intent(LoginParentActivity.this, Home.class);
        //   intent.putExtra("school_id",school_id);
        intent.putExtra("parent_code",parentLoginModel.getFather_national_num());
        intent.putExtra("user_type","parent");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        dialog.dismiss();
        startActivity(intent);
        Log.e("parent_coode",parentLoginModel.getFather_national_num());
        finish();
    }

    @Override
    public void OnFailed(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
        dialog.dismiss();

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences=getSharedPreferences("id",MODE_PRIVATE);
        id=sharedPreferences.getString("user_id","");

        if (!TextUtils.isEmpty(id)) {
            Log.e("iddddddddffffffffffff",id);

            Intent intent = new Intent(LoginParentActivity.this, Home.class);
            intent.putExtra("code", id);
            intent.putExtra("user_type","parent");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            dialog.dismiss();

            finish();
        }
    }
}
