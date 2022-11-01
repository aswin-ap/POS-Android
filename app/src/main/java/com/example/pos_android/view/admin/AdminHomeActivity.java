package com.example.pos_android.view.admin;

import android.os.Bundle;
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
        initData();


    }

    private void initData() {

    }
}