package com.example.lessononemultiscreen;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MiwokViewPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public MiwokViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MiwokViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
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
