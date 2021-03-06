package com.scc.umbrella.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scc.umbrella.base.BaseFragment;
import com.scc.umbrella.R;
import com.scc.umbrella.utils.ConstanceValue;
import cn.jzvd.JZVideoPlayer;
/**
 * Created by chenjun on 18/3/17.
 */

public class VideoFragment extends BasePagerFragment {
    private String[] titles = new String[]{"全部", "逗比剧", "音乐台", "看天下", "小品", "唱将", "最娱乐"};
    private String[] titlesCode = new String[]{"video", "subv_funny", "subv_voice", "subv_society", "subv_comedy", "subv_haoshengyin", "subv_entertainment"};


    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_video, null);
    }

    @Override
    protected String[] getTitles() {
        return titles;
    }

    @Override
    protected BaseFragment getFragment(int position) {

        return VideoFragment.newInstance(titlesCode[position]);
    }


    public static VideoListFragment newInstance(String code) {
        VideoListFragment fragment = new VideoListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstanceValue.DATA, code);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void bindViews(View view) {
        super.bindViews(view);
    }

    @Override
    protected void processLogic() {
        super.processLogic();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        JZVideoPlayer.releaseAllVideos();
    }
}
