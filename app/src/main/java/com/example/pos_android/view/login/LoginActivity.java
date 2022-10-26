package com.example.pos_android.view.login;

import android.content.Intent;
import android.os.Bundle;

import com.example.pos_android.contracts.LoginContracts;
import com.example.pos_android.databinding.ActivityLoginBinding;
import com.example.pos_android.presenter.LoginPresenter;
import com.example.pos_android.view.BaseActivity;
import com.example.pos_android.view.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements LoginContracts.View {
    private LoginPresenter presenter;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        getSupportActionBar().hide();

        presenter = new LoginPresenter(this);
        binding.tvSignup.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }


    @Override
    public void showProgressBar() {
        showLoadingDialog(this);
    }

    @Override
    public void hideProgressBar() {
        hideLoadingDialog();
    }

    @Override
    public void showApiErrorWarning(String string) {
        showToast(LoginActivity.this, string);
    }

    @Override
    public void showWarningMessage(String message) {
        showToast(LoginActivity.this, message);
    }

    @Override
    public void showSuccess(String message) {
        showToast(LoginActivity.this, message);
    }

    @Override
    public void showInputWarning() {

    }
}