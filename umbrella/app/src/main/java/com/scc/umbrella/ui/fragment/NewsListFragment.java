package com.scc.umbrella.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scc.umbrella.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.scc.umbrella.R;
import com.scc.umbrella.model.News;
import com.scc.umbrella.ui.view.LoadingFlashView;
import com.scc.umbrella.view.INewsListView;
import com.scc.umbrella.presenter.NewsListPresenter;
import com.scc.umbrella.base.BaseMvpFragment;
import com.scc.umbrella.utils.ConstanceValue;
import com.scc.umbrella.ui.adapter.NewsAdapter;
import com.scc.umbrella.ui.activity.BaseNewsActivity;

/**
 * Created by chenjun on 18/3/17.
 */

public class NewsListFragment extends BaseMvpFragment<NewsListPresenter> implements INewsListView {

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.loadingView)
    LoadingFlashView loadingView;
    private String mTitleCode = "";
    protected List<News> mDatas = new ArrayList<>();
    protected BaseQuickAdapter mAdapter;

    @Override
    protected NewsListPresenter createPresenter() {
        return new NewsListPresenter(this);
    }

    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        View v = inflater.inflate(R.layout.layout_recyclerview, null);
        ButterKnife.bind(this, v);
        return v;
    }

    public static NewsListFragment newInstance(String code) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstanceValue.DATA, code);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void bindViews(View view) {
    }

    @Override
    protected void processLogic() {
        initCommonRecyclerView(createAdapter(), null);
        mTitleCode = getArguments().getString(ConstanceValue.DATA);
//        srl.measure(0, 0);
//        srl.setRefreshing(true);
    }

    protected BaseQuickAdapter createAdapter() {
        return mAdapter = new NewsAdapter(mDatas);
    }


    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        if (TextUtils.isEmpty(mTitleCode))
            mTitleCode = getArguments().getString(ConstanceValue.DATA);
        if (mvpPresenter.mvpView == null)
            mvpPresenter = createPresenter();
        getData();
    }

    private void getData() {
        if (mDatas.size() == 0) {

            //没加载过数据
            if (loadingView == null) loadingView = get(R.id.loadingView);
            loadingView.setVisibility(View.VISIBLE);
            loadingView.showLoading();
        }
        mvpPresenter.getNewsList(mTitleCode);
    }

    @Override
    protected void setListener() {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        mAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                News news = mDatas.get(i);
                ///item_seo_url的值是item/6412427713050575361/  ,取出6412427713050575361
                String itemId = news.item_seo_url.replace("item/", "").replace("/", "");
                StringBuffer urlSb = new StringBuffer("http://m.toutiao.com/");
                if (!itemId.startsWith("i"))
                    urlSb.append("i");
                urlSb.append(itemId).append("/info/");
                String url = urlSb.toString();
                if (news.article_genre.equals(ConstanceValue.ARTICLE_GENRE_VIDEO)) {
                    //视频
                    BaseNewsActivity.startVideo(mContext, url, news.group_id, itemId);
                } else {
                    BaseNewsActivity.startNews(mContext, url, news.group_id, itemId);
                }
            }
        });
    }


    @Override
    public void onGetNewsListSuccess(List<News> response) {
        //由于最后一条重复 ，删除掉
        if (response.size() > 0) {
            response.remove(response.size() - 1);
            loadingView.setVisibility(View.GONE);
        }
        srl.setRefreshing(false);
        mDatas.addAll(0, response);
        mAdapter.notifyItemRangeChanged(0, response.size());
    }

    @Override
    public void onError() {
        srl.setRefreshing(false);
    }
}
