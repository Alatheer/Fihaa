package com.Alatheer.alatheer.schoole.MVP.LoginMVP;

import android.content.Context;
import android.text.TextUtils;

import com.Alatheer.alatheer.schoole.Models.LoginModel;
import com.Alatheer.alatheer.schoole.Services.Service;
import com.Alatheer.alatheer.schoole.Services.ServicesApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by elashry on 3/3/2018.
 */

public class InterActorImp implements InterActor {

    @Override
    public void Login(String user_id, final onCompleteListener listener, Context context) {
        if (TextUtils.isEmpty(user_id))
        {
            listener.setUserIdError();
        }else
            {
                Retrofit retrofit = ServicesApi.CreateApiClient();
                Service service = retrofit.create(Service.class);
                Call<LoginModel> call = service.Login(user_id);
                call.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        if (response.isSuccessful())
                        {
                            LoginModel loginModel = response.body();

                            if (loginModel.getSuccess()==0&&loginModel.getMessage().equals("Wrong Student National Num "))
                            {
                                listener.setNationalIdError();
                            }else if (loginModel.getSuccess()==1&&loginModel.getMessage().equals("User Successfully logged"))
                            {
                                listener.OnDisplayDataSuccess(loginModel);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        listener.OnFailed("error something went haywire");
                    }
                });
            }
    }
}
