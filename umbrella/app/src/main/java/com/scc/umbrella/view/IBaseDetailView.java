package com.scc.umbrella.view;

import com.scc.umbrella.model.CommentList;
import com.scc.umbrella.model.NewsDetail;

/**
 * Created by chenjun on 18/3/17.
 */

public interface IBaseDetailView {
    void onGetCommentSuccess(CommentList response);

    void onGetNewsDetailSuccess(NewsDetail response);
}
