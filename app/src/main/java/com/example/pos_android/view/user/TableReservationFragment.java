package com.example.pos_android.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pos_android.adapter.DateSelectionAdapter;
import com.example.pos_android.adapter.TimeSelectionAdapter;
import com.example.pos_android.databinding.FragmentReservationBinding;

import java.util.ArrayList;
import java.util.List;

public class TableReservationFragment extends Fragment {
    private FragmentReservationBinding binding;
    private List<String> dateList = new ArrayList<>();
    private List<String> timeList = new ArrayList<>();
    private DateSelectionAdapter dateSelectionAdapter;
    private TimeSelectionAdapter timeSelectionAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReservationBinding.inflate(getLayoutInflater(), container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        dateList.add("3-NOV");
        dateList.add("4-NOV");
        dateList.add("5-NOV");
        dateList.add("6-NOV");
        dateList.add("7-NOV");
        dateList.add("8-NOV");
        dateList.add("9-NOV");

        timeList.add("10.00 AM");
        timeList.add("11.00 AM");
        timeList.add("12.00 AM");
        timeList.add("1.00 PM");
        timeList.add("2.00 PM");
        timeList.add("3.00 PM");


        dateSelectionAdapter = new DateSelectionAdapter(dateList);
        binding.rvDate.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvDate.setHasFixedSize(true);
        binding.rvDate.setAdapter(dateSelectionAdapter);

        timeSelectionAdapter = new TimeSelectionAdapter(timeList);
        binding.rvTime.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        binding.rvTime.setHasFixedSize(true);
        binding.rvTime.setAdapter(timeSelectionAdapter);


    }
}