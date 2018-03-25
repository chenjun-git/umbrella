package com.scc.umbrella.theme.colorUi.widget;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsoluteLayout;

import com.scc.umbrella.theme.colorUi.ColorUiInterface;
import com.scc.umbrella.theme.colorUi.util.ViewAttributeUtil;
/**
 * Created by chenjun on 18/3/25.
 */

public class ColorAbsoluteLayout extends AbsoluteLayout implements ColorUiInterface {

    private int attr_background = -1;

    public ColorAbsoluteLayout(Context context) {
        super(context);
    }

    public ColorAbsoluteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorAbsoluteLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
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