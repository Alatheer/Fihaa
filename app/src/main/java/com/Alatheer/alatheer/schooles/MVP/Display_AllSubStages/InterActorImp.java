package com.Alatheer.alatheer.schooles.MVP.Display_AllSubStages;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.Alatheer.alatheer.schooles.Models.ModelStage;
import com.Alatheer.alatheer.schooles.Services.Service;
import com.Alatheer.alatheer.schooles.Services.ServicesApi;

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
    public void DisplayAll_SubStages(String id_school,String id,String type,final onCompleteListener listener, final Context context) {

        Retrofit retrofit = ServicesApi.CreateApiClient();
        Service service = retrofit.create(Service.class);
        Call<List<ModelStage>> call = service.DisplayAll_SubStages("1");
        call.enqueue(new Callback<List<ModelStage>>() {
            @Override
            public void onResponse(Call<List<ModelStage>> call, Response<List<ModelStage>> response) {
                if (response.isSuccessful())
                {
                    List<ModelStage> schools_stages = response.body();
                    listener.OnDisplayDataSuccess(schools_stages);
                }else
                    {
                        listener.OnFailed("error something went haywire");
                    }
            }

            @Override
            public void onFailure(Call<List<ModelStage>> call, Throwable t) {
                listener.OnFailed("error check network connection ");
                Log.e("error",t.getMessage());
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
