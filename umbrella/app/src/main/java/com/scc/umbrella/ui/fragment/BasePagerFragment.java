package com.scc.umbrella.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.scc.umbrella.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.scc.umbrella.R;
import com.scc.umbrella.ui.view.colortrackview.ColorTrackTabLayout;
import com.scc.umbrella.ui.adapter.TitlePagerAdapter;

/**
 * Created by chenjun on 18/3/17.
 */

public abstract class BasePagerFragment extends BaseFragment {
    @BindView(R.id.tab)
    ColorTrackTabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    protected abstract String[] getTitles();

    protected abstract BaseFragment getFragment(int position);


    @Override
    protected void bindViews(View view) {
        ButterKnife.bind(this, rootView);
    }

    @Override
    protected void processLogic() {
        List<BaseFragment> fragments = new ArrayList<>();
        for (int i = 0; i < getTitles().length; i++) {
            BaseFragment fragment = getFragment(i);
            fragments.add(fragment);
        }
        vp.setAdapter(new TitlePagerAdapter(getChildFragmentManager(), fragments, getTitles()));
        tab.setTabPaddingLeftAndRight(20, 20);
        tab.setSelectedTabIndicatorHeight(0);
        tab.setupWithViewPager(vp);
        vp.setOffscreenPageLimit(getTitles().length);

    }

    @Override
    protected void setListener() {

    }
}
