package com.scc.umbrella.ui.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
import com.scc.umbrella.base.BaseFragment;
import com.scc.umbrella.model.Channel;

/**
 * Created by chenjun on 18/3/17.
 */

public class ChannelPagerAdapter extends FragmentPagerAdapter {
    private final FragmentManager mFm;
    private List<BaseFragment> fragments;
    private List<Channel> mChannels;
    private int mChildCount;
    private boolean[] fragmentsUpdateFlag;

    public ChannelPagerAdapter(FragmentManager fm, List<BaseFragment> fragments, List<Channel> channels) {
        super(fm);
        mFm = fm;
        this.fragments = fragments;
        this.mChannels = channels;
    }

    @Override
    public BaseFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return mChannels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels == null ? "" : mChannels.get(position).Title;
    }

//    @Override
//    public void notifyDataSetChanged() {
//        mChildCount = getCount();
//        super.notifyDataSetChanged();
//    }



    @Override
    public int getItemPosition(Object object) {
//        if (mChildCount > 0) {
//            mChildCount--;
        return POSITION_NONE;
//        }
//        return super.getItemPosition(object);
    }
}
