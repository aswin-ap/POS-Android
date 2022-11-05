package com.example.pos_android.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pos_android.R;
import com.example.pos_android.data.model.TableModel;
import com.example.pos_android.listeners.TableClickListener;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    ArrayList<TableModel> list;
    public TableClickListener clickListener;
    // Constructor
    public TableAdapter(ArrayList<TableModel> list,TableClickListener clickListener) {
        this.list = list;
        this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout
        View contactView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_layout, parent, false);

        // Return a new holder instance
        TableAdapter.ViewHolder viewHolder = new TableAdapter.ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        TableModel currentItem = list.get(position);
        holder.viewLay.setBackgroundColor(currentItem.getSelected() ? Color.CYAN : Color.TRANSPARENT);

        ImageView imageView = holder.subjectImageView;
        imageView.setImageResource(currentItem.getImageId());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(position,currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView subjectImageView;
        public View viewLay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectImageView = itemView.findViewById(R.id.tbi4);
            viewLay =  itemView.findViewById(R.id.view_lay);
        }
    }
}
