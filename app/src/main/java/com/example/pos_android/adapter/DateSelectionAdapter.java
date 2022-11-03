package com.example.pos_android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_android.databinding.LayoutSelectDateBinding;

import java.util.List;

public class DateSelectionAdapter extends RecyclerView.Adapter<DateSelectionAdapter.DateViewHolder> {
    List<String> stringList;

    public DateSelectionAdapter(List<String> date) {
        this.stringList = date;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DateViewHolder(LayoutSelectDateBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        holder.setData(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList != null ? stringList.size() : 0;
    }

    public class DateViewHolder extends RecyclerView.ViewHolder {
        private LayoutSelectDateBinding layoutSelectDateBinding;

        public DateViewHolder(LayoutSelectDateBinding itemView) {
            super(itemView.getRoot());
            this.layoutSelectDateBinding = itemView;
        }

        void setData(String date) {
            String[] str = date.split("-", 0);
            layoutSelectDateBinding.tvDate.setText(str[0]);
            layoutSelectDateBinding.tvMonth.setText(str[1]);
        }
    }
}


