package com.example.pos_android.presenter;

import android.content.Context;

import com.example.pos_android.Contracts.LoginContracts;
import com.example.pos_android.R;
import com.example.pos_android.data.LoginResponse;
import com.example.pos_android.network.api_manager.ApiDataManager;
import com.example.pos_android.utils.NetworkManager;

public class LoginPresenter implements LoginContracts.Presenter {

    LoginContracts.View mView;
    ApiDataManager mApiDataManager;
    Context mContext;
    @Override
    public void onApiError(String data) {

    }

    @Override
    public void CallLOGIN(String user, String password) {
        if (NetworkManager.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
            mApiDataManager.LoginUser(user,password,this);
        } else mView.showWarningMessage(mContext.getResources().getString(R.string.no_network));
    }

    @Override
    public void onApiResponse(LoginResponse saveResponse) {

    }
}
