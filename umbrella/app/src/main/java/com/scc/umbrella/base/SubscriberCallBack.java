package com.scc.umbrella.base;

import android.text.TextUtils;
import com.scc.umbrella.utils.ToastUtils;

/**
 * Created by chenjun on 18/3/12.
 */

public abstract class SubscriberCallBack <T> extends BaseCallBack<ResultResponse<T>> {


    @Override
    public void onNext(ResultResponse response) {
        boolean isSuccess = (!TextUtils.isEmpty(response.message) && response.message.equals("success"))
                || !TextUtils.isEmpty(response.success) && response.success.equals("true");
        if (isSuccess) {
            onSuccess((T) response.data);
        } else {
            ToastUtils.showToast(response.message);
            onFailure(response);
        }
    }

    protected abstract void onSuccess(T response);
}
