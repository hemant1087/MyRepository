package com.hemant.musicappdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hemant on 5/3/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);

        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment tab = new TabFragment();

        return tab;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
