package com.scc.umbrella.theme.colorUi.widget;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.scc.umbrella.theme.colorUi.ColorUiInterface;
import com.scc.umbrella.theme.colorUi.util.ViewAttributeUtil;
/**
 * Created by chenjun on 18/3/25.
 */

public class ColorLinearLayout extends LinearLayout implements ColorUiInterface {

    private int attr_backgound = -1;

    public ColorLinearLayout(Context context) {
        super(context);
    }

    public ColorLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_backgound = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_backgound = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if(attr_backgound != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, themeId, attr_backgound);
        }
    }
}
