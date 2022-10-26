package com.example.pos_android.network.api_manager;

import android.util.Log;

import com.example.pos_android.data.model.LoginResponse;
import com.example.pos_android.presenter.LoginPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApiDataManager {
    private final String TAG = "OnNetworkResponse";
    ApiInterFace apiInterFace;

    public void LoginUser(String userName, String password, LoginPresenter mPresenter) {
        try {
            if (apiInterFace == null)
                apiInterFace = ApiClient.getClientServerApi().create(ApiInterFace.class);

            apiInterFace
                    .LoginUser(userName, password)
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
}