package com.scc.umbrella.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import com.scc.umbrella.model.News;
import com.scc.umbrella.R;
import com.scc.umbrella.ui.view.EasyJCVideoPlayer;
import com.scc.umbrella.utils.DateUtils;
import com.scc.umbrella.utils.VideoPathDecoder;
import com.scc.umbrella.utils.ImageLoaderUtils;
import com.scc.umbrella.model.Video;
import cn.jzvd.JZVideoPlayerStandard;
import cn.jzvd.JZVideoPlayer;
import com.scc.umbrella.theme.colorUi.util.ColorUiUtil;

/**
 * Created by chenjun on 18/3/22.
 */

public class VideoAdapter extends BaseQuickAdapter<News> {
    public VideoAdapter(List<News> data) {
        super(R.layout.item_video_list, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, final News news) {
        ColorUiUtil.changeTheme(baseViewHolder.convertView, mContext.getTheme());
        final EasyJCVideoPlayer videoPlayer = baseViewHolder.getView(R.id.videoPlayer);
        ImageLoaderUtils.displayAvatar(news.media_avatar_url, (ImageView) baseViewHolder.getView(R.id.ivAvatar));
        ImageLoaderUtils.displayImage(news.image_url, videoPlayer.thumbImageView);
        videoPlayer.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        baseViewHolder
//                .setText(R.id.tvDuration, news.video_duration_str)
                .setText(R.id.tvFrom, news.source)
                .setText(R.id.tvCommentCount, news.comments_count + "");
        videoPlayer.titleTextView.setText(news.title);
        videoPlayer.setDurationText(news.video_duration_str);
        if (news.video == null) {
            //由于地址加密，所以抽出一个类专门解析播放地址
            VideoPathDecoder decoder = new VideoPathDecoder() {
                @Override
                public void onSuccess(Video s) {
                    news.video = s;
                    setPlayer(videoPlayer, news);
                }

                @Override
                public void onDecodeError(Throwable e) {

                }
            };
            decoder.decodePath(news.source_url);
        } else {
            setPlayer(videoPlayer, news);
        }

    }

    private void setPlayer(JZVideoPlayerStandard videoPlayer, News news) {
        videoPlayer.setUp(news.video.main_url, JZVideoPlayer.SCREEN_WINDOW_LIST, news.title);
    }
}