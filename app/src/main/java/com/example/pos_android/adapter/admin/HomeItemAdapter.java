package com.example.pos_android.adapter.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pos_android.R;
import com.example.pos_android.data.model.AdminHomeModel;

import java.util.ArrayList;


public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.ViewHolder> {
    ArrayList<AdminHomeModel> list;

     // Constructor
    public HomeItemAdapter(ArrayList<AdminHomeModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public HomeItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         // Inflate the layout
        View contactView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout_options, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemAdapter.ViewHolder holder, int position) {
 // Get the Subject based on the current position
        AdminHomeModel currentItem = list.get(position);

        // Setting views with the corresponding data
        ImageView imageView = holder.subjectImageView;
        imageView.setImageResource(currentItem.getImageId());

        TextView subjectTextView = holder.subjectTextView;
        subjectTextView.setText(currentItem.getName());

        TextView likesTextView = holder.subjectSubText;
        likesTextView.setText(currentItem.getdiscription());
    }

    @Override
    public int getItemCount()  {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView subjectImageView;
        public TextView subjectTextView;
        public TextView subjectSubText;

        // Constructor - accepts entire row item
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find each view by id you set up in the list_item.xml
            subjectImageView = itemView.findViewById(R.id.img_product);
            subjectTextView = itemView.findViewById(R.id.txt_item_name);
            subjectSubText = itemView.findViewById(R.id.textView9);
        }
    }
}
