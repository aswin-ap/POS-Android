package com.example.pos_android.view.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pos_android.R;
import com.example.pos_android.adapter.admin.HomeItemAdapter;
import com.example.pos_android.data.model.AdminHomeModel;
import com.example.pos_android.data.model.PopularModel;
import com.example.pos_android.databinding.ActivityAdminHomeBinding;
import com.example.pos_android.view.BaseActivity;

import java.util.ArrayList;

public class AdminHomeActivity extends BaseActivity {

    private ActivityAdminHomeBinding binding;
//     List<SlideModel> slideModels = new ArrayList<>();
    ArrayList<AdminHomeModel> adminHomeArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();


    }

    private void initData() {
        adminHomeArrayList.add(new AdminHomeModel("Add Food", R.drawable.fast_food, "To Add Food Click here"));
        adminHomeArrayList.add(new AdminHomeModel("Add Table", R.drawable.dinner, "To Add Table Click here"));
        adminHomeArrayList.add(new AdminHomeModel("Profile", R.drawable.man, "Click to View Profile"));
        HomeItemAdapter homeItemAdapter = new HomeItemAdapter(adminHomeArrayList);
        RecyclerView recyclerOptions = findViewById(R.id.recyclerOptions);
        recyclerOptions.setAdapter(homeItemAdapter);
    }
}