package com.scc.umbrella.utils;

import android.widget.Toast;
import com.scc.umbrella.base.BaseApplication;

/**
 * Created by chenjun on 18/3/11.
 */

public class ToastUtils {
    private static Toast mToast;

    /**
     * 显示Toast
     */
    public static void showToast( CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }
}
