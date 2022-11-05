package com.example.pos_android.view.login;

import android.content.Intent;
import android.os.Bundle;

import com.example.pos_android.contracts.LoginContract;
import com.example.pos_android.data.preference.SessionManager;
import com.example.pos_android.databinding.ActivityLoginBinding;
import com.example.pos_android.presenter.LoginPresenter;
import com.example.pos_android.utils.Validation;
import com.example.pos_android.view.BaseActivity;
import com.example.pos_android.view.admin.AdminHomeActivity;
import com.example.pos_android.view.register.RegisterActivity;
import com.example.pos_android.view.user.UserHomeActivity;

import java.util.Objects;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private LoginPresenter presenter;
    private ActivityLoginBinding binding;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        // getSupportActionBar().hide();

        presenter = new LoginPresenter(this, this);
        sessionManager = new SessionManager(this);
        binding.tvSignup.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
        binding.buttonLogin.setOnClickListener(v -> {
            validateFields();
        });
    }

    private void validateFields() {
        if (!Validation.isNotNullOrEmpty(Objects.requireNonNull(binding.txtEmail.getText()).toString())) {
            binding.emailLayout.setError("Please enter valid username");
        } else if (!Validation.isNotNullOrEmpty(binding.txtPass.getText().toString())) {
            binding.passwordLayout.setError("Please enter valid password");
            binding.emailLayout.setError(null);
        } else {
            binding.passwordLayout.setError(null);

            presenter.callLogin(binding.txtEmail.getText().toString().trim(),
                    binding.txtPass.getText().toString().trim());
        }
//        if (!Validation.isValidEmail(Objects.requireNonNull(binding.txtEmail.getText()).toString())) {
//            binding.emailLayout.setError("Please enter valid email");
//        } else if (!Validation.isNotNullOrEmpty(binding.txtPass.getText().toString())) {
//            binding.passwordLayout.setError("Please enter valid password");
//            binding.emailLayout.setError(null);
//        } else {
//            binding.passwordLayout.setError(null);
//
//            presenter.callLogin(binding.txtEmail.getText().toString().trim(),
//                    binding.txtPass.getText().toString().trim());
//        }
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
        showSnackBar(binding.getRoot(), string);
    }

    @Override
    public void showWarningMessage(String message) {
        showToast(LoginActivity.this, message);
    }

    @Override
    public void showSuccess(String message) {
        showToast(LoginActivity.this, message);
        sessionManager.setLogin(true);
        startActivity(new Intent(LoginActivity.this, UserHomeActivity.class));
        finishAffinity();
    }

    @Override
    public void showInputWarning() {

    }
}