package com.icss.shopmax.API_Retro;

import com.icss.shopmax.A_Model.Doctor_Model;
import com.icss.shopmax.A_Model.Hospital_Model;
import com.icss.shopmax.A_Model.Login_Data;
import com.icss.shopmax.A_Model.Login_Model;
import com.icss.shopmax.A_Model.Register_Data;
import com.icss.shopmax.A_Model.Sale_Model;
import com.icss.shopmax.A_Model.Sale_Sub_Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_Para {

    @FormUrlEncoded
    @POST(BaseUrl.login)
    Call<Login_Model> CALL_LOGIN(
       @Field("mobile_email") String mobile_email,
       @Field("password") String password
    );

    @FormUrlEncoded
    @POST(BaseUrl.registration)
    Call<Register_Data> CALL_REGISTER(
            @Field("name") String mobile_email,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("password") String password,
            @Field("token_code") String t_code
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

}
