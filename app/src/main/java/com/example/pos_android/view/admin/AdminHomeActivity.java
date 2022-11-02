package com.example.pos_android.view.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pos_android.databinding.ActivityAdminHomeBinding;
import com.example.pos_android.view.BaseActivity;

import java.util.ArrayList;

public class AdminHomeActivity extends BaseActivity {

    private ActivityAdminHomeBinding binding;
//     List<SlideModel> slideModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUi();
        btnClick();


    }

    private void initUi() {

    }
    private void btnClick() {
        binding.addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddFoodActivity.class));
            }
        });

    }
}