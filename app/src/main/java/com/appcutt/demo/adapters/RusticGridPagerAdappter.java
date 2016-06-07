package com.appcutt.demo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.CatsGridFragment;

import java.util.ArrayList;
import java.util.List;

public class RusticGridPagerAdappter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public RusticGridPagerAdappter(FragmentManager fm, Context context) {
        super(fm);
        titles = new ArrayList<>();
        titles.add(context.getString(R.string.r200x400));
        titles.add(context.getString(R.string.r300x300));
        titles.add(context.getString(R.string.r400x400));
        titles.add(context.getString(R.string.r600x600));

        fragments = new ArrayList<>();
        fragments.add(CatsGridFragment.newInstance("200x400"));
        fragments.add(CatsGridFragment.newInstance("300x300"));
        fragments.add(CatsGridFragment.newInstance("400x400"));
        fragments.add(CatsGridFragment.newInstance("600x600"));
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