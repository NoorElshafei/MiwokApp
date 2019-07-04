package com.example.lessononemultiscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MiwokViewPagerAdapter extends FragmentPagerAdapter {

    public MiwokViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new NumbersFragment();
        } else if (i == 1){
            return new ColorFragment();
        } else if (i == 2) {
            return new PhrasesFragment();
        }else {
            return new FamilyFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
