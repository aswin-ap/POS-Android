package com.example.pos_android.network.api_manager;

import com.example.pos_android.data.model.LoginResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterFace {
    String BASE_URL = "https://api.demo.com/api/full/";


    @FormUrlEncoded
    @POST("driver/login")
    Observable<LoginResponse> LoginUser(
            @Field("username") String username,
            @Field("password") String password);

/*    @FormUrlEncoded
    @POST("driver/notifications")
    Call<Notification> postNotificationDetails(
            @Header("Authorization") String token,
            @Field("offset") String offset,
            @Field("limit") String limit);



    @GET("https://maps.googleapis.com/maps/api/distancematrix/json")
    Call<Notification> getLocationAddress(
            @Header("Authorization") String token,
            @Query("origins") String LatLono);*/

}
