package com.example.pos_android.network.api_manager;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.pos_android.data.LoginResponse;
import com.example.pos_android.presenter.LoginPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiDataManager {
    ApiInterFace apiInterface;
    Retrofit mRetrofit_base;

    public void LoginUser(String usrname, String pasword, LoginPresenter mPresenter) {
        try {
            apiInterface = mRetrofit_base.create(ApiInterFace.class);

            Log.e("loginnn", "usrname:  " + usrname);
            Log.e("loginnn", "pasword:  " + pasword);


            Call<LoginResponse> call = apiInterface.LoginUser(usrname, pasword);


            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    try {
                        mPresenter.onApiResponse(response.body());
                    } catch (Exception e) {
                        mPresenter.onApiError("datafailures");
                        e.printStackTrace();
                        Log.e("loginnn", "" + e.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    try {
                        mPresenter.onApiError("datafailures");
                        t.getMessage();
                    } catch (NullPointerException ee) {
                        ee.printStackTrace();
                        Log.e("loginnn", "" + ee.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("loginnn", "" + e.getMessage());
                    }
                }

            });

        }catch (Exception e){
            Log.e("loginnn", "failur:  " + usrname+","+pasword);
            e.printStackTrace();
        }
    }
}