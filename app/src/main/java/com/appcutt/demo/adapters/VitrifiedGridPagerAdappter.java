package com.appcutt.demo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.CatsGridFragment;

import java.util.ArrayList;
import java.util.List;

public class VitrifiedGridPagerAdappter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public VitrifiedGridPagerAdappter(FragmentManager fm, Context context) {
        super(fm);
        titles = new ArrayList<>();
        titles.add(context.getString(R.string.v28x30cm));
        titles.add(context.getString(R.string.v28x60cm));
        titles.add(context.getString(R.string.v30x30cm));
        titles.add(context.getString(R.string.v40x40cm));
        titles.add(context.getString(R.string.v60x60cm));

        fragments = new ArrayList<>();
        fragments.add(CatsGridFragment.newInstance("28x30cm"));
        fragments.add(CatsGridFragment.newInstance("28x60cm"));
        fragments.add(CatsGridFragment.newInstance("30x30cm"));
        fragments.add(CatsGridFragment.newInstance("40x40cm"));
        fragments.add(CatsGridFragment.newInstance("60x60cm"));
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