package com.scc.umbrella.ui.activity;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import com.scc.umbrella.model.Comment;
import com.scc.umbrella.utils.ImageLoaderUtils;
import com.scc.umbrella.R;

/**
 * Created by chenjun on 18/3/20.
 */

public class CommentAdapter extends BaseQuickAdapter<Comment> {
    public CommentAdapter(List<Comment> data) {
        super(R.layout.item_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Comment comment) {
        ImageLoaderUtils.displayAvatar(comment.user.avatar_url, (ImageView) baseViewHolder.getView(R.id.ivAvatar));
        baseViewHolder
                .setText(R.id.ss_user, comment.user.name)
                .setText(R.id.tvLikeCount, comment.digg_count + "")
                .setText(R.id.content, comment.text);
    }
}
