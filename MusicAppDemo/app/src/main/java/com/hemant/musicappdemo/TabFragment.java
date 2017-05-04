package com.hemant.musicappdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemant on 5/3/2017.
 */

public class TabFragment extends Fragment {

    RecyclerView recyclerView;
    List<String> titleList;
    List<String> hoursList;
    List<Bitmap> bitmapList;

    int[] image = {R.drawable.chain_smoker, R.drawable.emptiness, R.drawable.i_am_falling, R.drawable.baby, R.drawable.taylor};
    String[] textArray;

    String[] textArrayDetails;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_pager_layout_two,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        textArray = getContext().getResources().getStringArray(R.array.slider_title_array);
        textArrayDetails = getContext().getResources().getStringArray(R.array.hours_array);
        bitmapList = new ArrayList<>();
        titleList = new ArrayList<>();
        hoursList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), image[i]);
            bitmapList.add(imageBitmap);
        }

        // adding items to test title list
        for (int j = 0; j < textArray.length; j++) {

            String text = textArray[j];
            titleList.add(text);
        }

        // adding items to detailed text list
        for (int k = 0; k < textArrayDetails.length; k++) {

            String text = textArrayDetails[k];
            hoursList.add(text);
        }

        recyclerView.setAdapter(new RecyclerViewAdapter(getContext(),titleList,hoursList,bitmapList));
        return view;
    }
}
