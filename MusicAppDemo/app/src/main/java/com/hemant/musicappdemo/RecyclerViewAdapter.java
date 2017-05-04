package com.hemant.musicappdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hemant on 5/3/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<String> titleList;
    List<String> hourList;
    List<Bitmap> imageList;
    LayoutInflater inflater;
    Context context;
    public RecyclerViewAdapter(Context context, List<String> titleList, List<String> hourList, List<Bitmap> imageList ){
        this.context = context;
        this.titleList = titleList;
        this.hourList = hourList;
         this.imageList = imageList;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.card_view_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imageView.setImageBitmap(imageList.get(position));
        holder.title.setText(titleList.get(position).toUpperCase());
        holder.hours.setText(hourList.get(position));

    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView hours;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.card_image_view);
             title = (TextView)itemView.findViewById(R.id.card_title);
             hours = (TextView)itemView.findViewById(R.id.music_time_text_view);
        }
    }
}
