package com.appcutt.demo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.CatsGridFragment;

import java.util.ArrayList;
import java.util.List;

public class CeramicGridPagerAdappter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public CeramicGridPagerAdappter(FragmentManager fm, Context context) {
        super(fm);
        titles = new ArrayList<>();
        titles.add(context.getString(R.string.c75x150));
        titles.add(context.getString(R.string.c100x100));
        titles.add(context.getString(R.string.c100x200));
        titles.add(context.getString(R.string.c100x300));
        titles.add(context.getString(R.string.c100x400));
        titles.add(context.getString(R.string.c150x150));
        titles.add(context.getString(R.string.c200x200));
        titles.add(context.getString(R.string.c200x300));
        titles.add(context.getString(R.string.c250x400));
        titles.add(context.getString(R.string.c300x300));
        titles.add(context.getString(R.string.c300x600));
        titles.add(context.getString(R.string.c400x400));
        titles.add(context.getString(R.string.c600x600));

        fragments = new ArrayList<>();
        fragments.add(CatsGridFragment.newInstance("75x150"));
        fragments.add(CatsGridFragment.newInstance("100x100"));
        fragments.add(CatsGridFragment.newInstance("100x200"));
        fragments.add(CatsGridFragment.newInstance("100x300"));
        fragments.add(CatsGridFragment.newInstance("100x400"));
        fragments.add(CatsGridFragment.newInstance("150x150"));
        fragments.add(CatsGridFragment.newInstance("200x200"));
        fragments.add(CatsGridFragment.newInstance("200x300"));
        fragments.add(CatsGridFragment.newInstance("250x400"));
        fragments.add(CatsGridFragment.newInstance("300x300"));
        fragments.add(CatsGridFragment.newInstance("300x600"));
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