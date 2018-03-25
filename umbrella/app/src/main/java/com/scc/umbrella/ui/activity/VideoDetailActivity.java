package com.scc.umbrella.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import com.scc.umbrella.ui.view.NewsDetailHeaderView;
import com.scc.umbrella.R;
import com.scc.umbrella.model.NewsDetail;
import com.scc.umbrella.utils.ConstanceValue;
import com.scc.umbrella.ui.view.EasyJCVideoPlayer;
import com.scc.umbrella.utils.VideoPathDecoder;
import com.scc.umbrella.model.Video;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by chenjun on 18/3/20.
 */

public class VideoDetailActivity extends BaseNewsActivity {

    @BindView(R.id.videoPlayer)
    EasyJCVideoPlayer mVideoPlayer;
    private NewsDetailHeaderView mHeaderView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_video_detail);
        super.loadViewLayout();
    }

    @Override
    public View createHeader() {
        return mHeaderView = new NewsDetailHeaderView(this);
    }

    public static void start(Context context, String url) {
        Intent intent = new Intent(context, VideoDetailActivity.class);
        intent.putExtra(ConstanceValue.URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onUriLoad(Uri uri) {
        Logger.i(uri.toString());
    }


    @Override
    public void onGetNewsDetailSuccess(NewsDetail response) {
        response.content = "";
        mHeaderView.setDetail(response);

        VideoPathDecoder decoder = new VideoPathDecoder() {
            @Override
            public void onSuccess(Video video) {
                mVideoPlayer.setUp(video.main_url, JZVideoPlayer.SCREEN_WINDOW_LIST, "");
                mVideoPlayer.startVideo();
            }

            @Override
            public void onDecodeError(Throwable e) {

            }
        };
        decoder.decodePath(response.url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoPlayer != null) {
            mVideoPlayer.release();
            mVideoPlayer = null;
        }
    }
}
