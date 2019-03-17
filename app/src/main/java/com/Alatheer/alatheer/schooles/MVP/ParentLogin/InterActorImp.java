package com.Alatheer.alatheer.schooles.MVP.ParentLogin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.Alatheer.alatheer.schooles.Models.ParentLoginModel;
import com.Alatheer.alatheer.schooles.Services.Service;
import com.Alatheer.alatheer.schooles.Services.ServicesApi;

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
        Log.e("dffffff","sssssssssssss");

        if (TextUtils.isEmpty(user_id))
        {
            listener.setUserIdError();
        }else
            {
                Retrofit retrofit = ServicesApi.CreateApiClient();
                Service service = retrofit.create(Service.class);
                Call<ParentLoginModel> call = service.ParentLogin(user_id);
                call.enqueue(new Callback<ParentLoginModel>() {
                    @Override
                    public void onResponse(Call<ParentLoginModel> call, Response<ParentLoginModel> response) {
                        if (response.isSuccessful())
                        {
                            Log.e("dffffff","sssssssssssss");
                            ParentLoginModel parentLoginModel = response.body();

                            if (parentLoginModel.getSuccess()==0&&parentLoginModel.getMessage().equals("Wrong Student National Num "))
                            {
                                listener.setNationalIdError();
                            }else if (parentLoginModel.getSuccess()==1&&parentLoginModel.getMessage().equals("User Successfully logged"))
                            {
                                listener.OnDisplayDataSuccess(parentLoginModel);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ParentLoginModel> call, Throwable t) {
                        listener.OnFailed("error something went haywire");
                    }
                });
            }
    }
}
