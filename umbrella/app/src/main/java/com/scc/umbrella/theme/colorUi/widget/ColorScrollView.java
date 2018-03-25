package com.scc.umbrella.theme.colorUi.widget;

/**
 * Created by chenjun on 18/3/25.
 */

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.scc.umbrella.theme.colorUi.ColorUiInterface;
import com.scc.umbrella.theme.colorUi.util.ViewAttributeUtil;

public class ColorScrollView extends ScrollView implements ColorUiInterface {

    private int attr_background = -1;

    public ColorScrollView(Context context) {
        super(context);
    }

    public ColorScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if(attr_background != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_background);
        }
    }
}