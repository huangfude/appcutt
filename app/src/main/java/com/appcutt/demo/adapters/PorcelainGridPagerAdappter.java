package com.appcutt.demo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.CatsGridFragment;

import java.util.ArrayList;
import java.util.List;

public class PorcelainGridPagerAdappter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public PorcelainGridPagerAdappter(FragmentManager fm, Context context) {
        super(fm);
        titles = new ArrayList<>();
        titles.add(context.getString(R.string.doubleloading));
        titles.add(context.getString(R.string.pilates));
        titles.add(context.getString(R.string.solublesalt));

        fragments = new ArrayList<>();
        fragments.add(CatsGridFragment.newInstance("doubleloading"));
        fragments.add(CatsGridFragment.newInstance("pilates"));
        fragments.add(CatsGridFragment.newInstance("solublesalt"));
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