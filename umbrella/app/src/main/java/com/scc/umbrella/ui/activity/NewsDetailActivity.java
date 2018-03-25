package com.scc.umbrella.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import com.scc.umbrella.R;
import com.scc.umbrella.ui.view.NewsDetailHeaderView;
import com.scc.umbrella.model.NewsDetail;

/**
 * Created by chenjun on 18/3/20.
 */

public class NewsDetailActivity extends BaseNewsActivity {

    @BindView(R.id.back_btn)
    ImageView backBtn;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.share_btn)
    ImageView shareBtn;
    private NewsDetailHeaderView mHeaderView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_news_detail);
        super.loadViewLayout();
    }

    @Override
    public View createHeader() {
        return mHeaderView = new NewsDetailHeaderView(this);
    }

    @OnClick(R.id.back_btn)
    public void onBackClick(View view) {
        finish();
    }


    @Override
    public void onGetNewsDetailSuccess(NewsDetail response) {
        mHeaderView.setDetail(response);
    }

}
