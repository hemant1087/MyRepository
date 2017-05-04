package com.hemant.musicappdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemant on 5/3/2017.
 */

public class DashBoardFragment extends Fragment {

    ViewPager viewPagerImage;
    ViewPager viewPagerSecond;
    int currentPage;
    Handler handler = new Handler();
    List<Bitmap> bitmapList;
    List<String> titleList;
    List<String> detailTextList;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    ImageAdapter mAdapter;
    TabLayout tabLayout;

    int[] image = {R.drawable.chain_smoker, R.drawable.emptiness, R.drawable.i_am_falling, R.drawable.baby, R.drawable.taylor};
    String[] textArray;

    String[] textArrayDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);

        textArray = getContext().getResources().getStringArray(R.array.slider_title_array);
        textArrayDetails = getContext().getResources().getStringArray(R.array.slider_details_text_array);


        bitmapList = new ArrayList<>();
        titleList = new ArrayList<>();
        detailTextList = new ArrayList<>();

        viewPagerImage = (ViewPager) view.findViewById(R.id.view_pager_image);
        pager_indicator = (LinearLayout) view.findViewById(R.id.viewpagerCountDots);
        currentPage = viewPagerImage.getCurrentItem();

        for (int i = 0; i < image.length; i++) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize  = 2;
            Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), image[i],options);
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
            detailTextList.add(text);
        }

        mAdapter = new ImageAdapter(getContext(), bitmapList, titleList, detailTextList);
        viewPagerImage.setAdapter(mAdapter);
        viewPagerImage.setCurrentItem(0);
        viewPagerImage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
                }

                dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
         setUiPageViewController();

        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("VIDEOS").setIcon(R.drawable.select_video));
        tabLayout.addTab(tabLayout.newTab().setText("IMAGES").setIcon(R.drawable.image));
        tabLayout.addTab(tabLayout.newTab().setText("MILESTONE").setIcon(R.drawable.milestone));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPagerSecond = (ViewPager)view.findViewById(R.id.view_pager_two);
        PagerAdapter adapter = new com.hemant.musicappdemo.PagerAdapter(((AppCompatActivity)getContext()).getSupportFragmentManager(),3);

        viewPagerSecond.setCurrentItem(0);
        viewPagerSecond.setAdapter(adapter);

        viewPagerSecond.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                try {
                    viewPagerSecond.setCurrentItem(tab.getPosition());
                    if(tab.getPosition() == 0){
                        tab.setIcon(R.drawable.select_video);
                    }
                    else if(tab.getPosition() == 1){
                        tab.setIcon(R.drawable.select_image);
                    }
                    else {
                        tab.setIcon(R.drawable.select_milestone);
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    tab.setIcon(R.drawable.video);


                }
                else if(tab.getPosition() == 1){
                    tab.setIcon(R.drawable.image);
                }
                else {
                    tab.setIcon(R.drawable.milestone);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private void setUiPageViewController() {
        dotsCount = bitmapList.size();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
            dots[i].setPadding(5, 5, 5, 5);
            pager_indicator.addView(dots[i]);
            if (i == 0) {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            }
        }
    }





}
