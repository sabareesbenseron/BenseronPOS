package com.example.saku1.benseronemv.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.saku1.benseronemv.Adapter.HomePageAdapter;
import com.example.saku1.benseronemv.Fragment.CloseFragment;
import com.example.saku1.benseronemv.Fragment.OpenFragment;
import com.example.saku1.benseronemv.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button openBtn, cancelBtn;
    FrameLayout container;

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initActionListener();

        setupTabLayout();
    }

    private void initViews() {
        openBtn = (Button) findViewById(R.id.main_open_btn);
        cancelBtn = (Button) findViewById(R.id.main_closed_btn);
        container = (FrameLayout) findViewById(R.id.main_container);

        tabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
    }

    private void setupTabLayout(){
        List<String> titleList = new ArrayList<>();
        titleList.add("Open");
        titleList.add("Close");

        List<Fragment> fragmentList = new ArrayList<>();
        OpenFragment openFragment = new OpenFragment();
        CloseFragment closeFragment = new CloseFragment();

        fragmentList.add(openFragment);
        fragmentList.add(closeFragment);

        HomePageAdapter pageAdapter = new HomePageAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(pageAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }

    private void initActionListener() {
        openBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_open_btn:
                break;
            case R.id.main_closed_btn:
                break;
        }
    }
}
