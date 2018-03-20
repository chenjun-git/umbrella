package com.scc.umbrella.base;

/**
 * Created by chenjun on 18/3/12.
 */

public abstract class HtmlSubscriberCallBack extends BaseCallBack<String> {
    @Override
    public void onNext(String response) {
        onSuccess(response);
    }

    protected abstract void onSuccess(String response);
}
