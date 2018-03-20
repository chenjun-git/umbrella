package com.scc.umbrella.presenter;
import com.scc.umbrella.base.BasePresenter;
import com.scc.umbrella.view.IVideoDetailView;
import com.scc.umbrella.view.INewsDetailView;
/**
 * Created by chenjun on 18/3/17.
 */

public class NewsDetailPresenter extends BaseDetailPresenter {
    public NewsDetailPresenter(INewsDetailView mvpView) {
        super(mvpView);
    }
}
