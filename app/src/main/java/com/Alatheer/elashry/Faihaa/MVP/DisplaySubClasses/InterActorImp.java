package com.Alatheer.elashry.Faihaa.MVP.DisplaySubClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.Alatheer.elashry.Faihaa.Models.SubClasses;
import com.Alatheer.elashry.Faihaa.Services.Service;
import com.Alatheer.elashry.Faihaa.Services.ServicesApi;

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
    public void DisplayAllSubClasses(String sub_stages_id, String id , String type,final onCompleteListener listener, final Context context) {

        Retrofit retrofit = ServicesApi.CreateApiClient();
        Service service = retrofit.create(Service.class);
        Call<List<SubClasses>> call = service.DisplayAll_SubClasses(sub_stages_id);
        call.enqueue(new Callback<List<SubClasses>>() {
            @Override
            public void onResponse(Call<List<SubClasses>> call, Response<List<SubClasses>> response) {
                if (response.isSuccessful())
                {

                    List <SubClasses> subClassesList = response.body();
                    listener.OnDisplayDataSuccess(subClassesList);
                }else
                    {
                        listener.OnFailed("error something went haywire");
                    }
            }

            @Override
            public void onFailure(Call<List<SubClasses>> call, Throwable t) {
                listener.OnFailed("error check network connection ");
                Log.e("error",t.getMessage());
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
