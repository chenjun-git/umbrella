package com.scc.umbrella.presenter;
import com.scc.umbrella.base.BasePresenter;
import com.scc.umbrella.view.IBaseDetailView;
import com.scc.umbrella.base.AppClient;
import com.scc.umbrella.base.SubscriberCallBack;
import com.scc.umbrella.model.CommentList;
import com.scc.umbrella.model.NewsDetail;
/**
 * Created by chenjun on 18/3/17.
 */

public class BaseDetailPresenter extends BasePresenter<IBaseDetailView> {
    public BaseDetailPresenter(IBaseDetailView mvpView) {
        super(mvpView);
    }

    public void getComment(String group_id, String item_id, int pageNow) {
        int offset = (pageNow - 1) * 10;
        addSubscription(AppClient.getApiService().getComment(group_id, item_id, offset + "", "10"), new SubscriberCallBack<CommentList>() {
            @Override
            protected void onSuccess(CommentList response) {
                mvpView.onGetCommentSuccess(response);
            }

        });
    }

    public void getNewsDetail(String url) {
        addSubscription(AppClient.getApiService().getNewsDetail(url), new SubscriberCallBack<NewsDetail>() {
            @Override
            protected void onSuccess(NewsDetail response) {
                mvpView.onGetNewsDetailSuccess(response);
            }

        });
    }
}
