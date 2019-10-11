package com.example.globaltest.CustomAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.globaltest.Data.ImageUrl;
import com.example.globaltest.Fragments;
import com.example.globaltest.Gallery;
import com.example.globaltest.R;
import java.util.ArrayList;

public class MyCustomAdapterImage extends RecyclerView.Adapter<MyCustomAdapterImage.ViewHolder> {
    private ArrayList<ImageUrl> imageUrls;
    private Context context;
    public Boolean isImageScaled = false;

    public MyCustomAdapterImage(Context context, ArrayList<ImageUrl> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;

    }

    @Override
    public MyCustomAdapterImage.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     * gets the image url from adapter and passes to Glide API to load the image
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Glide.with(context).load(imageUrls.get(i).getImageUrl()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.imageView);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });
        }
    }
}