package com.appcutt.demo.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.CeramicFragment;
import com.appcutt.demo.fragment.ContactFragment;
import com.appcutt.demo.fragment.FullFragment;
import com.appcutt.demo.fragment.HomeFragment;
import com.appcutt.demo.fragment.PorcelainFragment;
import com.appcutt.demo.fragment.RusticFragment;
import com.appcutt.demo.fragment.VitrifiedFragment;
import com.appcutt.demo.fragment.SettingsFragment;
import com.appcutt.demo.utils.AppUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

    private Context mContext;

    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    private Fragment mFragment;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mContext = this;

        mFragmentManager = getSupportFragmentManager();
        mFragment = VitrifiedFragment.newInstance("main", "vitrified");

        FragmentTransaction fp = mFragmentManager.beginTransaction();
        fp.replace(R.id.content_frame, mFragment, "vitrified_tag");
        fp.commit();

        navigationView.setCheckedItem(R.id.nav_vitrified);

        initNavigationView();
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.nav_home:
                        if (mFragment instanceof HomeFragment) {
                            return true;
                        }

                        mFragment = HomeFragment.newInstance("main", "home");

                        FragmentTransaction fh = mFragmentManager.beginTransaction();
                        fh.replace(R.id.content_frame, mFragment, "home_tag");
                        fh.commit();

                        return true;
                    case R.id.nav_vitrified:

                        if (mFragment instanceof VitrifiedFragment) {
                            return true;
                        }
                        mFragment = VitrifiedFragment.newInstance("main", "vitrified");

                        FragmentTransaction fp = mFragmentManager.beginTransaction();
                        fp.replace(R.id.content_frame, mFragment, "vitrified_tag");
                        fp.commit();

                        AppUtils.showToast("vitrified", mContext);
                        return true;
                    case R.id.nav_ceramic:

                        if (mFragment instanceof CeramicFragment) {
                            return true;
                        }
                        mFragment = CeramicFragment.newInstance("main", "ceramic");

                        FragmentTransaction fo = mFragmentManager.beginTransaction();
                        fo.replace(R.id.content_frame, mFragment, "ceramic_tag");
                        fo.commit();

                        AppUtils.showToast("ceramic", mContext);
                        return true;
                    case R.id.nav_full:

                        if (mFragment instanceof FullFragment) {
                            return true;
                        }
                        mFragment = FullFragment.newInstance("main", "full");

                        FragmentTransaction fu = mFragmentManager.beginTransaction();
                        fu.replace(R.id.content_frame, mFragment, "full_tag");
                        fu.commit();

                        AppUtils.showToast("full", mContext);
                        return true;
                    case R.id.nav_porcelain:

                        if (mFragment instanceof PorcelainFragment) {
                            return true;
                        }
                        mFragment = PorcelainFragment.newInstance("main", "porcelain");

                        FragmentTransaction fq = mFragmentManager.beginTransaction();
                        fq.replace(R.id.content_frame, mFragment, "porcelain_tag");
                        fq.commit();

                        AppUtils.showToast("porcelain", mContext);
                        return true;
                    case R.id.nav_rustic:

                        if (mFragment instanceof RusticFragment) {
                            return true;
                        }
                        mFragment = RusticFragment.newInstance("main", "rustic");

                        FragmentTransaction ft = mFragmentManager.beginTransaction();
                        ft.replace(R.id.content_frame, mFragment, "rustic_tag");
                        ft.commit();

                        AppUtils.showToast("rustic", mContext);
                        return true;
                    case R.id.nav_contact:
                        if (mFragment instanceof ContactFragment) {
                            return true;
                        }

                        mFragment = ContactFragment.newInstance("main", "contact");

                        FragmentTransaction fc = mFragmentManager.beginTransaction();
                        fc.replace(R.id.content_frame, mFragment, "contact_tag");
                        fc.commit();

                        return true;
                }


                return false;
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
//            case R.id.action_link:
//                AppUtils.showWebPage(ShareUtils.REPOGITORY_URL, this);
//                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
