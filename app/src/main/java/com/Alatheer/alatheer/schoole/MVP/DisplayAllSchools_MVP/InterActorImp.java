package com.Alatheer.alatheer.schoole.MVP.DisplayAllSchools_MVP;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.Alatheer.alatheer.schoole.Models.AllSchoolModel;
import com.Alatheer.alatheer.schoole.Services.Service;
import com.Alatheer.alatheer.schoole.Services.ServicesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by elashry on 3/3/2018.
 */

public class InterActorImp implements InterActor {



    @Override
    public void DisplayAllSchools(final onCompleteListener listener, final Context context) {

        Retrofit retrofit = ServicesApi.CreateApiClient();
        Service service = retrofit.create(Service.class);
        Call<List<AllSchoolModel>> call = service.DiaplayAll_Schools();
        call.enqueue(new Callback<List<AllSchoolModel>>() {
            @Override
            public void onResponse(Call<List<AllSchoolModel>> call, Response<List<AllSchoolModel>> response) {
                if (response.isSuccessful())
                {
                    List <AllSchoolModel> allSchoolModelList = response.body();
                    listener.OnDisplayDataSuccess(allSchoolModelList);

                }else
                    {
                        listener.OnFailed("something went haywire");
                    }
            }

            @Override
            public void onFailure(Call<List<AllSchoolModel>> call, Throwable t) {

                if (t.getMessage().contains("failed to connect to"))
                {
                    Toast.makeText(context, "Error contacting please check network connection", Toast.LENGTH_SHORT).show();
                }else
                    {
                        listener.OnFailed("something went haywire");

                    }


                Log.e("errrroooooooooor",t.getMessage());
            }
        });
    }
}
