package com.scc.umbrella.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.scc.umbrella.R;
import cn.jzvd.JZVideoPlayerStandard;
/**
 * Created by chenjun on 18/3/22.
 */

public class EasyJCVideoPlayer extends JZVideoPlayerStandard {

    private LinearLayout llDuration;
    private TextView tvDuration;

    public EasyJCVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EasyJCVideoPlayer(Context context) {
        super(context);
    }

    @Override
    public void init(Context context) {
        super.init(context);
        llDuration = (LinearLayout) findViewById(R.id.llDuration);
        tvDuration = (TextView) findViewById(R.id.tvDuration);
    }


    @Override
    public void setState(int state) {
        super.setState(state);
        switch (currentState) {
            case CURRENT_STATE_PREPARING:
                //隐藏时长
                llDuration.setVisibility(View.GONE);
                break;
            case CURRENT_STATE_AUTO_COMPLETE:
            case CURRENT_STATE_ERROR:
                //显示时长
                llDuration.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onCompletion() {
        super.onCompletion();
        //显示时长
        llDuration.setVisibility(View.VISIBLE);
    }

    public void setDurationText(String text) {
        tvDuration.setText(text);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_easy_video_player;
    }
}