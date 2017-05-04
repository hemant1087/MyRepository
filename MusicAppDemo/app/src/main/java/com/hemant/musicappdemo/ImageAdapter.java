package com.hemant.musicappdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hemant on 5/3/2017.
 */

public class ImageAdapter extends PagerAdapter {

    Context context;
    List<Bitmap> modelList;
    List<String> stringList;
    List<String> detailTextList;
    public ImageAdapter(Context context,List<Bitmap> modelList,List<String> stringList,List<String> detailTextList ){

        this.context = context;
        this.modelList = modelList;
        this.stringList = stringList;
        this.detailTextList = detailTextList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.view_pager_layout_one, container,false);


        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        TextView textViewTitle = (TextView)itemView.findViewById(R.id.album_name_text);
        TextView textViewDetails = (TextView)itemView.findViewById(R.id.album_detail_text);


        try{
            imageView.setImageBitmap(modelList.get(position));

            textViewTitle.setText(stringList.get(position));
            textViewDetails.setText(detailTextList.get(position));
            container.addView(itemView);
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemView;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
