package com.example.pos_android.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pos_android.Contracts.LoginContracts;
import com.example.pos_android.R;

public class LoginActivity extends AppCompatActivity implements LoginContracts.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        getSupportActionBar().hide();
    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showApiErrorWarning(String string) {

    }

    @Override
    public void showWarningMessage(String message) {

    }

    @Override
    public void showSuccess(String message) {

    }

    @Override
    public void showInputWarning() {

    }
}