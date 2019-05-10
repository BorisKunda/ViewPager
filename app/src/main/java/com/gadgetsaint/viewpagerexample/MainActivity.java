package com.gadgetsaint.viewpagerexample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gadgetsaint.viewpagerexample.fragments.FragmentOne;
import com.gadgetsaint.viewpagerexample.fragments.FragmentThree;
import com.gadgetsaint.viewpagerexample.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewPager = (ViewPager) findViewById(R.id.pager);//view consisting of pages
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne());
        adapter.addFragment(new FragmentTwo());
        adapter.addFragment(new FragmentThree());

        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);//layouts of tabs themselves
        tabLayout.setupWithViewPager(mViewPager);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);//slide to specific tab programmatically
            }
        });



    }


    // Adapter for the viewpager using FragmentPagerAdapter
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {//in Fragment PagerAdapter onSaveInstanceState not called
                                                                      //apparaently because onDestroy + onDetach not called
                                                                      //this why I used FragmentStatePagerAdapter in order
                                                                      //to save state of all tabs

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final String[] mFragmentTitlesArr = {"Tab1", "Tab2", "Tab3"};


        private ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        private void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitlesArr[position];
        }



    }






}
