package com.Alatheer.elashry.Faihaa.Services;

import com.Alatheer.elashry.Faihaa.Models.AbsenceModel;
import com.Alatheer.elashry.Faihaa.Models.AllActivities_Model;
import com.Alatheer.elashry.Faihaa.Models.AllSchoolModel;
import com.Alatheer.elashry.Faihaa.Models.ChildrenModel;
import com.Alatheer.elashry.Faihaa.Models.HomeWorkModel;
import com.Alatheer.elashry.Faihaa.Models.HonerModel;
import com.Alatheer.elashry.Faihaa.Models.LoginModel;
import com.Alatheer.elashry.Faihaa.Models.News_Model;
import com.Alatheer.elashry.Faihaa.Models.ParentLoginModel;
import com.Alatheer.elashry.Faihaa.Models.School_Fees_Model;
import com.Alatheer.elashry.Faihaa.Models.School_Stages1;
import com.Alatheer.elashry.Faihaa.Models.Student_Fees_Model;
import com.Alatheer.elashry.Faihaa.Models.Student_State_Model;
import com.Alatheer.elashry.Faihaa.Models.SubClasses;
import com.Alatheer.elashry.Faihaa.Models.TimeTableStudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by elashry on 3/3/2018.
 */

public interface Service {

    ///////////////////////////////---------Display All Schools---------//////////////////
    @GET("Api/AllSchool")
    Call<List<AllSchoolModel>>DiaplayAll_Schools();

    ///////////////////////////////---------news Schools---------//////////////////

    @GET("Api/AllNews/{id_school}")
    Call<List<News_Model>> getNewsData(@Path( "id_school") String id_school);

    @GET("Api/HonorBoardStudent/{id_class_room}")
    Call<List<HonerModel>> HonorBoardStudent(@Path( "id_class_room") String id_class_room);

    @GET("Api/SchoolStages/{id_school}")
    Call<School_Stages1> DisplayAll_SubStages(@Path( "id_school") String id_school);

    @GET("Api/SchoolClassRoom/{sub_stages_id}")
    Call<List<SubClasses>> DisplayAll_SubClasses(@Path( "sub_stages_id") String sub_stages_id);

    @GET("Api/EvaluationStudent/{id_class_room}")
    Call<List<Student_State_Model>> EvaluationStudent(@Path( "id_class_room") String id_class_room);

    @GET("Api/AllActivities/{id_class_room}")
    Call<List<AllActivities_Model>> AllActivities(@Path( "id_class_room") String id_class_room);

    @GET("Api/OneSchoolActivities/{id_school}")
    Call<List<AllActivities_Model>> GetSchoolActivities(@Path( "id_school") String id_school);

    @FormUrlEncoded
    @POST("Api/Login")
    Call<LoginModel> Login(@Field("student_national_num") String student_national_num);

    @FormUrlEncoded
    @POST("Api/LoginParents")
    Call<ParentLoginModel> ParentLogin(@Field("father_national_num") String father_national_num);


    @GET("Api/SchoolFees/{id_school}")
    Call<List<School_Fees_Model>> GetSchoolFees(@Path( "id_school") String id_school);

    @GET("Api/OneStudentFees/{student_code}")
    Call<Student_Fees_Model> GetStudentFees(@Path( "student_code") String student_code);

    @GET("Api/ParentsStudentFees/{father_national_num}")
    Call<List<ChildrenModel>> DisplayChildrenDetails(@Path("father_national_num") String father_national_num);

    @GET("Api/AbsenceStudent/{id_class_room}")
    Call<List<AbsenceModel>> GetAbsenceStudent(@Path( "id_class_room") String id_class_room);

    @GET("Api/HomeworkStudent/{id_class_room}")
    Call<List<HomeWorkModel>> GetHomeworkStudent(@Path( "id_class_room") String id_class_room);

    @GET("Api/TimeTableStudent/{id_class_room}")
    Call<List<TimeTableStudentModel>> GetTimeTableStudent(@Path( "id_class_room") String id_class_room);

    @GET("Api/OneSchoolFees/{id_school}")
    Call<List<School_Fees_Model>> GetSchoolFeesData(@Path( "id_school") String id_school);

}
