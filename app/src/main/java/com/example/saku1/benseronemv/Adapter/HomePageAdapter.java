package com.example.saku1.benseronemv.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by saku1 on 3/12/2017.
 */

public class HomePageAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList;
    List<String> titleList;

    public HomePageAdapter(FragmentManager fm, List<Fragment> fragmentList,
                           List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
