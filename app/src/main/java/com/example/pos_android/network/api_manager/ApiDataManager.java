package com.example.pos_android.network.api_manager;

import android.util.Log;

import com.example.pos_android.data.model.LoginResponse;
import com.example.pos_android.data.model.RegisterResponse;
import com.example.pos_android.data.model.request.LoginRequestData;
import com.example.pos_android.data.model.request.RegisterRequestData;
import com.example.pos_android.presenter.LoginPresenter;
import com.example.pos_android.presenter.RegisterPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApiDataManager {
    private final String TAG = "OnNetworkResponse";
    ApiInterFace apiInterFace;

    public void loginUser(LoginRequestData loginRequestData, LoginPresenter mPresenter) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .login(loginRequestData)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<LoginResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(LoginResponse loginResponse) {
                            mPresenter.onApiResponse(loginResponse);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            mPresenter.onApiError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            mPresenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }
    }

    public void registerUser(RegisterRequestData requestData, RegisterPresenter mPresenter) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .registerUser(requestData)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<RegisterResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }

                        @Override
                        public void onNext(RegisterResponse response) {
                            mPresenter.onApiResponse(response);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, "onError: " + e.getMessage());
                            // mPresenter.onApiError(e.getMessage());
                            mPresenter.onApiError("Sorry, This user already registered");
                        }

                        @Override
                        public void onComplete() {
                        }
                    });


        } catch (Exception e) {
            mPresenter.onApiError(e.getMessage());
            Log.e(TAG, "Exception caught in " + e.getMessage().toString());
        }
    }

}