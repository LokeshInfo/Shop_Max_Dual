package com.icss.shopmax.API_Retro;

import com.icss.shopmax.A_Model.Doc_Book_Model;
import com.icss.shopmax.A_Model.Doctor_Model;
import com.icss.shopmax.A_Model.Hospital_Model;
import com.icss.shopmax.A_Model.Login_Data;
import com.icss.shopmax.A_Model.Login_Model;
import com.icss.shopmax.A_Model.Login_mmodel;
import com.icss.shopmax.A_Model.Register_Data;
import com.icss.shopmax.A_Model.Sale_Model;
import com.icss.shopmax.A_Model.Sale_Sub_Model;
import com.icss.shopmax.A_Model.Services_Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_Para {

    @GET(BaseUrl.get_services)
    Call<Services_Model> Get_Services();

    @FormUrlEncoded
    @POST(BaseUrl.login)
    Call<Login_mmodel> CALL_LOGIN(
       @Field("email") String mobile_email,
       @Field("password") String password
    );

    @FormUrlEncoded
    @POST(BaseUrl.registration)
    Call<Login_mmodel> CALL_REGISTER(
            @Field("username") String mobile_email,
            @Field("surname") String surname,
            @Field("email") String email,
            @Field("phone") String mobile,
            @Field("password1") String password,
            @Field("password2") String password1
    );

    @GET(BaseUrl.sale_category)
    Call<Sale_Model> CALL_SALE();

    @FormUrlEncoded
    @POST(BaseUrl.sale_subcategory)
    Call<Sale_Sub_Model> CALL_SUB_SALE(
      @Field("cat_id") String cat_id
    );


    // Hospitals

    @GET(BaseUrl.get_hospitals)
    Call<Hospital_Model> Get_Hospitals();

    @FormUrlEncoded
    @POST(BaseUrl.get_doctors)
    Call<Doctor_Model> Get_Doctors(
            @Field("hospital_id")String doc_id
            );

    @FormUrlEncoded
    @POST(BaseUrl.book_doctor_appointment)
    Call<Doc_Book_Model> Book_Doctor(
            @Field("user_id") String user_id,
            @Field("hospital_id") String hospital_id,
            @Field("doctor_id") String doctor_id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile_no") String mobile_no,
            @Field("gender") String gender,
            @Field("age") String age,
            @Field("request") String request,
            @Field("payment_status") String payment_status,
            @Field("pay_amount") String pay_amount,
            @Field("payment_id") String payment_id
            );



}
