package com.scc.umbrella.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scc.umbrella.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

import com.scc.umbrella.utils.ImageLoaderUtils;
import com.scc.umbrella.utils.RxCountDown;
import com.scc.umbrella.R;
import com.scc.umbrella.ui.activity.MainActivity;

/**
 * Created by chenjun on 18/3/17.
 */

public class SplashActivity extends BaseActivity {
    final int COUT_DOWN_TIME = 5;
    @BindView(R.id.banner_view)
    ImageView mBannerView;
    @BindView(R.id.splash_view)
    ImageView mSplashView;
    @BindView(R.id.skip_real)
    TextView mSkipReal;
    @BindView(R.id.guide_fragment)
    FrameLayout mGuideFragment;
    @BindView(R.id.ad_click_small)
    ImageView mAdClickSmall;
    @BindView(R.id.ad_click)
    LinearLayout mAdClick;
    @BindView(R.id.ad_skip_loading)
    ImageView mAdSkipLoading;
    @BindView(R.id.ad_ignore)
    FrameLayout mAdIgnore;
    @BindView(R.id.splash_video_frame)
    FrameLayout mSplashVideoFrame;
    @BindView(R.id.splash_video_layout)
    RelativeLayout mSplashVideoLayout;
    private Subscription mSubscription;

    @Override
    protected void bindViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.splash_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mSubscription = RxCountDown.countDown(COUT_DOWN_TIME)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        ImageLoaderUtils.displayBigImage("http://www.3vsheji.com/uploads/allimg/151222/1F92594D_0.jpg", mSplashView);
                        mAdClickSmall.setVisibility(View.VISIBLE);
                        mSplashView.setVisibility(View.VISIBLE);
                        mAdIgnore.setVisibility(View.VISIBLE);
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        goMain();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        mSkipReal.setText(TextUtils.concat(integer.intValue() + "s", getResources().getString(R.string.splash_ad_ignore)));
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.skip_real)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skip_real:
                goMain();
                break;
        }
    }

    private void goMain() {
        if (mSubscription != null && !mSubscription.isUnsubscribed())
            mSubscription.unsubscribe();
        intent2Activity(MainActivity.class);
        finish();
    }
}
