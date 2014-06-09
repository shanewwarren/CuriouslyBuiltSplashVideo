package com.curiouslybuilt.splashvideo.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shanewarren on 6/7/14.
 */
public class CircularTextViewPagerAdapter extends FragmentPagerAdapter {

    private int mLoops = 1000;
    private int mFirstPage;
    private String[] mMessages;
    private int mActualSize;
    private ViewPager mViewPager;

    public CircularTextViewPagerAdapter(FragmentManager fragmentManager, String[] messages) {
        super(fragmentManager);
        mMessages = messages;
        mFirstPage = (mMessages.length * mLoops) / 2;
    }


    @Override
    public int getCount() {
        return mLoops * mMessages.length;
    }

    public int getActualCount() {
        return mMessages.length;
    }

    public int getFirstPage() {
        return mFirstPage;
    }


    @Override
    public Fragment getItem(int position) {

        Bundle data = new Bundle();

        position = position % mMessages.length;
        data.putString("Message", mMessages[position]);


        SimpleTextViewFragment simpleTextViewFragment = new SimpleTextViewFragment();
        simpleTextViewFragment.setArguments(data);

        return simpleTextViewFragment;
    }


}
