package com.example.pos_android.view.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pos_android.R;
import com.example.pos_android.adapter.DateSelectionAdapter;
import com.example.pos_android.adapter.TableAdapter;
import com.example.pos_android.adapter.TimeSelectionAdapter;
import com.example.pos_android.data.model.TableModel;
import com.example.pos_android.databinding.FragmentReservationBinding;
import com.example.pos_android.listeners.TableClickListener;

import java.util.ArrayList;
import java.util.List;

public class TableReservationFragment extends Fragment implements TableClickListener {
    private FragmentReservationBinding binding;
    private List<String> dateList = new ArrayList<>();
    private List<String> timeList = new ArrayList<>();
    private ArrayList<TableModel> tableList = new ArrayList<>();
    private DateSelectionAdapter dateSelectionAdapter;
    private TimeSelectionAdapter timeSelectionAdapter;
    private TableAdapter tableAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReservationBinding.inflate(getLayoutInflater(), container, false);
        initView();
        btnClick();
        return binding.getRoot();
    }

    private void btnClick() {
        binding.ivBack.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).popBackStack();
        });
        binding.countLayout.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(binding.countLayout.tvGuest.getText().toString());
                if(count > 23){
                    Toast.makeText(requireContext(),"Sorry Customer,You are out of our capacity",Toast.LENGTH_LONG).show();
                }
                else{
                String num = String.valueOf(count + 1);
                binding.countLayout.tvGuest.setText( num);
            }}
        });
        binding.countLayout.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(binding.countLayout.tvGuest.getText().toString());
                if(count > 0){
                String num = String.valueOf(count - 1);
                binding.countLayout.tvGuest.setText( num);
            }
                int totalPeople = Integer.parseInt(binding.countLayout.tvGuest.getText().toString());
                if( totalPeople == 0 ){
                    for (int i = 1; i <= tableList.size(); i++){
                        tableList.get(i-1).setSelected(false);
                    }
                    tableAdapter.notifyDataSetChanged();
                }
                else if(totalPeople < 5 ){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                            if(clicked == 2){
                                tableList.get(i-1).setSelected(false);
                                tableAdapter.notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                }
                else if(totalPeople < 9 ){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                            if(clicked == 3){
                                tableList.get(i-1).setSelected(false);
                                tableAdapter.notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                }
                else if(totalPeople < 13 ){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                            if(clicked == 4){
                                tableList.get(i-1).setSelected(false);
                                tableAdapter.notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                }
                else if(totalPeople < 17){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                            if(clicked == 5){
                                tableList.get(i-1).setSelected(false);
                                tableAdapter.notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                }
                else if(totalPeople < 21){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                            if(clicked == 6){
                                tableList.get(i-1).setSelected(false);
                                tableAdapter.notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                }
            }
        });
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

        binding.btnContinue.setOnClickListener(v -> {

        });
        tableList.add(new TableModel("Table1", R.drawable.t4, 1, "Table1",false));
        tableList.add(new TableModel("Table2", R.drawable.t4, 2, "Table2",false));
        tableList.add(new TableModel("Table3", R.drawable.t4, 3, "Table3",false));
        tableList.add(new TableModel("Table4", R.drawable.t4, 4, "Table4",false));
        tableList.add(new TableModel("Table5", R.drawable.t4, 5, "Table5",false));
        tableList.add(new TableModel("Table6", R.drawable.t4, 6, "Table6",false));

        tableAdapter = new TableAdapter(tableList,this);
        binding.rvTable.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        binding.rvTable.setHasFixedSize(true);
        binding.rvTable.setAdapter(tableAdapter);

    }

    @Override
    public void onItemClick(int position, TableModel data) {

        int count = Integer.parseInt(binding.countLayout.tvGuest.getText().toString());
        if(count <= 0 ){
            Toast.makeText(requireContext(),"Please Select Guests Count",Toast.LENGTH_LONG).show();
        }else{
            if(tableList.get(position).getSelected()) {
                tableList.get(position).setSelected(false);
            }else {

                if(count <= 4 ){
                        for (int i = 1; i <= tableList.size(); i++){
                            tableList.get(i-1).setSelected(false);
                        }
                    tableList.get(position).setSelected(true);
                        tableAdapter.notifyDataSetChanged();

                }
                else if(count > 4 && count <= 8){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                       if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                        }
                    }
                    if(clicked > 1){
                        Toast.makeText(requireContext(),"You Can Select only two table,Please Unselect one table",Toast.LENGTH_LONG).show();

                    }
                    else{
                        tableList.get(position).setSelected(true);
                    }
                }
                else if(count > 8 && count <= 12){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                        }
                    }
                    if(clicked > 2){
                        Toast.makeText(requireContext(),"You Can Select only three table,Please Unselect one table",Toast.LENGTH_LONG).show();

                    }
                    else{
                        tableList.get(position).setSelected(true);
                    }
                }
                else if(count > 12 && count <= 16){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                        }
                    }
                    if(clicked > 3){
                        Toast.makeText(requireContext(),"You Can Select only four table,Please Unselect one table",Toast.LENGTH_LONG).show();

                    }
                    else{
                        tableList.get(position).setSelected(true);
                    }
                }
                else if(count > 16 && count <= 20){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                        }
                    }
                    if(clicked > 4){
                        Toast.makeText(requireContext(),"You Can Select only Five table,Please Unselect one table",Toast.LENGTH_LONG).show();

                    }
                    else{
                        tableList.get(position).setSelected(true);
                    }
                }
                else if(count > 20 && count <= 24){
                    int clicked = 0;
                    for (int i = 1; i <= tableList.size(); i++){
                        if( tableList.get(i-1).getSelected()){
                            clicked = clicked+1;
                        }
                    }
                    if(clicked > 5){
                        Toast.makeText(requireContext(),"You Can Select only Six table,Please Unselect one table",Toast.LENGTH_LONG).show();

                    }
                    else{
                        tableList.get(position).setSelected(true);
                    }
                }
            }
            tableAdapter.notifyDataSetChanged();
        }

    }
}