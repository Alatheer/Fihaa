package com.Alatheer.alatheer.schoole.Services;

import com.Alatheer.alatheer.schoole.Models.AbsenceModel;
import com.Alatheer.alatheer.schoole.Models.AllActivities_Model;
import com.Alatheer.alatheer.schoole.Models.AllSchoolModel;
import com.Alatheer.alatheer.schoole.Models.AllStagesModel;
import com.Alatheer.alatheer.schoole.Models.CheckRegister;
import com.Alatheer.alatheer.schoole.Models.ChildrenModel;
import com.Alatheer.alatheer.schoole.Models.HomeWorkModel;
import com.Alatheer.alatheer.schoole.Models.HonerModel;
import com.Alatheer.alatheer.schoole.Models.LoginModel;
import com.Alatheer.alatheer.schoole.Models.ModelStage;
import com.Alatheer.alatheer.schoole.Models.ModelStage_Parent;
import com.Alatheer.alatheer.schoole.Models.NationalityModel;
import com.Alatheer.alatheer.schoole.Models.News_Model;
import com.Alatheer.alatheer.schoole.Models.ParentLoginModel;
import com.Alatheer.alatheer.schoole.Models.ResponseModel;
import com.Alatheer.alatheer.schoole.Models.School_Fees_Model;
import com.Alatheer.alatheer.schoole.Models.Stud_ClassModel;
import com.Alatheer.alatheer.schoole.Models.Student_Fees_Model;
import com.Alatheer.alatheer.schoole.Models.Student_State_Model;
import com.Alatheer.alatheer.schoole.Models.SubClasses;
import com.Alatheer.alatheer.schoole.Models.TimeTableStudentModel;

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

    /*@GET("Api/SchoolStages/{id_school}")
    Call<School_Stages1> DisplayAll_SubStages(@Path( "id_school") String id_school);
*/
    //----------------------------Student_Stages-------------------------------------//
    @GET("Api/StudentStages/{student_code}")
    Call<List<ModelStage>> DisplayAll_SubStages(@Path( "student_code") String student_code );

    //----------------------------Parent_Stages-------------------------------------//

    @GET("Api/ParentStages/{father_national_num}")
    Call<List<ModelStage_Parent>> DisplayAll_Parent_SubStages(@Path("father_national_num") String father_national_num );

    //----------------------------Student_class-------------------------------------//

    @GET("Api/StudentClassRoom/{stud_id}")
    Call<List<Stud_ClassModel>> DisplayAll_Student_class(@Path("stud_id") String stud_id );


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

    @GET("Api/StudentSchoolDetials/{student_code}")
    Call<List<School_Fees_Model>> GetStudentSchoolData(@Path( "student_code") String student_code);

    @GET("Api/FatherSchoolDetials/{father_national_num}")
    Call<List<School_Fees_Model>> GetFatherSchoolDetials(@Path( "father_national_num") String father_national_num);

    @GET("Api/OnRegestration")
    Call<CheckRegister> checkRegistration();

    @GET("Api/AllStages")
    Call<List<AllStagesModel>> getStagesForRegister();

    @GET("Api/AllNationality")
    Call<List<NationalityModel>> getNationality();
    @FormUrlEncoded
    @POST("Api/Regestration")
    Call<ResponseModel> Register(@Field("student_name") String student_name,
                                 @Field("student_gender") String student_gender,
                                 @Field("main_stage_id_fk") String main_stage_id_fk,
                                 @Field("nationality_id_fk") String nationality_id_fk,
                                 @Field("national_id_num") String national_id_num,
                                 @Field("student_phone") String student_phone
                                 );
}
