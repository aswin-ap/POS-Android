package com.example.pos_android.network.api_manager;

import com.example.pos_android.data.model.LoginResponse;
import com.example.pos_android.data.model.RegisterResponse;
import com.example.pos_android.data.model.request.LoginRequestData;
import com.example.pos_android.data.model.request.RegisterRequestData;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterFace {

    @POST("register")
    Observable<RegisterResponse> registerUser(
            @Body RegisterRequestData requestData);

    @POST("login")
    Observable<LoginResponse> login(
            @Body LoginRequestData requestData);

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
