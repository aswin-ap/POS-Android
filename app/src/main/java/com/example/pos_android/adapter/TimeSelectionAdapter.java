package com.example.pos_android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_android.databinding.LayoutSelectTimeBinding;

import java.util.List;

public class TimeSelectionAdapter extends RecyclerView.Adapter<TimeSelectionAdapter.TimeViewHolder> {
    List<String> stringList;

    public TimeSelectionAdapter(List<String> date) {
        this.stringList = date;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeViewHolder(LayoutSelectTimeBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
        holder.setData(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList != null ? stringList.size() : 0;
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {
        private LayoutSelectTimeBinding layoutSelectDateBinding;

        public TimeViewHolder(LayoutSelectTimeBinding itemView) {
            super(itemView.getRoot());
            this.layoutSelectDateBinding = itemView;
        }

        void setData(String time) {
            layoutSelectDateBinding.tvTime.setText(time);
        }
    }
}


