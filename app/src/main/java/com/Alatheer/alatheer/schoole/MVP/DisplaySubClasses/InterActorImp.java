package com.Alatheer.alatheer.schoole.MVP.DisplaySubClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.Alatheer.alatheer.schoole.Models.Stud_ClassModel;
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
    public void DisplayAllSubClasses(String stud_id,final onCompleteListener listener, final Context context) {

        Retrofit retrofit = ServicesApi.CreateApiClient();
        Service service = retrofit.create(Service.class);
        Call<List<Stud_ClassModel>> call = service.DisplayAll_Student_class(stud_id);
        call.enqueue(new Callback<List<Stud_ClassModel>>() {
            @Override
            public void onResponse(Call<List<Stud_ClassModel>> call, Response<List<Stud_ClassModel>> response) {
                if (response.isSuccessful())
                {

                    List <Stud_ClassModel> subClassesList = response.body();
                    listener.OnDisplayDataSuccess(subClassesList);
                }else
                    {
                        listener.OnFailed("error something went haywire");
                    }
            }

            @Override
            public void onFailure(Call<List<Stud_ClassModel>> call, Throwable t) {
                listener.OnFailed("error check network connection ");
                Log.e("error",t.getMessage());
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
