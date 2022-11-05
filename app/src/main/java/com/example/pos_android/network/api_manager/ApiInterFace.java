package com.example.pos_android.network.api_manager;

import com.example.pos_android.data.model.CommonResponse;
import com.example.pos_android.data.model.ImagePickerResponse;
import com.example.pos_android.data.model.LoginResponse;
import com.example.pos_android.data.model.RegisterResponse;
import com.example.pos_android.data.model.UserHomeResponse;
import com.example.pos_android.data.model.request.AddFoodRequestData;
import com.example.pos_android.data.model.request.LoginRequestData;
import com.example.pos_android.data.model.request.RegisterRequestData;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterFace {

    @POST("register")
    Observable<RegisterResponse> registerUser(
            @Body RegisterRequestData requestData);

    @POST("login")
    Observable<LoginResponse> login(
            @Body LoginRequestData requestData);

    @Multipart
    @POST("upload-file")
    Observable<ImagePickerResponse> getImageUrl(
            @Header("Authorization") String string,
            @Part MultipartBody.Part imageFile);

    @POST("add-menu")
    Observable<CommonResponse> updateFood(
            @Header("Authorization") String string,
            @Body AddFoodRequestData requestData);

    @GET("user-home")
    Observable<UserHomeResponse> userHomeDetails(
            @Header("Authorization") String string
    );

//    @GET("https://maps.googleapis.com/maps/api/distancematrix/json")
//    Call<Notification> getLocationAddress(
//            @Header("Authorization") String token,
//            @Query("origins") String LatLono);

}
