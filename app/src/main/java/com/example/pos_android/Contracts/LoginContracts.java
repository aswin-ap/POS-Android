package com.example.pos_android.Contracts;

import com.example.pos_android.data.LoginResponse;

public interface LoginContracts {
    interface View extends BaseView {

        void showSuccess(String message);
        void showInputWarning();


    }

    interface Presenter extends BasePresenter {
        void CallLOGIN(String user , String password);
        void onApiResponse(LoginResponse saveResponse);


    }
}
