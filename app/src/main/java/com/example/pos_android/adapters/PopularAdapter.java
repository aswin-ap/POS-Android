package com.example.pos_android.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pos_android.R;
import com.example.pos_android.data.model.PopularModel;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    // ... ViewHolder class and its constructor as per above


    ArrayList<PopularModel> list;

    // Constructor
    public PopularAdapter(ArrayList<PopularModel> list){
        this.list = list;
    }

    // Creating a viewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout
        View contactView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_popular_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    // Assigning respective data for the views based on the position of the current item
    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        // Get the Subject based on the current position
        PopularModel currentItem = list.get(position);

        // Setting views with the corresponding data
        ImageView imageView = holder.subjectImageView;
        imageView.setImageResource(currentItem.getImageId());

        TextView subjectTextView = holder.subjectTextView;
        subjectTextView.setText(currentItem.getName());

        TextView likesTextView = holder.numOfLikesTextView;
        likesTextView.setText(currentItem.getdiscription());
    }

    // Indicating how long your data is
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView subjectImageView;
        public TextView subjectTextView;
        public TextView numOfLikesTextView;

        // Constructor - accepts entire row item
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find each view by id you set up in the list_item.xml
            subjectImageView = itemView.findViewById(R.id.subject_image_view);
            subjectTextView = itemView.findViewById(R.id.subject_text_view);
            numOfLikesTextView = itemView.findViewById(R.id.likes_text_view);
        }
    }
}
