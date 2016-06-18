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
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.appcutt.demo.R;
import com.appcutt.demo.fragment.FullFragment;
import com.appcutt.demo.imageloader.ImageLoaderUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FullActivity extends AppCompatActivity implements AbsListView.OnScrollListener {

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

        mFragmentManager = getSupportFragmentManager();
        mFragment = FullFragment.newInstance("main", "full");

        FragmentTransaction fp = mFragmentManager.beginTransaction();
        fp.replace(R.id.content_frame, mFragment, "full_tag");
        fp.commit();

        navigationView.setCheckedItem(R.id.nav_full);

        // 初始化图片缓存
        ImageLoaderUtil.initImageLoader(this);
        initNavigationView();
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                Intent intent;
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.nav_vitrified:
                        intent = new Intent(FullActivity.this,VitrifiedActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_ceramic:
                        intent = new Intent(FullActivity.this,CeramicActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_full:
                        return true;
                    case R.id.nav_porcelain:
                        intent = new Intent(FullActivity.this,PorcelainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_rustic:
                        intent = new Intent(FullActivity.this,RusticActivity.class);
                        startActivity(intent);
                        return true;
//                    case R.id.nav_contact:
//                        return true;
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
