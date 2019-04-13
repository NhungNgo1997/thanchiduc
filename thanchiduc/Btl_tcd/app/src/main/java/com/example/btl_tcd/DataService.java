package com.example.btl_tcd;






import com.example.btl_tcd.model.ModelTT;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {
    @GET("list-cauhoi.php")
    Call<List<ModelTT>> GetAllData();

    @FormUrlEncoded
    @POST("insert-person.php")
    Call<String> InsertData(@Field("name") String name, @Field("phone") String phone);
}
