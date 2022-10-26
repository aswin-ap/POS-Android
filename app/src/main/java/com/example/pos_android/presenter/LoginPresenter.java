package com.example.pos_android.presenter;

import android.content.Context;

import com.example.pos_android.R;
import com.example.pos_android.contracts.LoginContracts;
import com.example.pos_android.data.model.LoginResponse;
import com.example.pos_android.network.api_manager.ApiDataManager;
import com.example.pos_android.utils.NetworkManager;

public class LoginPresenter implements LoginContracts.Presenter {

    LoginContracts.View mView;
    ApiDataManager mApiDataManager;
    Context mContext;

    public LoginPresenter(LoginContracts.View mView) {
        mApiDataManager = new ApiDataManager();
        this.mView = mView;
    }

    @Override
    public void onApiError(String data) {
        mView.hideProgressBar();
        mView.showApiErrorWarning(data);
    }

    @Override
    public void callLogin(String user, String password) {
        if (NetworkManager.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
            mApiDataManager.LoginUser(user, password, this);
        } else mView.showWarningMessage(mContext.getResources().getString(R.string.no_network));
    }

    @Override
    public void onApiResponse(LoginResponse saveResponse) {
        mView.hideProgressBar();
        if (saveResponse != null) {
            mView.showSuccess("Success");
        }
    }
}
