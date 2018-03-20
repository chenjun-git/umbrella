package com.scc.umbrella.presenter;

import com.orhanobut.logger.Logger;

import java.util.List;
import com.scc.umbrella.base.BasePresenter;
import com.scc.umbrella.view.INewsListView;
import com.scc.umbrella.model.News;
import com.scc.umbrella.base.AppClient;
/**
 * Created by chenjun on 18/3/17.
 */

public class NewsListPresenter extends BasePresenter<INewsListView> {
    public NewsListPresenter(INewsListView mvpView) {
        super(mvpView);
    }

    public void getNewsList(String titleCode) {
        addSubscription(AppClient.getApiService().getNews(titleCode), new SubscriberCallBack<List<News>>() {
            @Override
            protected void onSuccess(List<News> response) {
                Logger.i(response.toString());
                mvpView.onGetNewsListSuccess(response);

            }

            @Override
            protected void onError() {
                super.onError();
                mvpView.onError();
            }
        });
    }
}
