package com.example.pos_android.Contracts;

public interface BaseView {
    void showProgressBar();
    void hideProgressBar();
    void showApiErrorWarning(String string);
    void showWarningMessage(String message);
}
