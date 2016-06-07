package com.appcutt.demo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.CatsGridFragment;

import java.util.ArrayList;
import java.util.List;

public class FullGridPagerAdappter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public FullGridPagerAdappter(FragmentManager fm, Context context) {
        super(fm);
        titles = new ArrayList<>();
        titles.add(context.getString(R.string.fulltile));

        fragments = new ArrayList<>();
        fragments.add(CatsGridFragment.newInstance("full"));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}